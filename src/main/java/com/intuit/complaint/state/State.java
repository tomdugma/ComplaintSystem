package com.intuit.complaint.state;

import com.intuit.complaint.dto.ComplaintDTO;

public interface State {

    void handleComplaint(ComplaintDTO complaintDTO);
}
