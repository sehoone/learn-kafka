package com.sehoon.kafkaconsumerserver.module.sample.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sehoon.kafkaconsumerserver.module.sample.service.SampleService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/sample")
public class SampleController {
    private final SampleService sampleService;

    @PostMapping("/publish")
    public String publishMessage(@RequestParam("message") String message) {
        sampleService.sendMessage(message);
        return "Message published successfully";
    }
}
