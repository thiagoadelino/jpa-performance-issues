package com.thiagoadelino;

import com.thiagoadelino.service.BookService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan("com.thiagoadelino")
@EntityScan("com.thiagoadelino")
@SpringBootApplication
public class Application {

    public static void main(String[] args){
        ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
        run.getBean(BookService.class).allBook();
    }
}
