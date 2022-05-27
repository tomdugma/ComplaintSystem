package com.intuit.complaint.repository;

import com.intuit.complaint.model.ComplaintModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface ComplaintRepository extends MongoRepository<ComplaintModel, UUID> {
}
