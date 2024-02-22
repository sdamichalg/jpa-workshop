package pl.sda.micgeb.jpaworkshop.service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import pl.sda.micgeb.jpaworkshop.model.Address;
import pl.sda.micgeb.jpaworkshop.model.entity.Department;
import pl.sda.micgeb.jpaworkshop.repository.DepartmentRepository;

import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
public class DepartmentServiceWithSpringBoot {

    @MockBean
    DepartmentRepository departmentRepository;

    @Autowired
    DepartmentService departmentService;

    static long start;
    static long finish;

    @BeforeAll
    static void beforeAll() {
        start = System.nanoTime();
    }

    @AfterAll
    static void afterAll() {
        finish = System.nanoTime();
        long timeElapsed = finish - start;
        System.out.printf("Czas wykonania: [%s] sekund", (double) timeElapsed / 1_000_000_000);
    }

    @Test
    void findDepartmentByName() {
        //given
        String departmentName = "IT";
        var department = new Department();
        department.setName(departmentName);
        department.setAddress(new Address(
                "Anglia", "Londyn", "Buckingham Street", "01011"));

        when(departmentRepository.findByName(Mockito.anyString()))
                .thenReturn(Optional.of(department));

        //when
        Department departmentByName = departmentService.findDepartmentByName(departmentName);

        //then
        Assertions.assertEquals(departmentName, departmentByName.getName());

    }

}
