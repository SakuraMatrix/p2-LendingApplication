package com.github.jm27.lendingApplication.borrowers.repository;

import com.github.jm27.lendingApplication.borrowers.domain.Borrower;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;

import java.util.UUID;

public interface BorrowerRepository extends ReactiveCassandraRepository<Borrower, UUID> {
}
