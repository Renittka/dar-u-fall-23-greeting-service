package kz.dar.university.greetingservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kz.dar.university.greetingservice.domain.Greeting;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SendService {

    private final KafkaTemplate<String, Greeting> kafkaTemplate;

    @Value("${spring.kafka.task.topic}")
    private String topicName;

    public void sendMessage(Greeting msg) {
        kafkaTemplate.send(topicName, msg);
    }


}
