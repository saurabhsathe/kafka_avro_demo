package com.kafkaavro.kafkaavro.controller;


import com.kafkaavro.kafkaavro.producer.KafkaProducer;
import com.kafkaavro.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {
    @Autowired
    private KafkaProducer producer;

    @PostMapping("/events")
    public String sendMessage(@RequestBody Employee employee) {
        producer.send(employee);
        return "message published !";
    }
}