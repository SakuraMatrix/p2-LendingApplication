package com.github.jm27.lendingApplication.borrowers.controller;

import com.github.jm27.lendingApplication.borrowers.domain.Borrower;
import com.github.jm27.lendingApplication.borrowers.domain.Transaction;
import com.github.jm27.lendingApplication.borrowers.repository.BorrowerRepository;
import karate.com.linecorp.armeria.server.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.UUID;

@Component
public class BorrowerController {
    private BorrowerRepository borrowerRepository;

    @Autowired
    private WebClient.Builder webClientBuilder;

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
    // Get Borrower by ID
    public Mono<ServerResponse> getByID(ServerRequest req) {
        return this.borrowerRepository.findById(UUID.fromString(req.pathVariable("id")))
                .flatMap(borrower -> ServerResponse.ok().body(Mono.just(borrower), Borrower.class))
                .switchIfEmpty(ServerResponse.notFound().build());
    }
    // Update Borrower
    public Mono<ServerResponse> update(ServerRequest req) {
        return req.bodyToMono(Borrower.class).
                flatMap(update -> borrowerRepository.findById(update.getId()).flatMap(previous -> {
                    previous.setFirst_name(update.getFirst_name());
                    previous.setLast_name(update.getLast_name());
                    previous.setFunds(update.getFunds());
                    previous.setRating(update.getRating());
                    previous.setCredit_score(update.getCredit_score()); // UPDATE THIS
                    return borrowerRepository.save(previous)
                            .flatMap(saved -> ServerResponse.ok().build());
                })
                ).
                switchIfEmpty(ServerResponse.notFound().build());
    }

    // Delete Borrower
    public Mono<ServerResponse> delete(ServerRequest req) {
        return this.borrowerRepository.findById(UUID.fromString(req.pathVariable("id")))
                .flatMap(borrower -> this.borrowerRepository.delete(borrower)
                        .then(ServerResponse.ok().build())).switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> getTransactions(ServerRequest req) {

        return ServerResponse.ok().body(webClientBuilder.build()
                .get()
                .uri("http://localhost:8080/transactions")
                .retrieve()
                .bodyToFlux(Transaction.class)
                ,Transaction.class).
                switchIfEmpty(ServerResponse.notFound().build());

    }
///transactions/borrower/{id}
    public Mono<ServerResponse> getTransactionsByID(ServerRequest req) {

        return ServerResponse.ok().body(webClientBuilder.build()
                .get()
                .uri("http://localhost:8080/transactions/borrower/" + req.pathVariable("id"))
                .retrieve()
                .bodyToFlux(Transaction.class)
                ,Transaction.class).
                switchIfEmpty(ServerResponse.notFound().build());
    }
}
