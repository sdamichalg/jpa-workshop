package pl.sda.micgeb.jpaworkshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.micgeb.jpaworkshop.model.entity.Department;
import pl.sda.micgeb.jpaworkshop.service.DepartmentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping("/findByName")
    public ResponseEntity<Department> findByName(@RequestParam String departmentName) {
        Department departmentByName = departmentService.findDepartmentByName(departmentName);
        return ResponseEntity.ok(departmentByName);

    }

    @GetMapping("/findByCity")
    public ResponseEntity<List<Department>> findByCity(@RequestParam String city) {
        List<Department> departmentsByCity = departmentService.findDepartmentsByCity(city);
        return ResponseEntity.ok(departmentsByCity);
    }
}
