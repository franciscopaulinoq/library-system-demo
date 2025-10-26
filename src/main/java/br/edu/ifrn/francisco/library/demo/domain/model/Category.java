package br.edu.ifrn.francisco.library.demo.domain.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true, exclude = "books")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Category extends AbstractDomain {
    private String name;
    private String description;

    private List<Book> books = new ArrayList<>();
}
