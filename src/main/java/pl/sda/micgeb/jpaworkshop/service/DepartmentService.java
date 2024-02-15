package pl.sda.micgeb.jpaworkshop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.micgeb.jpaworkshop.model.entity.Department;
import pl.sda.micgeb.jpaworkshop.repository.DepartmentRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public Department findDepartmentByName(String name) {
        Optional<Department> optDepartment = departmentRepository.findByName(name);

        if (optDepartment.isPresent()) {
            return optDepartment.get();
        }
        return null;
    }

    public List<Department> findDepartmentsByCity(String city) {
        return departmentRepository.findAllByAddress_City(city);
    }
}
