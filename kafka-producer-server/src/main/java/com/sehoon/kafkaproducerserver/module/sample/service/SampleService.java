package com.sehoon.kafkaproducerserver.module.sample.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SampleService {
    private static final String TOPIC = "test-topic2";

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(TOPIC, message);
        
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Message sent successfully to topic: " + TOPIC);
            } else {
                System.err.println("Failed to send message to topic: " + TOPIC);
            }
        });
    }
}
