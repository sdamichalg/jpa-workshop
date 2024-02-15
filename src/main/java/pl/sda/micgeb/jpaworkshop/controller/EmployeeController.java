package pl.sda.micgeb.jpaworkshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.micgeb.jpaworkshop.model.dto.NewEmployeeReq;
import pl.sda.micgeb.jpaworkshop.service.EmployeeService;

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
}
