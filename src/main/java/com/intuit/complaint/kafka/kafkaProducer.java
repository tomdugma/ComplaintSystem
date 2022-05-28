package com.intuit.complaint.kafka;
import com.intuit.complaint.dto.ComplaintDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class kafkaProducer {

    @Autowired
    KafkaTemplate<String, ComplaintDTO> kafkaTemplate;

    @Value("${kafka.topic}")
    String topic;

    public void sendComplaint(ComplaintDTO message) {
        log.info("Producer now produce the following massage: " + message.toString());
        kafkaTemplate.send(topic, message);
    }
}
