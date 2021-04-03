package com.kafka.demo.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import reactor.kafka.sender.KafkaSender;

@Slf4j
@RequiredArgsConstructor
@Component
public class Producer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    private final KafkaSender kafkaSender;

    public Mono<ServerResponse> send(String topic, String key, Object value) {
        return kafkaSender.createOutbound()
                .send(Mono.just(kafkaTemplate.send(topic, key, (String) value)))
                .then()
                .map(ret -> true)
                .onErrorResume(e -> {
                    return Mono.just(false);
                });
    }
}
