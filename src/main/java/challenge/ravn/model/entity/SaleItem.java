package challenge.ravn.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "sale_items")
public class SaleItem {
    @Id
    @GeneratedValue
    private Long id;
    private String customerName;
    private Double itemPrice;
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
}
