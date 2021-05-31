package com.thiagoadelino.repository;

import com.thiagoadelino.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer>, JpaSpecificationExecutor<Book> {

    @Query(value = "SELECT b, a FROM Book b JOIN b.author a ")
    List<Book> findAllJPQL();

    @Query(value = "SELECT b, a FROM Book b JOIN b.author a WHERE b.id IN ( :idsBook ) ")
    List<Book> findByIdsBook(@Param("idsBook") List<Integer> idsBook);

    @Query(value = "SELECT b, a FROM Book b JOIN b.author a WHERE b.id = :idBook ")
    List<Book> findByIdJPQL(@Param("idBook") Integer idBook);

}
