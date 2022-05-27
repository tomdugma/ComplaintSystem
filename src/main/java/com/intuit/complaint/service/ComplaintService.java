package com.intuit.complaint.service;

import com.intuit.complaint.dto.ComplaintDTO;
import com.intuit.complaint.dto.PurchaseDTO;
import com.intuit.complaint.dto.UserDTO;
import com.intuit.complaint.model.ComplaintModel;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import com.intuit.complaint.kafka.kafkaProducer;
import com.intuit.complaint.repository.ComplaintRepository;
import org.springframework.web.client.RestTemplate;


@Service
public class ComplaintService {

    @Autowired
    ComplaintRepository complaintRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    kafkaProducer complaintProducer;

    public String enqueueComplaint(ComplaintDTO resource) {
        resource.setComplaintId(UUID.randomUUID());
        complaintProducer.sendComplaint(resource);
        return resource.getComplaintId().toString();
    }

    public ComplaintModel getById(UUID id) {
        ComplaintModel complaint = complaintRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(String.format("complaint id [%s] not found", id.toString())));
        return complaint;
    }

    public void processComplaint(ComplaintDTO complaintDTO) {
        URI serviceURL = URI.create("http://localhost:8081/users/" + complaintDTO.getUserId());
        UserDTO userDTO = restTemplate.getForObject(serviceURL, UserDTO.class);
        serviceURL = URI.create("http://localhost:8081/purchases/" + complaintDTO.getPurchaseId());
        PurchaseDTO purchaseDTO = restTemplate.getForObject(serviceURL, PurchaseDTO.class);
        ComplaintModel complaintModel = ComplaintModel.builder()
                .complaintId(complaintDTO.getComplaintId())
                .complaint(complaintDTO.getComplaint())
                .subject(complaintDTO.getSubject())
                .userId(complaintDTO.getUserId())
                .purchaseId(complaintDTO.getPurchaseId())
                .purchaseInfo(purchaseDTO)
                .userInfo(userDTO)
                .build();

        complaintRepository.save(complaintModel);
    }
}
