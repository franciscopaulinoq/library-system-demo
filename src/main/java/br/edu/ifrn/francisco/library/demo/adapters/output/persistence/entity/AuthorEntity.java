package br.edu.ifrn.francisco.library.demo.adapters.output.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "authors")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true, exclude = "books")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class AuthorEntity extends AbstractEntity {
    private String name;

    @Column(name = "birth_date")
    private LocalDate birthDate;
    private String nationality;
    private String biography;

    @ManyToMany(mappedBy = "authors")
    private Set<BookEntity> books = new HashSet<>();
}
