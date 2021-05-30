package com.thiagoadelino.service;

import com.thiagoadelino.domain.Book;
import com.thiagoadelino.repository.BookRepository;
import com.thiagoadelino.specification.BookSpecification;
import org.hibernate.criterion.CriteriaQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookService {

    @Autowired
    BookRepository repository;

    public void allBook(){
        List<Book> joao = null;

        joao = repository.findAll();

        joao.stream().forEach(a-> {
            System.out.println("Book: " + a.getName() +"; Author: " + a.getAuthor().getName());
        });

        /*
        joao = repository.findByAuthorId(1);

        joao.stream().forEach(a-> {
            System.out.println("Book: " + a.getName() +"; Author: " + a.getAuthor().getName());
        });
        */

        /*
        repository.findAll(BookSpecification.filter(Arrays.asList(1,2)));

        joao.stream().forEach(a-> {
            System.out.println("Book: " + a.getName() +"; Author: " + a.getAuthor().getName());
        });
        */
    }
}
