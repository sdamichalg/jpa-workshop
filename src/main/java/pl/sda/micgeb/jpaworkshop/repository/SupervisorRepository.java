package pl.sda.micgeb.jpaworkshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.micgeb.jpaworkshop.model.entity.Supervisor;

public interface SupervisorRepository extends JpaRepository<Supervisor, Long> {
}
