package com.github.jm27.lendingApplication.borrowers.controller;

import com.github.jm27.lendingApplication.borrowers.domain.Borrower;
import com.github.jm27.lendingApplication.borrowers.repository.BorrowerRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.UUID;

@Component
@RestController
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

    // Get borrower
    public Mono<ServerResponse> get(ServerRequest req) {
        return this.borrowerRepository.findById(UUID.fromString(req.pathVariable("id")))
                .flatMap(borrower -> ServerResponse.ok().body(Mono.just(borrower),Borrower.class))
                .switchIfEmpty(ServerResponse.notFound().build());
    }


    /* Method deletes a borrower */
    public Mono<ServerResponse> delete(ServerRequest req) {
        return this.borrowerRepository.findById(UUID.fromString(req.pathVariable("id")))
                .flatMap(borrower -> {
                    return this.borrowerRepository.delete(borrower)
                            .then(ServerResponse.ok().build());
                }).switchIfEmpty(ServerResponse.notFound().build());
    }

    /* Method updates a borrower*/
    public Mono<ServerResponse> update(ServerRequest req) {
        return req.bodyToMono(Borrower.class).
                flatMap(update -> {
                            return borrowerRepository.findById(update.getId()).flatMap(previous -> {
                                previous.setFirst_name(update.getFirst_name()); // UPDATE THIS
                                return borrowerRepository.save(previous)
                                        .flatMap(saved -> ServerResponse.ok().build());
                            });
                        }
                ).
                switchIfEmpty(ServerResponse.notFound().build());
    }
}
