package pl.sda.micgeb.jpaworkshop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.micgeb.jpaworkshop.model.dto.NewEmployeeReq;
import pl.sda.micgeb.jpaworkshop.model.entity.Employee;
import pl.sda.micgeb.jpaworkshop.repository.EmployeeRepository;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public void saveEmployee(NewEmployeeReq req) {

        Employee newEmployeeEntity = new Employee();
        newEmployeeEntity.setFirstName(req.getFirstName());
        newEmployeeEntity.setLastName(req.getLastName());
        newEmployeeEntity.setSalary(req.getSalary());
        newEmployeeEntity.setContractEnd(req.getContractEnd());

        employeeRepository.save(newEmployeeEntity);
    }
}
