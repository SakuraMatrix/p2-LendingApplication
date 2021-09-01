package com.github.LendingApplication.LenderService;

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
public class borrower3Controller {
    private LenderRepository lenderRepository;

    public borrower3Controller(LenderRepository lenderRepository) {
        this.lenderRepository = lenderRepository;
    }

    //Get all lenders
    public Mono<ServerResponse> all(ServerRequest req) {
        return ServerResponse.ok().body(this.lenderRepository.findAll(),Lender.class);
    }

    //Get lender
    public Mono<ServerResponse> get(ServerRequest req) {
        return this.lenderRepository.findById(UUID.fromString(req.pathVariable("id")))
                .flatMap(lender -> ServerResponse.ok().body(Mono.just(lender),Lender.class))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    //Create lender
    public Mono<ServerResponse> create(ServerRequest req) {
        return req.bodyToMono(Lender.class)
                .flatMap(lender -> this.lenderRepository.save(lender))
                .flatMap(lender -> ServerResponse.created(URI.create("/borrowers3/" + lender.getId())).build());
    }

    /* Method deletes a transaction */
    public Mono<ServerResponse> delete(ServerRequest req) {
        return this.lenderRepository.findById(UUID.fromString(req.pathVariable("id")))
                .flatMap(lender -> {
                    return this.lenderRepository.delete(lender)
                            .then(ServerResponse.ok().build());
                }).switchIfEmpty(ServerResponse.notFound().build());
    }

    /* Method updates a record*/
    public Mono<ServerResponse> update(ServerRequest req) {
        return req.bodyToMono(Lender.class).
                flatMap(update -> {
                            return lenderRepository.findById(update.getId()).flatMap(previous -> {
                                previous.setFirstName(update.getFirstName());
                                previous.setLastName(update.getLastName()); //updates the status to the new status
                                return lenderRepository.save(previous)
                                        .flatMap(saved -> ServerResponse.ok().build());
                            });
                        }
                ).
                switchIfEmpty(ServerResponse.notFound().build());
    }



}
