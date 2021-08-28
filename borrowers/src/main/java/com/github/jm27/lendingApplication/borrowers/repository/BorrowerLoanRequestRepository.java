package com.github.jm27.lendingApplication.borrowers.repository;

import com.github.jm27.lendingApplication.borrowers.domain.BorrowerLoanRequest;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;

import java.util.UUID;

public interface BorrowerLoanRequestRepository extends ReactiveCassandraRepository<BorrowerLoanRequest, UUID> {
}
