package br.edu.ifrn.francisco.library.demo.adapters.input.web.controller;

import br.edu.ifrn.francisco.library.demo.domain.model.Book;
import br.edu.ifrn.francisco.library.demo.domain.model.CategoryBookCount;
import br.edu.ifrn.francisco.library.demo.domain.ports.input.BookServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookServicePort bookServicePort;

    @GetMapping("/available")
    public ResponseEntity<List<Book>> getAvailableBooks() {
        return ResponseEntity.ok(bookServicePort.findAvailableBooks());
    }

    @GetMapping("/category/{name}")
    public ResponseEntity<List<Book>> getBooksByCategory(@PathVariable String name) {
        return ResponseEntity.ok(bookServicePort.findBooksByCategory(name));
    }

    @GetMapping("/author/{name}")
    public ResponseEntity<List<Book>> getBooksByAuthor(@PathVariable String name) {
        return ResponseEntity.ok(bookServicePort.findBooksByAuthor(name));
    }

    @GetMapping("/stats/count-by-category")
    public ResponseEntity<List<CategoryBookCount>> getCountByCategory() {
        return ResponseEntity.ok(bookServicePort.countBooksByCategory());
    }
}
