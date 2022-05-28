package com.intuit.complaint.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.intuit.complaint.dto.ComplaintDTO;
import com.intuit.complaint.model.ComplaintModel;
import com.intuit.complaint.repository.ComplaintRepository;
import com.intuit.complaint.service.ComplaintService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ComplaintControllerTest {

    @Mock
    protected ComplaintService complaintService;

    @Mock
    protected ComplaintController complaintController;

    @Mock
    protected ComplaintRepository complaintRepository;

    @Test
    @Order(1)
    void getComplaint() throws Exception {
        // given
        String getUrl = "45832d6c-9ebb-4b17-9242-85677e25a471";
        ComplaintModel complaintModel = complaintService.getById(UUID.fromString(getUrl));

        // preparation
        String complaintModelFile = new String(Files.readAllBytes(Paths.get("src/test/resources/complaintModel.json")));
        ComplaintModel complaintModelLocal = new Gson().fromJson(complaintModelFile,ComplaintModel.class);

        // then
        //TODO check why result return as null
        assertEquals(complaintModel,complaintModelLocal);

    }

    @Test
    @Order(2)
    void registerComplaint() throws Exception {
        // preparation
        String registerComplaint = new String(Files.readAllBytes(Paths.get("src/test/resources/registerComplaint.json")));
        ComplaintDTO registerComplaintAsJson = new Gson().fromJson(registerComplaint, ComplaintDTO.class);

        // expected
        String expected = "45832d6c-9ebb-4b17-9242-85677e25a471";

        // actual
        String result = complaintController.postComplaint(registerComplaintAsJson);

        //TODO check why result return as null
        assertEquals(expected,result);

    }
}
