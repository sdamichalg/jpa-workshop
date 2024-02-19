package pl.sda.micgeb.jpaworkshop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.micgeb.jpaworkshop.model.dto.DepartmentDto;
import pl.sda.micgeb.jpaworkshop.model.entity.Department;
import pl.sda.micgeb.jpaworkshop.repository.DepartmentRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    public Department findDepartmentByName(String name) {
        Optional<Department> optDepartment = departmentRepository.findByName(name);

        if (optDepartment.isPresent()) {
            return optDepartment.get();
        }
        return null;
    }

    public List<DepartmentDto> findAllByName(String departmentName) {
        List<Department> allByName = departmentRepository.findAllByName(departmentName);

        return allByName.stream()
                .map(ent -> departmentMapper.toDto(ent))
                .collect(Collectors.toList());
    }

    public List<Department> findDepartmentsByCity(String city) {
        return departmentRepository.findAllByAddress_City(city);
    }
}
