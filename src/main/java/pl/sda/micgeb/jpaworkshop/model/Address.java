package pl.sda.micgeb.jpaworkshop.model;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Address {
    public String country;
    public String city;
    public String street;
    public String zipCode;
}
