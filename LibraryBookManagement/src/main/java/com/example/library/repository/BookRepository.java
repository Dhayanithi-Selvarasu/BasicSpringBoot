package com.example.library.repository;

import com.example.library.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepository {
    private final List<Book> books = new ArrayList<>();
    private long nextId = 1L;

    public synchronized Book save(Book book) {
        if (book.getId() == null) {
            book.setId(nextId++);
            books.add(book);
            return book;
        }
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId().equals(book.getId())) {
                books.set(i, book);
                return book;
            }
        }
        books.add(book);
        return book;
    }

    public synchronized Optional<Book> findById(Long id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst();
    }

    public synchronized List<Book> findAll() {
        return new ArrayList<>(books);
    }

    public synchronized boolean deleteById(Long id) {
        return books.removeIf(book -> book.getId().equals(id));
    }
}
