package com.manuel.springbootlibrary.controller;

import com.manuel.springbootlibrary.entity.Book;
import com.manuel.springbootlibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/books")
public class BookController {
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;

    }

    @GetMapping("/secure/currentloans/count")
    public int currentLoansCount() {
        String  userEmail = "testuser@email.com";
        return bookService.currentLoanCount(userEmail);
    }

    @GetMapping("/secure/ischeckedout/byuser")
    public Boolean checkoutBookByUser(@RequestParam Long bookId){
        String userEmail = "testuser@email.com";
        return bookService.checkoutBookByUser(userEmail, bookId);
    }

    @PutMapping("/secure/checkout")
    public Book checkoutBook (@RequestParam Long bookId) throws Exception {
        String userEmail = "testuser@email.com";
        return bookService.checkOutBook(userEmail, bookId);

    }

}
