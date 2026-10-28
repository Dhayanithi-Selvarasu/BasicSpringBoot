package com.library_management.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.library_management.demo.Model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
