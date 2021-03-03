package com.in28minutes.microservices.currencyexchangeservice;

import java.util.Objects;

public class GreetingProvider {
    private static final String TEMPLATE = "Hello, %s";

    public String getGreeting(String name) {
        Objects.requireNonNull(name, "No name provided");
        return String.format(TEMPLATE, name);
    }
}
