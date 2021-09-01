package com.github.LendingApplication.BorrowerService;

import com.github.LendingApplication.BorrowerService.Borrower;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

import static javax.swing.UIManager.get;

public interface BorrowerRepository extends ReactiveCassandraRepository<Borrower, UUID> {

    /**
     * String query selecting one transaction
     *
     * @param id
     * @return
     */
    @Query("SELECT * FROM borrowers2 WHERE id =?0")
    Mono<Borrower> findById(UUID id);

}
