package challenge.ravn.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    private String isbn;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
}
