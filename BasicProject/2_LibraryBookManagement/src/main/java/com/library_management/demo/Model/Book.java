package com.library_management.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookid;

    @NotBlank(message = "Book name is required")
    private String bookName;

    @NotBlank(message = "Author name is required")
    private String author;

    @Positive(message = "Price must be positive")
    private double price;

    private boolean available;

    public Long getBookid() { return bookid; }
    public void setBookid(Long bookid) { this.bookid = bookid; }
    public String getBookName() { return bookName; }
    public void setBookName(String bookName) { this.bookName = bookName; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
}
