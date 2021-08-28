package com.github.jm27.lendingApplication.borrowers.controller;

import com.github.jm27.lendingApplication.borrowers.domain.Borrower;
import com.github.jm27.lendingApplication.borrowers.repository.BorrowerRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;

@Component
public class BorrowerController {
    private BorrowerRepository borrowerRepository;

    public BorrowerController(BorrowerRepository borrowerRepository){
        this.borrowerRepository = borrowerRepository;
    }

    // Get all borrowers
    public Mono<ServerResponse> getAll(ServerRequest req) {
        return ServerResponse.ok().body(this.borrowerRepository.findAll(), Borrower.class);
    }

    // Create Borrower
    public Mono<ServerResponse> create(ServerRequest req){
        return req.bodyToMono(Borrower.class)
                .flatMap(borrower -> this.borrowerRepository.save(borrower))
                .flatMap(borrower -> ServerResponse.created(URI.create("/borrowers/" + borrower.getId())).build());
    }
}
