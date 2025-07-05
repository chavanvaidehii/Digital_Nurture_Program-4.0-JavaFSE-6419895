package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private String libraryName;              // For constructor injection
    private BookRepository bookRepository;   // For setter injection

    // Constructor Injection
    public BookService(String libraryName) {
        this.libraryName = libraryName;
    }

    // Setter Injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String bookName) {
        System.out.println("[" + libraryName + "] Adding book: " + bookName);
        bookRepository.saveBook(bookName);
    }
}
