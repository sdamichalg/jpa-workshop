package pl.sda.micgeb.jpaworkshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.micgeb.jpaworkshop.model.entity.EntryCard;

public interface EntryCardRepository extends JpaRepository<EntryCard, Long> {
}
