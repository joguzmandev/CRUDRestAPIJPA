package net.jguzmandev.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Shop {
    @Id
    @SequenceGenerator(name="shop_seq", sequenceName = "shop_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shop_seq")
    private Long shopId;
    private String name;
    private String floor;

    @OneToOne(
            cascade = {CascadeType.PERSIST},
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "manager_id",
            referencedColumnName = "managerId"
    )
    @ToString.Exclude
    private Manager manager;

    @OneToMany(
            mappedBy = "shop",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST})
    @ToString.Exclude
    private List<Order> orders;

    @ManyToMany(mappedBy = "shops", fetch = FetchType.LAZY)
    private List<Customer> customers;
}
