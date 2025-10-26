package br.edu.ifrn.francisco.library.demo.adapters.output.persistence.mapper;

import br.edu.ifrn.francisco.library.demo.adapters.output.persistence.entity.BookEntity;
import br.edu.ifrn.francisco.library.demo.domain.model.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {AuthorEntityMapper.class, CategoryEntityMapper.class, LoanEntityMapper.class})
public interface BookEntityMapper {
    Book toDomain(BookEntity entity);

    BookEntity toEntity(Book domain);
}
