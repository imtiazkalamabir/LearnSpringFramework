package com.in28minutes.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person(String name, int age, Address address) { }
record Address(String firstLine, String city) { }
@Configuration
public class HelloWorldConfiguration {
    @Bean
    public String name() {
        return "Abir";
    }

    @Bean
    public int age() {
        return 32;
    }

    @Bean
    public Person person() {
        return new Person("Zack", 20, new Address("22nd Street", "London"));
    }

    @Bean
    public Person person2MethodCall() {
        return new Person(name(), age(), address());
    }

    @Bean
    public Person person3Parameters(String name, int age, Address address2) {
        // name, age, address2
        return new Person(name, age, address2);
    }

    @Bean(name = "address2")
    @Primary // assign primary bean
    public Address address() {
        return new Address("House #21, Road #34, Block #B, Banani", "Dhaka");
    }
}
