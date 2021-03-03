package com.in28minutes.microservices.currencyexchangeservice;

public class GreetingProvider {
    private static final String TEMPLATE = "Hello, %s";

    public String getGreeting(String name) {
		if (name == null) {
			name = "World";
		}
        return String.format(TEMPLATE, name);
    }
}
