package pl.sda.micgeb.jpaworkshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.sda.micgeb.jpaworkshop.model.entity.Employee;

import java.math.BigDecimal;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Modifying
    @Query("UPDATE Employee e SET e.salary = :newSalary WHERE e.lastName = :lastName")
    void updateSalaryByLastName(String lastName, BigDecimal newSalary);

//    List<Employee> findAllBySalaryBetween (BigDecimal min, BigDecimal max);

    @Query("select e from Employee e where e.salary between :min and :max")
    List<Employee> findAllBySalaryBetween (@Param("min") BigDecimal min, @Param("max") BigDecimal max);

}
