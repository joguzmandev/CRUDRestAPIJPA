package net.jguzmandev.model;

import jakarta.persistence.*;
import lombok.*;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Address {
    
    private String street;
    private String city;
    private String country;
}
