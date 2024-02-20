package pl.sda.micgeb.jpaworkshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.micgeb.jpaworkshop.model.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
