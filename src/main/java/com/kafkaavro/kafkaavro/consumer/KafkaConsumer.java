package com.kafkaavro.kafkaavro.consumer;


import com.kafkaavro.dto.Employee;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @KafkaListener(topics = "${topic.name}")
    public void read(ConsumerRecord<String, Employee> consumerRecord) {
        String key = consumerRecord.key();
        Employee employee = consumerRecord.value();

        System.out.println("Avro message received for key : " + key + " value : " + employee.toString());

    }


}
