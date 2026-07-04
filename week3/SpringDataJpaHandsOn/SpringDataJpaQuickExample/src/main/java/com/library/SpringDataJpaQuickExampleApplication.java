package com.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataJpaQuickExampleApplication implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaQuickExampleApplication.class, args);
    }

    @Override
    public void run(String... args) {
        bookRepository.save(new Book("Spring in Action", "Craig Walls"));
        bookRepository.save(new Book("Java Persistence with Hibernate", "Christian Bauer"));

        System.out.println("Books saved using Spring Data JPA:");
        for (Book book : bookRepository.findAll()) {
            System.out.println(book);
        }
    }
}
