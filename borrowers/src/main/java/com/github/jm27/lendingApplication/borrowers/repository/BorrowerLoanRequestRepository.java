package com.github.jm27.lendingApplication.borrowers.repository;

import com.github.jm27.lendingApplication.borrowers.domain.BorrowerLoanRequest;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface BorrowerLoanRequestRepository extends ReactiveCassandraRepository<BorrowerLoanRequest, UUID> {
    /**
     * String query selecting one transactions
     * @param id
     * @return
     */
    @Query("SELECT * FROM borrowers WHERE id =?0")
    Mono<BorrowerLoanRequest> findById(UUID id);}
