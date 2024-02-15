package pl.sda.micgeb.jpaworkshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.micgeb.jpaworkshop.model.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
