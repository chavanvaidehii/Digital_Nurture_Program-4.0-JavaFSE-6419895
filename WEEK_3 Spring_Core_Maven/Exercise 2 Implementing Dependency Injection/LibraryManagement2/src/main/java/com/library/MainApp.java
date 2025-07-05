package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("[MainApp] Starting Library Management Application...");

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("[MainApp] Spring context loaded successfully.");

        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.addBook("Spring in Action");

        System.out.println("[MainApp] Application finished.");
    }
}
