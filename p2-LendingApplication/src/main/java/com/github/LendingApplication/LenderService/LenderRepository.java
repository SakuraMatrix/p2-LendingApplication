package com.github.LendingApplication.LenderService;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface LenderRepository extends ReactiveCassandraRepository<Lender, UUID> {

}
