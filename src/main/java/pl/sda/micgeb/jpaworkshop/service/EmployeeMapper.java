package pl.sda.micgeb.jpaworkshop.service;

import org.springframework.stereotype.Component;
import pl.sda.micgeb.jpaworkshop.model.dto.EmployeeDto;
import pl.sda.micgeb.jpaworkshop.model.entity.Employee;

@Component
public class EmployeeMapper {

    public EmployeeDto toDto(Employee entity) {
        EmployeeDto dto = new EmployeeDto();
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setContractEnd(entity.getContractEnd());
        dto.setSalary(entity.getSalary());
        return dto;
    }
}
