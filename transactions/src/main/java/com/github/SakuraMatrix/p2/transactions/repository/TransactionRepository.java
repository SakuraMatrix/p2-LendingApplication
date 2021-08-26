package com.github.SakuraMatrix.p2.transactions.repository;

import com.github.SakuraMatrix.p2.transactions.domain.Transaction;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;

import java.util.UUID;

public interface TransactionRepository extends ReactiveCassandraRepository<Transaction, UUID> {

}
