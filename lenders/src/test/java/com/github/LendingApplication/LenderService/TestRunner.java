package com.github.LendingApplication.LenderService;

import com.intuit.karate.junit5.Karate;

public class TestRunner {

    @Karate.Test
    Karate TestAll() {
        return Karate.run().relativeTo(getClass());
    }
}
