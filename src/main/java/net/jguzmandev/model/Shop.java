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
public class Shop {
    @Id
    @SequenceGenerator(name="shop_seq", sequenceName = "shop_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shop_seq")
    private Long shopId;
    private String name;
    private String floor;

    @OneToOne(
            cascade = CascadeType.PERSIST,
            fetch = FetchType.EAGER,
            optional = false  // un Shop SIEMPRE tiene Manager
    )
    @JoinColumn(
            name = "manager_id",
            referencedColumnName = "managerId"
    )

    private Manager manager;
}
