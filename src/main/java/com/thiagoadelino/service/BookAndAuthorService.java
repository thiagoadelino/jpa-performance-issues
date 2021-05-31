package com.thiagoadelino.service;

import com.thiagoadelino.domain.Author;
import com.thiagoadelino.domain.Book;
import com.thiagoadelino.repository.AuthorRepository;
import com.thiagoadelino.repository.BookRepository;
import com.thiagoadelino.specification.BookSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional
public class BookAndAuthorService {

    @Autowired
    EntityManager entityManager;

    @Autowired
    BookRepository repository;

    @Autowired
    AuthorRepository authorRepository;

    public List<Book> usingCriteria_all() {

        System.out.println("\nusingCriteria_findAll");

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> bk = cb.createQuery(Book.class);
        bk.from(Book.class);
        TypedQuery<Book> query = entityManager.createQuery(bk);

        System.out.println("\nQuery");
        List<Book> books = query.getResultList();

        System.out.println("\nPrint");
        books.stream().forEach(a -> {
            System.out.println("Book: " + a.getName() + "; Author: " + a.getAuthor().getName());
        });

        return books;
    }

    public List<Book> usingCriteria_findAll() {

        System.out.println("\nusingCriteria_findAll");
        System.out.println("\nQuery");

        List<Book> books = repository.findAll();

        System.out.println("\nPrint");

        books.stream().forEach(a -> {
            System.out.println("Book: " + a.getName() + "; Author: " + a.getAuthor().getName());
        });

        System.out.println("\n");

        return books;
    }

    public List<Book> usingCriteria_findAll_loadAuthorsAfter() {

        System.out.println("\nusingCriteria_findAll_loadAuthorsAfter");
        System.out.println("\nQuery Books");

        List<Book> books = repository.findAll();

        List<Integer>idsAuthors = books.stream().map(a -> a.getAuthor().getId()).collect(Collectors.toList());

        System.out.println("\nQuery Authors");
        List<Author> allAuthors = authorRepository.findAllById(idsAuthors);

        books.forEach( b ->{
            b.setAuthor(allAuthors.stream().filter(a-> a.getId().equals(b.getAuthor().getId())).findFirst().get());
        });

        System.out.println("\nPrint");

        books.stream().forEach(a -> {
            System.out.println("Book: " + a.getName() + "; Author: " + a.getAuthor().getName());
        });

        System.out.println("\n");

        return books;
    }

    public Book usingCriteria_findById(Integer id) {

        System.out.println("\nusingCriteria_findById");
        System.out.println("\nQuery");

        Optional<Book> opBook = repository.findById(id);

        Book book = opBook.get();
        System.out.println("\nPrint");
        System.out.println("Book: " + book.getName() + "; Author: " + book.getAuthor().getName());
        System.out.println("\n");
        return book;
    }

    public List<Book> usingCriteria_byIds(List<Integer> ids) {
        System.out.println("\nusingCriteria_byIds");
        System.out.println("\nQuery");
        List<Book> books = repository.findAll(BookSpecification.filter(ids));
        System.out.println("\nPrint");
        books.stream().forEach(a -> {
            System.out.println("Book: " + a.getName() + "; Author: " + a.getAuthor().getName());
        });
        System.out.println("\n");
        return books;
    }

    public List<Book> usingJPQLProjection_findAll() {
        System.out.println("\nusingJPQLProjection_findAll");
        System.out.println("\nQuery");
        List<Book> books = repository.findAllJPQL();
        System.out.println("\nPrint");
        books.stream().forEach(a -> {
            System.out.println("Book: " + a.getName() + "; Author: " + a.getAuthor().getName());
        });
        System.out.println("\n");
        return books;
    }

    public Book usingJPQL_findById(Integer id) {
        System.out.println("\nusingJPQL_findById");
        System.out.println("\nQuery");
        Optional<Book> opBook = repository.findById(id);

        Book book = opBook.get();
        System.out.println("\nPrint");
        System.out.println("Book: " + book.getName() + "; Author: " + book.getAuthor().getName());
        System.out.println("\n");
        return book;
    }

    public List<Book> usingJPQLProjection_byIds(List<Integer> ids) {
        System.out.println("\nusingJPQLProjection_byIds");
        System.out.println("\nQuery");
        List<Book> books = repository.findByIdsBook(ids);
        System.out.println("\nPrint");
        books.stream().forEach(a -> {
            System.out.println("Book: " + a.getName() + "; Author: " + a.getAuthor().getName());
        });
        System.out.println("\n");
        return books;
    }
}
