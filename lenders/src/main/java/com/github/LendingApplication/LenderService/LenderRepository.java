package com.github.LendingApplication.LenderService;

import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import java.util.UUID;

public interface LenderRepository extends ReactiveCassandraRepository<Lender, UUID> {
}
