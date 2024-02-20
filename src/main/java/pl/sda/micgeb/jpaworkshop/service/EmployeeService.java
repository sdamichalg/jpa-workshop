package pl.sda.micgeb.jpaworkshop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.micgeb.jpaworkshop.model.dto.EmployeeDto;
import pl.sda.micgeb.jpaworkshop.model.dto.NewEmployeeReq;
import pl.sda.micgeb.jpaworkshop.model.entity.Employee;
import pl.sda.micgeb.jpaworkshop.repository.EmployeeRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public void saveEmployee(NewEmployeeReq req) {

        Employee newEmployeeEntity = new Employee();
        newEmployeeEntity.setFirstName(req.getFirstName());
        newEmployeeEntity.setLastName(req.getLastName());
        newEmployeeEntity.setSalary(req.getSalary());
        newEmployeeEntity.setContractEnd(req.getContractEnd());

        employeeRepository.save(newEmployeeEntity);
    }

    @Transactional
    public void updateSalary(String lastName, String newSalary) {
        employeeRepository.updateSalaryByLastName(lastName, new BigDecimal(newSalary));
    }

    public List<EmployeeDto> findSalaryBetween(BigDecimal min, BigDecimal max) {
        List<Employee> employees = employeeRepository.findAllBySalaryBetween(min, max);

        return employees.stream()
                .map(ent -> employeeMapper.toDto(ent))
                .collect(Collectors.toList());
    }
}
