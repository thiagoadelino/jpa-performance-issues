package com.thiagoadelino.specification;

import com.thiagoadelino.domain.Book;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class BookSpecification {

    public static Specification<Book> filter(List<Integer> ids){
        return Specification.where(byIds(ids));
    }

    public static Specification<Book> byIds(List<Integer> ids){
        return (table, query, criteriaBuilder) -> criteriaBuilder.and(table.get("id").in(ids));
    }
}
