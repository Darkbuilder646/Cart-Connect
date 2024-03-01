package com.example.jspapp.controller;

import com.example.jspapp.service.BookService;
import com.example.jspapp.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private final BookServiceImpl bookServiceImpl;
    public BookController(BookServiceImpl bookServiceImpl) {
        this.bookServiceImpl = bookServiceImpl;
    }

    @GetMapping("/getBooks")
    public ModelAndView getAllBooks() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("books", bookServiceImpl.getAllBook());
        mav.setViewName("allBooks");
        return mav;
    }
}
