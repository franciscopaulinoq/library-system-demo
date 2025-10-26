package br.edu.ifrn.francisco.library.demo.adapters.output.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true, exclude = "books")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class CategoryEntity extends AbstractEntity {
    private String name;
    private String description;

    @OneToMany(mappedBy = "category")
    private List<BookEntity> books = new ArrayList<>();
}
