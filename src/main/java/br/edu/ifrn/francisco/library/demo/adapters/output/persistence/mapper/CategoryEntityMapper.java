package br.edu.ifrn.francisco.library.demo.adapters.output.persistence.mapper;

import br.edu.ifrn.francisco.library.demo.adapters.output.persistence.entity.CategoryEntity;
import br.edu.ifrn.francisco.library.demo.domain.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryEntityMapper {
    @Mapping(target = "books", ignore = true)
    Category toDomain(CategoryEntity entity);

    CategoryEntity toEntity(Category domain);
}
