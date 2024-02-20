package pl.sda.micgeb.jpaworkshop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.micgeb.jpaworkshop.model.dto.DepartmentDto;
import pl.sda.micgeb.jpaworkshop.model.entity.Department;
import pl.sda.micgeb.jpaworkshop.repository.DepartmentRepository;

import java.sql.SQLException;
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
            Department department = optDepartment.get();
            System.out.println("*******************************");
            System.out.println(department.getEmployees());
            return department;

        }
        return null;
    }

    public List<DepartmentDto> findAllByName(String departmentName) {
        List<Department> allByName = departmentRepository.findAllByName(departmentName);

        return allByName.stream()
                .map(ent -> departmentMapper.toDto(ent))
                .collect(Collectors.toList());
    }

    @Transactional
    public void addNewDepartment(DepartmentDto dto)  {
        departmentRepository.save(departmentMapper.toEntity(dto));
//        throwSomeException();
    }

    private void throwSomeException() throws SQLException {
        throw new SQLException("nasz wyjatek");
    }

    public List<Department> findDepartmentsByCity(String city) {
        return departmentRepository.findAllByAddress_City(city);
    }

    @Transactional
    public void deleteDepartmentByName(String departmentName) {
        departmentRepository.deleteByName(departmentName);
    }
}
