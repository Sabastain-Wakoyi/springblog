package com.codeup.springblog.repositories;

import com.codeup.springblog.models.Book;
import com.codeup.springblog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    User findByUserName(String testUser);

    //Book findBookByTitle(String testBook);
    // Will return a SINGLE book with the matching title.
    Book findBookByTitle(String title);
//    Book findBookByTitle();
//
//
//    // Custom queries may require you to use the @Query annotation, this uses HQL syntax.
//    @Query("from Book b where b.title like %:bookTitle%")
//    List<Book> getBookByAuthor(@Param("bookTitle") String title);
}
