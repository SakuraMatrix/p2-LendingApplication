package com.github.jm27.lendingApplication.borrowers.repository;

import com.github.jm27.lendingApplication.borrowers.domain.Borrower;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface BorrowerRepository extends ReactiveCassandraRepository<Borrower, UUID> {
    /**
     * String query selecting one transactions
     * @param id
     * @return
     */
    @Query("SELECT * FROM borrowers WHERE id =?0")
    Mono<Borrower> findById(UUID id);
}
