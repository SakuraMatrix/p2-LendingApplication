package com.github.SakuraMatrix.p2.transactions;

import com.intuit.karate.junit5.Karate;

public class KarateTests {

    @Karate.Test
    Karate testAll() {
        return Karate.run().relativeTo(getClass());
    }
}