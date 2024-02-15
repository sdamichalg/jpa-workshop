package pl.sda.micgeb.jpaworkshop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.micgeb.jpaworkshop.model.Address;
import pl.sda.micgeb.jpaworkshop.model.entity.Department;
import pl.sda.micgeb.jpaworkshop.model.entity.Employee;
import pl.sda.micgeb.jpaworkshop.model.entity.EntryCard;
import pl.sda.micgeb.jpaworkshop.repository.DepartmentRepository;
import pl.sda.micgeb.jpaworkshop.repository.EmployeeRepository;
import pl.sda.micgeb.jpaworkshop.repository.EntryCardRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InitService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final EntryCardRepository entryCardRepository;

    public void createSimpleData() {

        Department department1 = new Department();
        department1.setName("IT");
        department1.setAddress(new Address("Poland", "Warsaw", "Nowy Świat", "00-001"));
        departmentRepository.save(department1);

        Department department2 = new Department();
        department2.setName("Sales");
        department2.setAddress(new Address("Poland", "Krakow", "Rynek Główny", "31-042"));
        departmentRepository.save(department2);

        Department department3 = new Department();
        department3.setName("Marketing");
        department3.setAddress(new Address("Poland", "Wroclaw", "Rynek", "50-001"));
        departmentRepository.save(department3);

        Department department4 = new Department();
        department4.setName("Finance");
        department4.setAddress(new Address("Poland", "Gdansk", "Targ Węglowy", "80-827"));
        departmentRepository.save(department4);

        Department department5 = new Department();
        department5.setName("HR");
        department5.setAddress(new Address("Poland", "Poznan", "Stary Rynek", "61-772"));
        departmentRepository.save(department5);

        EntryCard entryCard1 = new EntryCard();
        entryCard1.setUuid(UUID.randomUUID());
        entryCardRepository.save(entryCard1);

        Employee employee1 = new Employee();
        employee1.setFirstName("Tom");
        employee1.setLastName("Smith");
        employee1.setSalary(new BigDecimal("5000"));
        employee1.setContractEnd(LocalDate.of(2025, Month.DECEMBER, 31));
        employee1.setDepartment(department1);
        employee1.setEntryCard(entryCard1);

        employeeRepository.save(employee1);
    }
}
