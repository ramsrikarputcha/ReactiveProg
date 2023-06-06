package com.example.demo;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.*;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class monoflux {

    @Test
    public void testmono()
    {
        //Mono<String> monovar = Mono.just("java");
        Mono<String> monovar = Mono.just("java").log();
        //Mono<?> monovar = Mono.just("java")
                       // .then(Mono.error((new RuntimeException("exception occurred"))))
                         //       .log();
        monovar.subscribe(System.out::println);

    }

    @Test
    public void testflux()
    {
        //Flux<String> fluxvar = Flux.just("Boot", "Kennel", "Campfire", "Ash");
        Flux<String> fluxvar = Flux.just("Boot", "Kennel", "Campfire", "Ash")
                .concatWithValues("Car")
                .concatWith(Flux.error(new RuntimeException("exception occurred in flux")))
                .log();

        fluxvar.subscribe(System.out::println, (e)->System.out.println(e.getMessage()));
    }

    @Test
    public void testmap()
    {
        Map map = new HashMap();
        map.put(1,"Ram");
        map.put(3,"Dash");
        map.put(5,"Hello");
        System.out.println(map);

        List.of("hello", "world")
                .stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        Arrays.asList("A", "b", "C")
                .stream()
                .map(s -> s.toLowerCase())
                .forEach(System.out::println);
    }

    @Test
    public void testfilter()
    {
        Predicate<Long> isEven = (value) -> value % 2L == 0;
        List.of(1L, 2L, 3L, 5L, 8L, 13L).stream().filter(isEven).forEach(System.out::println);
        List.of(1L, 2L, 3L, 5L, 8L, 13L)
                .stream()
                .filter(Predicate.not(value -> value % 2L == 0))
                .forEach(System.out::println);
    }

    @Test
    public void testreduce()
    {
        String[] myArray = { "this", "is", "a", "sentence" };
        String result = Arrays.stream(myArray)
                .reduce("", (a,b) -> a + b);
        System.out.println(result);
    }
}
