package io.github.stefanodpc.libraryapi.model;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "author", schema = "public") //public = default, can change to whatever want with the schema property
public class Author {
    @Id
    @Column(name = "id") //default = same as name, can change with this property
    @GeneratedValue(strategy = GenerationType.UUID) //indicates that it generates automatically, choose the strategy
    private UUID id;

    @Column(name = "name", length = 100, nullable = false) //defines maximun length, varchar(100) in this case
    private String name;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "nationality", length = 50, nullable = false)
    private String nationality;

    @OneToMany(mappedBy = "author")  //does not exist in the database, but can be used to simplify java functions
    private List<Book> books;        //the mapped by references the java atribute, therefore author, instead of the DB name

    // @Deprecated - This way you can enforce the coders to use only constructors with args, while
    // still giving JPA its mandatory noArgs constuctor 
    public Author(){
    }

    public Author(String name, LocalDate birthDate, String nationality) {
        this.name = name;
        this.birthDate = birthDate;
        this.nationality = nationality;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    
}
