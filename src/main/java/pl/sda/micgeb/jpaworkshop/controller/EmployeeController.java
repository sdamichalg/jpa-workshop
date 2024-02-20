package pl.sda.micgeb.jpaworkshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.micgeb.jpaworkshop.model.dto.EmployeeDto;
import pl.sda.micgeb.jpaworkshop.model.dto.NewEmployeeReq;
import pl.sda.micgeb.jpaworkshop.model.entity.Employee;
import pl.sda.micgeb.jpaworkshop.service.EmployeeService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/new")
    public ResponseEntity<Void> saveEmployee(@RequestBody NewEmployeeReq newEmployee) {
        employeeService.saveEmployee(newEmployee);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/updateSalary")
    public ResponseEntity<Void> updateSalary(@RequestParam String lastName, @RequestParam String newSalary) {
        employeeService.updateSalary(lastName, newSalary);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/salary")
    public ResponseEntity<List<EmployeeDto>> getEmployeesBySalary(@RequestParam BigDecimal min, @RequestParam BigDecimal max) {
        List<EmployeeDto> salaryBetween = employeeService.findSalaryBetween(min, max);

        return ResponseEntity.ok(salaryBetween);
    }
}
