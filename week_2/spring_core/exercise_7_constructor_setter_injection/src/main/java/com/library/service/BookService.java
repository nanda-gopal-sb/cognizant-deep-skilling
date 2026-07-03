package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private final String sectionName;
    private BookRepository bookRepository;

    public BookService(String sectionName) {
        this.sectionName = sectionName;
    }

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public String describeBook() {
        return sectionName + ": " + bookRepository.findBookTitle();
    }
}