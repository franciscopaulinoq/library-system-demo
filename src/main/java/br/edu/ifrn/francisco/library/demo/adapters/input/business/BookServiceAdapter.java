package br.edu.ifrn.francisco.library.demo.adapters.input.business;

import br.edu.ifrn.francisco.library.demo.domain.model.Book;
import br.edu.ifrn.francisco.library.demo.domain.model.CategoryBookCount;
import br.edu.ifrn.francisco.library.demo.domain.ports.input.BookServicePort;
import br.edu.ifrn.francisco.library.demo.domain.ports.output.BookRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceAdapter implements BookServicePort {
    private final BookRepositoryPort bookRepositoryPort;

    @Override
    public List<Book> findAvailableBooks() {
        return bookRepositoryPort.findAvailableBooks();
    }

    @Override
    public List<Book> findBooksByCategory(String categoryName) {
        return bookRepositoryPort.findBooksByCategory(categoryName);
    }

    @Override
    public List<Book> findBooksByAuthor(String authorName) {
        return bookRepositoryPort.findBooksByAuthor(authorName);
    }

    @Override
    public List<CategoryBookCount> countBooksByCategory() {
        return bookRepositoryPort.countBooksByCategory();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepositoryPort.findById(id);
    }

    @Override
    public Book save(Book book) {
        return bookRepositoryPort.save(book);
    }
}
