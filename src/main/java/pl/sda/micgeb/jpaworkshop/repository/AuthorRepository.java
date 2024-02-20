package pl.sda.micgeb.jpaworkshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.sda.micgeb.jpaworkshop.model.entity.Author;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query(value = "select a from Author a join fetch a.books")
    List<Author> findAll();
}
