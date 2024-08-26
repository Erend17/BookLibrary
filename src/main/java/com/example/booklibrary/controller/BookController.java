package com.example.booklibrary.controller;

import com.example.booklibrary.model.Book;
import com.example.booklibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public String viewBooks(Model model) {
        List<Book> bookList = bookService.getAllBooks();
        model.addAttribute("books", bookList);
        return "books";
    }

    @GetMapping("/books/{id}")
    public String viewBookDetail(@PathVariable Long id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "bookDetail";
    }

    @GetMapping("/books/new")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "addBook";
    }

    @PostMapping("/books")
    public String saveBook(Book book) {
        bookService.saveBook(book);
        return "redirect:/books";
    }

    @PostMapping("/deleteBook")
    public String deleteBook(@RequestParam Long bookId) {
        bookService.deleteBook(bookId);
        return "redirect:/books";
    }
}
