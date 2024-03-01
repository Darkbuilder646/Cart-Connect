package com.example.jspapp.service.impl;

import com.example.jspapp.entity.Book;
import com.example.jspapp.service.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Override
    public List<Book> getBook() {
        return null;
    }

    @Override
    public Book addBook(Book book) {
        return null;
    }

    public List<Book> getAllBook() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("1", "le temps des tempetes", "author 1"));
        books.add(new Book("2", "Blade runner", "author 2"));
        books.add(new Book("3", "les fourmis", "author 3"));
        return books;

    }
}
