package com.intuit.complaint.kafka;
import com.intuit.complaint.dto.ComplaintDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;



@Component
public class kafkaProducer {

    @Autowired
    KafkaTemplate<String, ComplaintDTO> kafkaTemplate;

    @Value("${kafka.topic}")
    String topic;

    public void sendComplaint(ComplaintDTO message) {
        kafkaTemplate.send(topic, message);
    }
}
