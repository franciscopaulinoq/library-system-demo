package br.edu.ifrn.francisco.library.demo.domain.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true, exclude = {"authors", "bookLoans"})
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Book extends AbstractDomain {
    private String isbn;
    private String title;
    private String publisher;
    private Integer publishedYear;
    private Integer numberOfPages;
    private Integer totalQuantity;
    private Integer availableQuantity;
    private Category category;

    private Set<Author> authors = new HashSet<>();
    private List<LoanItem> bookLoans = new ArrayList<>();

    public void addAuthor(Author author) {
        this.authors.add(author);
        author.getBooks().add(this);
    }

    public void removeAuthor(Author author) {
        this.authors.remove(author);
        author.getBooks().remove(this);
    }
}
