package com.kafka.demo.handler;

import com.kafka.demo.producer.Producer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Component
public class MessageHandler {

    private final Producer producer;

    public Mono<ServerResponse> hello(ServerRequest request) {
        return producer.send("sample_topic", "sample_key","hello world!");
    }
}
