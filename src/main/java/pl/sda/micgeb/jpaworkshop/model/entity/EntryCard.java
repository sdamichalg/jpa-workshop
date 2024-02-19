package pl.sda.micgeb.jpaworkshop.model.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class EntryCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(nullable = false)
    private UUID uuid;

    @ManyToMany
    @JoinTable(name = "floor_access",
            joinColumns = @JoinColumn(name = "entry_card_id"),
            inverseJoinColumns = @JoinColumn(name = "floor_id")
    )
    private Set<Floor> floorAccess;

    @Override
    public String toString() {
        return "EntryCard{" +
                "id=" + id +
                ", uuid=" + uuid +
                '}';
    }
}
