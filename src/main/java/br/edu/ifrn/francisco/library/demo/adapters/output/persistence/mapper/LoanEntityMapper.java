package br.edu.ifrn.francisco.library.demo.adapters.output.persistence.mapper;

import br.edu.ifrn.francisco.library.demo.adapters.output.persistence.entity.LoanEntity;
import br.edu.ifrn.francisco.library.demo.domain.model.Loan;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserEntityMapper.class})
public interface LoanEntityMapper {
    @Mapping(target = "items", ignore = true)
    Loan toDomain(LoanEntity entity);

    LoanEntity toEntity(Loan domain);
}
