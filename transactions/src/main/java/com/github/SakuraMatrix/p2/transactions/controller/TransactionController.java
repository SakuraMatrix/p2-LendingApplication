package com.github.SakuraMatrix.p2.transactions.controller;

import com.github.SakuraMatrix.p2.transactions.domain.Transaction;
import com.github.SakuraMatrix.p2.transactions.repository.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.UUID;

@Component
public class TransactionController {
    private TransactionRepository transactionRepository;
    static Logger logger = LoggerFactory.getLogger(TransactionController.class);

    public TransactionController(TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }
    /* Method gets all transactions*/
    public Mono<ServerResponse> getAll(ServerRequest req) {
        return ServerResponse.ok().body(this.transactionRepository.findAll(), Transaction.class);
    }
    /* Method gets a single transaction */
    public Mono<ServerResponse> get(ServerRequest req) {
        return this.transactionRepository.findById(UUID.fromString(req.pathVariable("id")))
                .flatMap(transaction -> ServerResponse.ok().body(Mono.just(transaction),Transaction.class))
                .switchIfEmpty(ServerResponse.notFound().build());
    }
    /* Method creates a new transaction */
    public Mono<ServerResponse> create(ServerRequest req){
        logger.debug(req.toString());
        return req.bodyToMono(Transaction.class)
                .flatMap(transaction -> this.transactionRepository.save(transaction))
                .flatMap(transaction -> ServerResponse.created(URI.create("/transactions/" + transaction.getId())).build());
    }
}
