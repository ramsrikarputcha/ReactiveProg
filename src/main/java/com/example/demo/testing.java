package com.example.demo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class testing {
    public Flux<Integer> getFluxReturnData(){
        return Flux.fromIterable(List.of(1,2,3,4,5));
    }

    public Mono<Integer> getMonoReturnData()
    {
        return Mono.just(1);
    }
    
    public Flux<String> getMapData()
    {
        Iterable<String> names;
        Flux<String> result = Flux.fromIterable(List.of("AA", "BB", "CC"));

        return result
                .map(String::toLowerCase)
                .log();
    }
}
