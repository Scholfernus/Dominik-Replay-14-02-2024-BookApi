package com.example.bookapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class BookModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    private String author;
    private Integer yearOfEdition;
}
