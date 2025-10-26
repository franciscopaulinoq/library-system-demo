package br.edu.ifrn.francisco.library.demo.adapters.output.persistence.adapters;

import br.edu.ifrn.francisco.library.demo.adapters.output.persistence.entity.BookEntity;
import br.edu.ifrn.francisco.library.demo.adapters.output.persistence.mapper.BookEntityMapper;
import br.edu.ifrn.francisco.library.demo.adapters.output.persistence.repository.BookRepository;
import br.edu.ifrn.francisco.library.demo.domain.model.Book;
import br.edu.ifrn.francisco.library.demo.domain.model.CategoryBookCount;
import br.edu.ifrn.francisco.library.demo.domain.ports.output.BookRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class BookRepositoryAdapter implements BookRepositoryPort {
    private final BookRepository bookRepository;
    private final BookEntityMapper entityMapper;

    @Override
    public List<Book> findAvailableBooks() {
        return bookRepository.findByAvailableQuantityGreaterThanOrderByTitle(0)
                .stream()
                .map(entityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> findBooksByCategory(String categoryName) {
        return bookRepository.findByCategoryName(categoryName)
                .stream()
                .map(entityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> findBooksByAuthor(String authorName) {
        return bookRepository.findByAuthorsNameOrderByPublishedYear(authorName)
                .stream()
                .map(entityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<CategoryBookCount> countBooksByCategory() {
        return bookRepository.countBooksByCategory()
                .stream()
                .map(proj -> new CategoryBookCount(proj.getCategoryName(), proj.getBookCount()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id).map(entityMapper::toDomain);
    }

    @Override
    public Book save(Book book) {
        BookEntity entity = entityMapper.toEntity(book);
        BookEntity savedEntity = bookRepository.save(entity);
        return entityMapper.toDomain(savedEntity);
    }
}
