package com.github.jm27.lendingApplication.borrowers.router;

import com.github.jm27.lendingApplication.borrowers.controller.BorrowerController;
import com.github.jm27.lendingApplication.borrowers.controller.BorrowerLoanRequestController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterConfig {
    @Bean
    public RouterFunction<ServerResponse> routes(BorrowerController borrowerController,
                                                 BorrowerLoanRequestController borrowerLoanRequestController)
    {
        return route(GET("/borrowers"), borrowerController::getAll)
                .andRoute(POST("/borrowers"), borrowerController::create)
                .andRoute(GET("/borrowers/borrowers-requests"), borrowerLoanRequestController::getAll)
                .andRoute(POST("/borrowers/borrowers-requests"), borrowerLoanRequestController::create);
    }
}
