package net.jguzmandev.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name="tbl_order")
public class Order {

    @Id
    @SequenceGenerator(name="order_seq", sequenceName = "order_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
    private Long orderId;

    private String description;

    private Double price;

    @ManyToOne(
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name="shop_id",
            referencedColumnName = "shopId"
    )
    private Shop shop;
}
