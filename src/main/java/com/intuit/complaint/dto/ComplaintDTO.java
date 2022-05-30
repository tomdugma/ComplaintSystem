package com.intuit.complaint.dto;

import java.util.Objects;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

//import com.intuit.complaint.status.ComplaintStatusEnum;
import com.intuit.complaint.constants.ComplaintStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ComplaintDTO {


    @NotNull(message = "user id is required")
    private UUID userId;

    @NotBlank(message = "subject is required")
    private String subject;

    @NotBlank(message = "complaint description is required")
    private String complaint;

    private UUID purchaseId;

    private UUID complaintId;

    private ComplaintStatusEnum complaintStatusEnum;

}
