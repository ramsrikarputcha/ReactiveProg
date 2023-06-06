package com.example.demo;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class testingTest {
    testing object = new testing();

    @Test
    void getFluxReturnData() {
        StepVerifier.create(object.getFluxReturnData().log())
                .expectNext(1,2,3,4,5)
                .verifyComplete();
    }

    @Test
    void getMonoReturnData() {
        StepVerifier.create((object.getMonoReturnData().log()))
                .expectNext(1)
                .verifyComplete();
    }


    @Test
    void getMapData() {
        StepVerifier.create(object.getMapData().log())
                .expectNext("aa", "bb", "cc")
                .verifyComplete();
    }
}