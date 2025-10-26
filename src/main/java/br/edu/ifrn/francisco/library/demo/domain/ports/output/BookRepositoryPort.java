package br.edu.ifrn.francisco.library.demo.domain.ports.output;

import br.edu.ifrn.francisco.library.demo.domain.model.Book;
import br.edu.ifrn.francisco.library.demo.domain.model.CategoryBookCount;

import java.util.List;
import java.util.Optional;

public interface BookRepositoryPort {
    List<Book> findAvailableBooks();
    List<Book> findBooksByCategory(String categoryName);
    List<Book> findBooksByAuthor(String authorName);
    List<CategoryBookCount> countBooksByCategory();

    Optional<Book> findById(Long id);
    Book save(Book book);
}
