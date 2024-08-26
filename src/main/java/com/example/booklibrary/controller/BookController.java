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
    public String ViewBooks(Model model) {
        List<Book> bookList = bookService.getAllBooks();
        model.addAttribute("books", bookList);
        return "books";
    }

    @GetMapping("/books/{id}")
    public String ViewBookDetails(@PathVariable Long id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "bookDetails";
    }

    @GetMapping("/books/new")
    public String showCreateBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "createBook";
    }

/*
    @DeleteMapping("/books")
    public String deleteBooks(){
        bookService.deleteAllBooks();
        return "redirect:/books";
    }

 */

    @PostMapping("/deleteBook")
    public String deleteBook(@RequestParam Long id){
        bookService.deleteBook(id);
        return "redirect:/books";
    }

    @PostMapping("/books")
    public String saveBook(Book book){
        bookService.saveBook(book);
        return "redirect:/books";
    }
}
