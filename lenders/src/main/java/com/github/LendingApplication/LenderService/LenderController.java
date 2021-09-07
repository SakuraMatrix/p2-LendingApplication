package com.github.LendingApplication.LenderService;
//import com.github.SakuraMatrix.p2.transactions.domain.Transaction;

import com.github.LendingApplication.LenderService.domain.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.UUID;

@Component
public class LenderController {
    private LenderRepository lenderRepository;
    static Logger logger = LoggerFactory.getLogger(LenderController.class);
    @Autowired
    private WebClient.Builder webClient;
//    private LenderService lenderService;
//    private WebClient.Builder webClientBuilder;
//    String url = "http://localhost:8080";
//    @Autowired
//    WebClient webClient = WebClient.builder().baseUrl(url).build();

//    public LenderController(LenderRepository lenderRepository, LenderService lenderService) {
//        this.lenderRepository = lenderRepository;
//        this.lenderService = lenderService;
//    }
    public LenderController(LenderRepository lenderRepository) {
        this.lenderRepository = lenderRepository;
    }

    public Mono<ServerResponse> all(ServerRequest req) {
        return ServerResponse.ok().body(this.lenderRepository.findAll(),Lender.class);
    }

    public Mono<ServerResponse> get(ServerRequest req) {
        return this.lenderRepository.findById(UUID.fromString(req.pathVariable("id")))
                .flatMap(lender -> ServerResponse.ok().body(Mono.just(lender),Lender.class))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> create(ServerRequest req) {
        return req.bodyToMono(Lender.class)
                .flatMap(lender -> this.lenderRepository.save(lender))
                .flatMap(lender -> ServerResponse.created(URI.create("/lenders/" + lender.getId())).build());
    }

/* Method gets transactions for a single lender given the lender id */
public Mono<ServerResponse> getTransactions(ServerRequest req) {
    return ServerResponse.ok().body(webClient.baseUrl("http://localhost:8080").build()
                    .get()
                    .uri(uriBuilder -> uriBuilder
                            .path("/transactions/lender/{id}")
                            .build(req.pathVariable("id")))
                    .retrieve()
                    .bodyToFlux(Transaction.class)
            ,Transaction.class);

}
//    public Mono<ServerResponse> getTransactions(ServerRequest req) {
//        return ServerResponse.ok().body(webClient.build()
//                .get()
//                .uri("http://localhost:8080/transactions")
//                                .retrieve()
//                                .bodyToFlux(Transaction.class)
//                        ,Transaction.class);
//        
//    }

}
