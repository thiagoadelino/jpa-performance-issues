package com.thiagoadelino.repository;

import com.thiagoadelino.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer>, JpaSpecificationExecutor<Book> {


    @Query(value = "SELECT b, a FROM Book b JOIN b.author a WHERE a.id = :authorId ")
    List<Book> findByAuthorId(@Param("authorId") Integer authorId);
}
