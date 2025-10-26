package br.edu.ifrn.francisco.library.demo.domain.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.*;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true, exclude = "books")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Author extends AbstractDomain {
    private String name;
    private LocalDate birthDate;
    private String nationality;
    private String biography;

    private Set<Book> books = new HashSet<>();
}
