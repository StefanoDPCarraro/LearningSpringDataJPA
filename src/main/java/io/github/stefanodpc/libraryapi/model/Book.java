package io.github.stefanodpc.libraryapi.model;

import java.time.LocalDate;
import java.util.UUID;

import io.github.stefanodpc.libraryapi.model.enums.BookGender;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "isbn", length = 20, nullable = false)
    private String isbn;

    @Column(name = "title", length = 150, nullable = false)
    private String title;

    @Column(name = "published_date", nullable = false)
    private LocalDate publishedDate;

    @Enumerated(EnumType.STRING) //holds the string, instead of the number
    @Column(name = "gender", length = 20, nullable = false)
    private BookGender gender;

    @Column(name = "price", precision = 18, scale = 2) //16 int and 2 float
    private Double price;

    @ManyToOne    // many books (this class), to one author(this attribute)
    @JoinColumn(name = "author_id")
    private Author author;
}
