package com.example.booklibrary.service;

import com.example.booklibrary.model.Book;
import com.example.booklibrary.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BooksRepository booksRepository;

    public List<Book> getAllBooks(){ return booksRepository.findAll(); }

    public Book getBookById(Long id){ return booksRepository.findById(id).orElse(null);
    }

    public Book saveBook(Book book){ return booksRepository.save(book); }

    public void deleteBook(Long id){ booksRepository.deleteById(id); }

   // public void deleteAllBooks(){ booksRepository.deleteAll(); }

}
