package challenge.ravn.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String dateBirth;
}
