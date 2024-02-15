package pl.sda.micgeb.jpaworkshop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.micgeb.jpaworkshop.model.entity.Employee;
import pl.sda.micgeb.jpaworkshop.repository.EmployeeRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

@Service
@RequiredArgsConstructor
public class InitService {

    private final EmployeeRepository employeeRepository;

    public void createSimpleData() {
        Employee employee = new Employee();
        employee.setFirstName("Tom");
        employee.setLastName("Smith");
        employee.setSalary(new BigDecimal("5000"));
        employee.setContractEnd(LocalDate.of(2025, Month.DECEMBER, 31));

        employeeRepository.save(employee);
    }
}
