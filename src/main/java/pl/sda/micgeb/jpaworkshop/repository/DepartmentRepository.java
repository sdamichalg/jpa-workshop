package pl.sda.micgeb.jpaworkshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.micgeb.jpaworkshop.model.entity.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Optional<Department> findByName (String name);

    List<Department> findAllByAddress_City(String city);
}
