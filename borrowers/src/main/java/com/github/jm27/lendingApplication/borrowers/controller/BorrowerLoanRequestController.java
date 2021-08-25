package com.github.jm27.lendingApplication.borrowers.controller;

import com.github.jm27.lendingApplication.borrowers.domain.BorrowerLoanRequest;
import com.github.jm27.lendingApplication.borrowers.repository.BorrowerLoanRequestRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;

@Component
public class BorrowerLoanRequestController {
    private BorrowerLoanRequestRepository borrowerLoanRequestRepository;

    public BorrowerLoanRequestController(BorrowerLoanRequestRepository borrowerLoanRequestRepository) {
        this.borrowerLoanRequestRepository = borrowerLoanRequestRepository;
    }

    // Get all Borrower Loan Requests
    public  Mono<ServerResponse> getAll(ServerRequest req){
        return ServerResponse.ok().body(this.borrowerLoanRequestRepository.findAll(), BorrowerLoanRequest.class);
    }

    // Create Borrower Loan Request
    public Mono<ServerResponse> create(ServerRequest req){
        return req.bodyToMono(BorrowerLoanRequest.class)
                .flatMap(loanRequest -> this.borrowerLoanRequestRepository.save(loanRequest))
                .flatMap(borrowerLoanRequest -> ServerResponse.created(URI.create("/borrowers/borrowers-requests/"
                        + borrowerLoanRequest.getBorrower_id())).build());
    }

    // Get Borrower's requests
}
