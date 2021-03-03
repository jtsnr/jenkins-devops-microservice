package com.in28minutes.microservices.currencyexchangeservice;

import java.util.Objects;

public class GreetingProvider {
    private static final String TEMPLATE = "Hello, %s";

    private static final String INFORMAL_TEMPLATE = "Hi there, %s";

    public String getGreeting(String name) {
        Objects.requireNonNull(name, "No name provided");
        return String.format(TEMPLATE, name);
    }

    public String getInformalGreeting(String name) {
        return String.format(INFORMAL_TEMPLATE, name);
    }

    public String getDefaultGreeting() {
        return getGreeting("World");
    }
}
