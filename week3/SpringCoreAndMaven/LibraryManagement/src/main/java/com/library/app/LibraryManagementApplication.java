package com.library.app;

import com.library.service.BookService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
            System.out.println("Spring context loaded successfully.");
            BookService bookService = context.getBean("bookService", BookService.class);
            bookService.displayBookDetails();
        }
    }
}
