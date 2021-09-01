package com.github.SakuraMatrix.p2.transactions.controller;

import com.github.SakuraMatrix.p2.transactions.domain.Transaction;
import com.github.SakuraMatrix.p2.transactions.repository.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.UUID;

import static com.github.SakuraMatrix.p2.transactions.domain.Transaction.LoanStatus.FULFILLED;

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

    /* Method gets a single transaction using loan id */
    public Mono<ServerResponse> get(ServerRequest req) {
        return this.transactionRepository.findById(UUID.fromString(req.pathVariable("id")))
                .flatMap(transaction -> ServerResponse.ok().body(Mono.just(transaction),Transaction.class))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    /* Method gets all transactions for a single lender */
    public Mono<ServerResponse> getAllByLenderId(ServerRequest req) {
        return ServerResponse.ok().body(this.transactionRepository.findAllByLenderId(UUID.fromString(req.pathVariable("id"))), Transaction.class);
    }

    /* Method gets all transactions for a single borrower */
    public Mono<ServerResponse> getAllByBorrowerId(ServerRequest req) {
        return ServerResponse.ok().body(this.transactionRepository.findAllByBorrowerId(UUID.fromString(req.pathVariable("id"))), Transaction.class);
    }

    /* Method creates a new transaction */
    public Mono<ServerResponse> create(ServerRequest req){
        logger.debug(req.toString());
        return req.bodyToMono(Transaction.class)
                .flatMap(transaction -> this.transactionRepository.save(transaction))
                .flatMap(transaction -> ServerResponse.created(URI.create("/transactions/" + transaction.getId())).build());
    }

    /* Method deletes a transaction */
    public Mono<ServerResponse> delete(ServerRequest req) {
            return this.transactionRepository.findById(UUID.fromString(req.pathVariable("id")))
                .flatMap(transaction -> {
                   return this.transactionRepository.delete(transaction)
                           .then(ServerResponse.ok().build());
                }).switchIfEmpty(ServerResponse.notFound().build());
    }

    /* Method updates a transaction status*/
    public Mono<ServerResponse> update(ServerRequest req) {
        return req.bodyToMono(Transaction.class).
                flatMap(update -> {
                            return transactionRepository.findById(update.getId()).flatMap(previous -> {
                                previous.setStatus(update.getStatus()); //updates the status to the new status
                                return transactionRepository.save(previous)
                                        .flatMap(saved -> ServerResponse.ok().build());
                            });
                        }
                ).
                switchIfEmpty(ServerResponse.notFound().build());
    }
}
