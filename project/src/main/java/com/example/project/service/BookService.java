// BookService.java
package com.example.project.service;

import com.example.project.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private List<Book> books = new ArrayList<>();

    public List<Book> getAllBooks() {
        return books;
    }

    public Book getBookById(Long bookId) {
        for (Book book : books) {
            if (book.getBookId().equals(bookId)) {
                return book;
            }
        }
        return null; // or throw exception
    }

    public Book createBook(Book book) {
        books.add(book);
        return book;
    }

    public Book updateBook(Long bookId, Book updatedBook) {
        for (Book book : books) {
            if (book.getBookId().equals(bookId)) {
                book.setTitle(updatedBook.getTitle());
                book.setAuthor(updatedBook.getAuthor());
                // Set other properties as needed
                return book;
            }
        }
        return null; // or throw exception
    }

    public void deleteBook(Long bookId) {
        books.removeIf(book -> book.getBookId().equals(bookId));
    }
}
