package com.thiagoadelino;

import com.thiagoadelino.service.BookAndAuthorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;


@ComponentScan("com.thiagoadelino")
@EntityScan("com.thiagoadelino")
@SpringBootApplication
public class Application {

    public static void main(String[] args){
        ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);

        BookAndAuthorService bookAndAuthorService = run.getBean(BookAndAuthorService.class);
        bookAndAuthorService.usingCriteria_findAll();
        bookAndAuthorService.usingCriteria_findById(1);
        bookAndAuthorService.usingCriteria_byIds(Arrays.asList(1,2));
        bookAndAuthorService.usingCriteria_findAll_loadAuthorsAfter();
        bookAndAuthorService.usingJPQLProjection_findAll();
        bookAndAuthorService.usingJPQL_findById(1);
        bookAndAuthorService.usingJPQLProjection_byIds(Arrays.asList(1,2));
    }
}
