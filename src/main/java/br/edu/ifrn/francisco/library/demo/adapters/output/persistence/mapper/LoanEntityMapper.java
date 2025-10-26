package br.edu.ifrn.francisco.library.demo.adapters.output.persistence.mapper;

import br.edu.ifrn.francisco.library.demo.adapters.output.persistence.entity.LoanEntity;
import br.edu.ifrn.francisco.library.demo.domain.model.Loan;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserEntityMapper.class})
public interface LoanEntityMapper {
    Loan toDomain(LoanEntity entity);
    LoanEntity toEntity(Loan domain);
}
