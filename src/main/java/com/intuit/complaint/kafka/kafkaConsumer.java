package com.intuit.complaint.kafka;

import com.intuit.complaint.dto.ComplaintDTO;
import com.intuit.complaint.service.ComplaintService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class kafkaConsumer {

    @Autowired
    private ComplaintService complaintService;

    @KafkaListener(topics = "complaints-topic-for-online-market", groupId = "complaint-group-online-market",
            containerFactory = "complaintKafkaListenerFactory")
    public void consumeComplaint(ComplaintDTO complainMsg, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        log.info("Consumer now consume the following massage: " + complainMsg);
        complaintService.processComplaint(complainMsg);
    }

}
