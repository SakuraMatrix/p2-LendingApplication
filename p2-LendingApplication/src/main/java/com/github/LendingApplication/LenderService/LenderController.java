package com.github.LendingApplication.LenderService;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.UUID;

@Component
public class LenderController {
    private LenderRepository lenderRepository;

    public LenderController(LenderRepository lenderRepository) {
        this.lenderRepository = lenderRepository;
    }

    public Mono<ServerResponse> all(ServerRequest req) {
        return ServerResponse.ok().body(this.lenderRepository.findAll(),Lender.class);
    }

    public Mono<ServerResponse> get(ServerRequest req) {
        return this.lenderRepository.findById(UUID.fromString(req.pathVariable("id")))
                .flatMap(lender -> ServerResponse.ok().body(Mono.just(lender),Lender.class))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> create(ServerRequest req) {
        return req.bodyToMono(Lender.class)
                .flatMap(lender -> this.lenderRepository.save(lender))
                .flatMap(lender -> ServerResponse.created(URI.create("/lenders/" + lender.getId())).build());
    }



}
