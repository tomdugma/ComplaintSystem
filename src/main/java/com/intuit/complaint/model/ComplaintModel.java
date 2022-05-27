package com.intuit.complaint.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.intuit.complaint.dto.PurchaseDTO;
import com.intuit.complaint.dto.UserDTO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "complaint")
@ToString
public class ComplaintModel {

    @Id
    private UUID complaintId;

    private String complaint;

    private String subject;

    private UUID userId;

    private UUID purchaseId;

    @NotNull
    private UserDTO userInfo;

    @NotNull
    private PurchaseDTO purchaseInfo;

}
