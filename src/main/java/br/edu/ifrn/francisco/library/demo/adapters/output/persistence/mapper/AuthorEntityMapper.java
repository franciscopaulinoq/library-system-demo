package br.edu.ifrn.francisco.library.demo.adapters.output.persistence.mapper;

import br.edu.ifrn.francisco.library.demo.adapters.output.persistence.entity.AuthorEntity;
import br.edu.ifrn.francisco.library.demo.domain.model.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AuthorEntityMapper {
    @Mapping(target = "books", ignore = true)
    Author toDomain(AuthorEntity entity);

    AuthorEntity toEntity(Author domain);
}
