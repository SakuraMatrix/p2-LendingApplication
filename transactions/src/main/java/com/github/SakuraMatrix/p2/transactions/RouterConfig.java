package com.github.SakuraMatrix.p2.transactions;

import com.github.SakuraMatrix.p2.transactions.controller.TransactionController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
@Configuration
public class RouterConfig {
    @Bean
    public RouterFunction<ServerResponse> routes(TransactionController transactionController) {
        return route(GET("/transactions"), transactionController::getAll)
                .andRoute(POST("/transactions"), transactionController::create);
//                .andRoute(GET("/transactions/{id}"),transactionController::get);

    }
}
