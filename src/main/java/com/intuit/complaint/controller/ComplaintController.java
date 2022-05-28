package com.intuit.complaint.controller;

import com.intuit.complaint.dto.ComplaintDTO;
import com.intuit.complaint.model.ComplaintModel;
import com.intuit.complaint.service.ComplaintService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@Slf4j
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    @PostMapping(path = "complaint/register", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public String postComplaint(@Valid @RequestBody ComplaintDTO complaintDTO) {
        try{
            log.info("inside post complaint, complaint: " + complaintDTO.toString());
            return complaintService.enqueueComplaint(complaintDTO);
        }catch (Exception e){
            log.error("failed to post complaint: " + complaintDTO.toString(), e);
        }
        return null;
    }

    @GetMapping(path = "complaint/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ComplaintModel getComplaintById(@PathVariable String id) {
        try{
            log.info("inside get complaint, complaint: " + id);
            return complaintService.getById(UUID.fromString(id));
        }catch (Exception e){
            log.error("failed to get complaint by id: " + id, e);
        }
        return null;
    }
}
