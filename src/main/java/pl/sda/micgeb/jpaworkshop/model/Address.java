package pl.sda.micgeb.jpaworkshop.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    public String country;
    public String city;
    public String street;
    public String zipCode;
}
