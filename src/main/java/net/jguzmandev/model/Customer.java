package net.jguzmandev.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder @ToString
@Entity
@Table(
        name="tbl_customers",
        uniqueConstraints = {
            @UniqueConstraint(name="email_unique", columnNames = "email_address"),
            @UniqueConstraint(name="phone_unique", columnNames = "phone")
        }
)
public class Customer {

    @Id
    @SequenceGenerator(
            name="customer_seq",
            sequenceName = "customer_seq", allocationSize = 60)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_seq")
    private Long customerId;
    private String firstName;
    private String lastName;

    @Column(
            name = "email_address",
            nullable = false
    )
    private String email;

    private String phone;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name="billing_street", length = 150)),
            @AttributeOverride(name = "city", column = @Column(name="billing_city")),
            @AttributeOverride(name = "country", column = @Column(name="billing_country",nullable = false)),
    })
    private Address billingAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "shipping_street",nullable = false, length = 150)),
            @AttributeOverride(name = "city", column = @Column(name="shipping_city",nullable = false)),
            @AttributeOverride(name = "country", column = @Column(name="shipping_country",nullable = false)),
    })
    private Address shippingAddress;


    @ManyToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.LAZY
    )
    @JoinTable(
            name = "customer_shop",
            joinColumns = {
                    @JoinColumn(name="customer_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name="shop_id")
            }
    )
    @ToString.Exclude
    private List<Shop> shops;

    public void addShop(Shop shop){
        this.shops.add(shop);
        shop.getCustomers().add(this);
    }



}
