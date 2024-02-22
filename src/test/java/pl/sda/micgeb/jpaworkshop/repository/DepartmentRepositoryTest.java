package pl.sda.micgeb.jpaworkshop.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import pl.sda.micgeb.jpaworkshop.model.Address;
import pl.sda.micgeb.jpaworkshop.model.entity.Department;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    void findAllByName() {
        //given
        Department department1 = new Department();
        department1.setName("IT");
        department1.setAddress(new Address("Poland", "Warsaw", "Nowy Świat", "00-001"));
        departmentRepository.save(department1);

        //when
        List<Department> departments = departmentRepository.findAllByName("IT");

        //then
        Assertions.assertEquals(1, departments.size());
    }

}