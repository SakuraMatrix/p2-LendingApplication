package com.github.LendingApplication.LenderService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;

@Configuration
public class RouterConfig {

    @Bean
    public RouterFunction<ServerResponse> routes(borrower3Controller lenderController) {

        return route(GET("/borrowers3"), lenderController::all)
                .andRoute(POST("/borrowers3"), lenderController::create)
                .andRoute(GET("/borrowers3/{id}"), lenderController::get)
                .andRoute(PUT("/borrowers3/{id}"), lenderController::update)
                .andRoute(DELETE("/borrowers3/{id}"),lenderController::delete);
    }
}
