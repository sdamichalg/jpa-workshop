package pl.sda.micgeb.jpaworkshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.micgeb.jpaworkshop.model.entity.Author;
import pl.sda.micgeb.jpaworkshop.repository.AuthorRepository;

import java.util.Optional;

@RestController
@RequestMapping("/author")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorRepository authorRepository;

    @DeleteMapping
    public ResponseEntity<Void> deleteBooksById() {
        Optional<Author> byId = authorRepository.findById(1L);
        byId.ifPresent(author -> author.getBooks().clear());

        return ResponseEntity.ok().build();
    }
}
