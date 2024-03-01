package com.example.jspapp.service;

import com.example.jspapp.entity.Book;

import java.util.Collection;

public interface BookService {
    Collection<Book> getBook();
    Book addBook(Book book);
}
