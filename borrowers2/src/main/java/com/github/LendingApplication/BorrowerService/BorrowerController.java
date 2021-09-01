package com.github.LendingApplication.BorrowerService;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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

    public BorrowerController(BorrowerRepository borrowerRepository) {
        this.borrowerRepository = borrowerRepository;
    }

    //Get all lenders
    public Mono<ServerResponse> all(ServerRequest req) {
        return ServerResponse.ok().body(this.borrowerRepository.findAll(),Borrower.class);
    }

    //Get lender
    public Mono<ServerResponse> get(ServerRequest req) {
        return this.borrowerRepository.findById(UUID.fromString(req.pathVariable("id")))
                .flatMap(borrower -> ServerResponse.ok().body(Mono.just(borrower),Borrower.class))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    //Create
    public Mono<ServerResponse> create(ServerRequest req) {
        return req.bodyToMono(Borrower.class)
                .flatMap(borrower -> this.borrowerRepository.save(borrower))
                .flatMap(borrower -> ServerResponse.created(URI.create("/borrowers/" + borrower.getId())).build());
    }

    /* Method deletes a transaction */
    public Mono<ServerResponse> delete(ServerRequest req) {
        return this.borrowerRepository.findById(UUID.fromString(req.pathVariable("id")))
                .flatMap(borrower -> {
                    return this.borrowerRepository.delete(borrower)
                            .then(ServerResponse.ok().build());
                }).switchIfEmpty(ServerResponse.notFound().build());
    }

    /* Method updates a record*/
    public Mono<ServerResponse> update(ServerRequest req) {
        return req.bodyToMono(Borrower.class).
                flatMap(update -> {
                            return borrowerRepository.findById(update.getId()).flatMap(previous -> {
                              //  previous.setFisrst_name(update.getFirst_name());
                            //    previous.setLast_name(update.getLast_name()); //updates the status to the new status
                                return borrowerRepository.save(previous)
                                        .flatMap(saved -> ServerResponse.ok().build());
                            });
                        }
                ).
                switchIfEmpty(ServerResponse.notFound().build());
    }



}
