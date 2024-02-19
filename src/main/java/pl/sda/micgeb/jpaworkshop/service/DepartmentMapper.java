package pl.sda.micgeb.jpaworkshop.service;

import org.springframework.stereotype.Component;
import pl.sda.micgeb.jpaworkshop.model.dto.DepartmentDto;
import pl.sda.micgeb.jpaworkshop.model.entity.Department;

@Component
public class DepartmentMapper {

    public DepartmentDto toDto(Department entity) {
        DepartmentDto dto = new DepartmentDto();
        dto.setName(entity.getName());
        dto.setAddress(entity.getAddress());

        return dto;
    }

    public Department toEntity(DepartmentDto dto) {
        Department entity = new Department();
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());

        return entity;
    }

}
