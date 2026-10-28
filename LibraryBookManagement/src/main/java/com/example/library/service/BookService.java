package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public Book addBook(Book book) {
        book.setId(null);
        return repository.save(book);
    }

    public Book getBook(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    public Book updateBook(Long id, Book updated) {
        Book existing = getBook(id);
        existing.setTitle(updated.getTitle());
        existing.setAuthor(updated.getAuthor());
        existing.setAvailable(updated.isAvailable());
        return repository.save(existing);
    }

    public Book updateAvailability(Long id, boolean available) {
        Book book = getBook(id);
        book.setAvailable(available);
        return repository.save(book);
    }

    public void deleteBook(Long id) {
        getBook(id);
        repository.deleteById(id);
    }
}
