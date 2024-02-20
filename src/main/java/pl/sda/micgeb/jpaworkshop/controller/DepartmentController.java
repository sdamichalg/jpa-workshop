package pl.sda.micgeb.jpaworkshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.micgeb.jpaworkshop.model.dto.DepartmentDto;
import pl.sda.micgeb.jpaworkshop.model.entity.Department;
import pl.sda.micgeb.jpaworkshop.service.DepartmentService;

import java.sql.SQLException;
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

    @PostMapping("/add")
    public ResponseEntity<Void> addNew(@RequestBody DepartmentDto requestDto) {
        departmentService.addNewDepartment(requestDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findByCity")
    public ResponseEntity<List<Department>> findByCity(@RequestParam String city) {
        List<Department> departmentsByCity = departmentService.findDepartmentsByCity(city);
        return ResponseEntity.ok(departmentsByCity);
    }

    @GetMapping("/findAllByName")
    public ResponseEntity<List<DepartmentDto>> findAllByName(@RequestParam String departmentName) {
        List<DepartmentDto> dtos = departmentService.findAllByName(departmentName);
        return ResponseEntity.ok(dtos);
    }

    @DeleteMapping("/deleteByName")
    public ResponseEntity<Void> deleteByName(@RequestParam String departmentName) {
        departmentService.deleteDepartmentByName(departmentName);
        return ResponseEntity.ok().build();
    }

}
