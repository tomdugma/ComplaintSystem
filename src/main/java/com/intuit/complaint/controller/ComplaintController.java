package com.intuit.complaint.controller;

import com.intuit.complaint.dto.ComplaintDTO;
import com.intuit.complaint.model.ComplaintModel;
import com.intuit.complaint.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    @PostMapping(path = "complaint/register", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public String postComplaint(@Valid @RequestBody ComplaintDTO complaintDTO) {
        return complaintService.enqueueComplaint(complaintDTO);
    }

    @GetMapping(path = "complaint/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ComplaintModel getComplaintById(@PathVariable String id) {
        return complaintService.getById(UUID.fromString(id));
    }
}
