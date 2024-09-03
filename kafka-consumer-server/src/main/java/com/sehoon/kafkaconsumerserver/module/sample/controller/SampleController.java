package com.sehoon.kafkaconsumerserver.module.sample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sehoon.kafkaconsumerserver.module.sample.service.SampleService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/sample")
public class SampleController {
    private final SampleService sampleService;

    @GetMapping("/admin-client")
    public void adminClient() throws Exception {
        sampleService.getKafkaAdmin();
    }
}
