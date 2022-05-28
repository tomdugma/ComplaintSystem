package com.intuit.complaint.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ComplaintModel)) return false;
        ComplaintModel that = (ComplaintModel) o;
        return Objects.equals(getComplaintId(), that.getComplaintId()) && Objects.equals(getComplaint(), that.getComplaint()) && Objects.equals(getSubject(), that.getSubject()) && Objects.equals(getUserId(), that.getUserId()) && Objects.equals(getPurchaseId(), that.getPurchaseId()) && Objects.equals(getUserInfo(), that.getUserInfo()) && Objects.equals(getPurchaseInfo(), that.getPurchaseInfo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getComplaintId(), getComplaint(), getSubject(), getUserId(), getPurchaseId(), getUserInfo(), getPurchaseInfo());
    }
}
