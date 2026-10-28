package com.library_management.demo.Service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.library_management.demo.Model.Book;
import com.library_management.demo.Repository.BookRepository;
import com.library_management.demo.Exception.BookNotFoundException;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository repository) {
        this.bookRepository = repository;
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Book getBookById(Long bookid) {
        return bookRepository.findById(bookid).orElseThrow(() ->
            new BookNotFoundException("Book not found with ID: " + bookid));
    }

    public Book updateAvailability(Long bookid, boolean available) {
        Book book = getBookById(bookid);
        book.setAvailable(available);
        return bookRepository.save(book);
    }

    public String deleteBook(Long bookid) {
        Book book = getBookById(bookid);
        bookRepository.delete(book);
        return "Book deleted successfully";
    }
}
