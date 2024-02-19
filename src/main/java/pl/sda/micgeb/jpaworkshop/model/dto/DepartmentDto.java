package pl.sda.micgeb.jpaworkshop.model.dto;

import lombok.Data;
import pl.sda.micgeb.jpaworkshop.model.Address;

@Data
public class DepartmentDto {
    private String name;
    private Address address;
}
