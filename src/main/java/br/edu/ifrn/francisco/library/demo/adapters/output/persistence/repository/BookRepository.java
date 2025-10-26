package br.edu.ifrn.francisco.library.demo.adapters.output.persistence.repository;

import br.edu.ifrn.francisco.library.demo.adapters.output.persistence.dto.CategoryBookCountProjection;
import br.edu.ifrn.francisco.library.demo.adapters.output.persistence.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
    List<BookEntity> findByAvailableQuantityGreaterThanOrderByTitle(int quantity);

    List<BookEntity> findByCategoryName(String categoryName);

    List<BookEntity> findByAuthorsNameOrderByPublishedYear(String authorName);

    @Query("SELECT c.name as categoryName, COUNT(b.id) as bookCount " +
            "FROM BookEntity b JOIN b.category c " +
            "GROUP BY c.name " +
            "ORDER BY bookCount DESC")
    List<CategoryBookCountProjection> countBooksByCategory();
}
