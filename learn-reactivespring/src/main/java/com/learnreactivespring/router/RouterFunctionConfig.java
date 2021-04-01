package com.learnreactivespring.router;

import com.learnreactivespring.handler.SampleHandleFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class RouterFunctionConfig {
    @Bean
    public RouterFunction<ServerResponse> rout(SampleHandleFunction handleFunction){

        return RouterFunctions
        .route(GET("/functional/flux").and(accept(APPLICATION_JSON)),handleFunction::flux)
                .andRoute(GET("/functional/mono").and(accept(APPLICATION_JSON)),handleFunction::mono);
    }



}
