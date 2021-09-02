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
    public RouterFunction<ServerResponse> routes(LenderController lenderController) {

        return route(GET("/lenders"), lenderController::all)
                .andRoute(POST("/lenders"), lenderController::create)
                .andRoute(GET("/lenders/{id}"), lenderController::get)
                .andRoute(GET("/lenders/transactions"),lenderController::getTransactions)
                .andRoute(GET("/lenders/{id}/transactions"),lenderController::getTransactions);
    }
}
