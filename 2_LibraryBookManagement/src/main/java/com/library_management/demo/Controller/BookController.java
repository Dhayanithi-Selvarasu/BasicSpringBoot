package com.library_management.demo.Controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import com.library_management.demo.Model.Book;
import com.library_management.demo.Service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@Valid @RequestBody Book book) {
        return new ResponseEntity<>(bookService.addBook(book), HttpStatus.CREATED);
    }

    @GetMapping("/{bookid}")
    public ResponseEntity<Book> getBookById(@PathVariable Long bookid) {
        return ResponseEntity.ok(bookService.getBookById(bookid));
    }

    @PutMapping("/{bookid}/availability")
    public ResponseEntity<Book> updateAvailability(@PathVariable Long bookid,
                                                   @RequestParam boolean available) {
        return ResponseEntity.ok(bookService.updateAvailability(bookid, available));
    }

    @DeleteMapping("/{bookid}")
    public ResponseEntity<String> deleteBook(@PathVariable Long bookid) {
        return ResponseEntity.ok(bookService.deleteBook(bookid));
    }
}
