package br.edu.ifrn.francisco.library.demo.adapters.output.persistence.mapper;

import br.edu.ifrn.francisco.library.demo.adapters.output.persistence.entity.UserEntity;
import br.edu.ifrn.francisco.library.demo.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {
    @Mapping(target = "loans", ignore = true)
    User toDomain(UserEntity entity);

    UserEntity toEntity(User domain);
}
