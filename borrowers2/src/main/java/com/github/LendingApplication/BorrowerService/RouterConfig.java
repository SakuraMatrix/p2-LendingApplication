package com.github.LendingApplication.BorrowerService;

import com.github.LendingApplication.BorrowerService.BorrowerController;
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
    public RouterFunction<ServerResponse> routes(BorrowerController borrowerController) {

        return route(GET("/borrowers2"), borrowerController::all)
                .andRoute(POST("/borrowers2"), borrowerController::create)
                .andRoute(GET("/borrowers2/{id}"), borrowerController::get)
                .andRoute(PUT("/borrowers2/{id}"), borrowerController::update)
                .andRoute(DELETE("/borrowers2/{id}"),borrowerController::delete);
    }
}
