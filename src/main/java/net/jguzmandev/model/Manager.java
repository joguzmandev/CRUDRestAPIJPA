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
public class Manager {
    @Id
    @SequenceGenerator(name="manager_seq", sequenceName = "manager_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "manager_seq")
    private Long managerId;

    private String firstName;
    private String lastName;

//    @OneToOne(
//            targetEntity = Shop.class,
//            fetch = FetchType.LAZY,
//            mappedBy = "manager"
//    )
//    private Shop shop;
}
