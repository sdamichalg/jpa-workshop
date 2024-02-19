package pl.sda.micgeb.jpaworkshop.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    private String firstName;
    private String lastName;
    private BigDecimal salary;
    private LocalDate contractEnd;

    @ManyToOne
    @JoinColumn(name = "dep_id")
    @JsonBackReference
    private Department department;
    @OneToOne
    private EntryCard entryCard;

    @ManyToOne
    @JoinColumn(name = "supervisor_id")
    @JsonBackReference
    private Supervisor supervisor;
}
