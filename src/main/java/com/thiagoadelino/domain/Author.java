package com.thiagoadelino.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

    @Entity
    @Table(name="author")
    public class Author {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id_author")
        private Integer id;

        private String name;

        @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
        private List<Book> books;
    }

