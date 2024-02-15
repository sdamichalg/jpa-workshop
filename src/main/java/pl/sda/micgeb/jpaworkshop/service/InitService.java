package pl.sda.micgeb.jpaworkshop.service;

import org.springframework.stereotype.Service;
import pl.sda.micgeb.jpaworkshop.model.entity.Employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

@Service
public class InitService {

    public void createSimpleData() {
        Employee employee = new Employee();
        employee.setFirstName("Tom");
        employee.setLastName("Smith");
        employee.setSalary(new BigDecimal("5000"));
        employee.setContractEnd(LocalDate.of(2025, Month.DECEMBER, 31));


    }
}
