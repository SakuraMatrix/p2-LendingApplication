package com.github.LendingApplication.LenderService;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

import static javax.swing.UIManager.get;

public interface LenderRepository extends ReactiveCassandraRepository<Lender, UUID> {

    /**
     * String query selecting one transaction
     *
     * @param id
     * @return
     */
    @Query("SELECT * FROM lenders WHERE id =?0")
    Mono<Lender> findById(UUID id);
    /**
     * String query selecting one transaction
     *
     * @param id
     * @return
     */
    @Query("SELECT * FROM lenders WHERE lenderid =?0 ALLOW FILTERING")
    Flux<Lender> findAllByLenderId(UUID id);


}
