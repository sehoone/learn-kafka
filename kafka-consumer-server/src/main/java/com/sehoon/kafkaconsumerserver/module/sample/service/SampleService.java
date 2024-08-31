package com.sehoon.kafkaconsumerserver.module.sample.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SampleService {
    private static final String TOPIC = "test-topic2";

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        kafkaTemplate.send(TOPIC, message);
    }

    @KafkaListener(topics = TOPIC, groupId = "kafka-consumer-server")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
    }
}
