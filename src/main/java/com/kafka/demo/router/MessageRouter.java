package com.kafka.demo.router;

import com.kafka.demo.handler.MessageHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@RequiredArgsConstructor
@Configuration
public class MessageRouter {

    @Bean
    public RouterFunction<ServerResponse> hello(MessageHandler messageHandler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/hello")
                        .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), messageHandler::hello);
    }
}
