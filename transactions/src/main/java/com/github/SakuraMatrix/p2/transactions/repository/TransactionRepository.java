package com.github.SakuraMatrix.p2.transactions.repository;

import com.github.SakuraMatrix.p2.transactions.domain.Transaction;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface TransactionRepository extends ReactiveCassandraRepository<Transaction, UUID> {
    /**
     * String query selecting one transaction
     *
     * @param id
     * @return
     */
    @Query("SELECT * FROM transactions WHERE id =?0")
    Mono<Transaction> findById(UUID id);

    /**
     * String query selecting one transaction
     *
     * @param id
     * @return
     */
    @Query("SELECT * FROM transactions WHERE lenderid =?0 ALLOW FILTERING")
    Flux<Transaction> findAllByLenderId(UUID id);

    /**
     * String query selecting one transaction
     *
     * @param id
     * @return
     */
    @Query("SELECT * FROM transactions WHERE borrowerid =?0 ALLOW FILTERING")
    Flux<Transaction> findAllByBorrowerId(UUID id);

}
