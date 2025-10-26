package br.edu.ifrn.francisco.library.demo.adapters.output.persistence.adapters;

import br.edu.ifrn.francisco.library.demo.adapters.output.persistence.mapper.LoanEntityMapper;
import br.edu.ifrn.francisco.library.demo.adapters.output.persistence.repository.LoanRepository;
import br.edu.ifrn.francisco.library.demo.domain.model.Loan;
import br.edu.ifrn.francisco.library.demo.domain.model.LoanStatus;
import br.edu.ifrn.francisco.library.demo.domain.ports.output.LoanRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class LoanRepositoryAdapter implements LoanRepositoryPort {
    private final LoanRepository loanRepository;
    private final LoanEntityMapper entityMapper;

    @Override
    public List<Loan> findActiveLoansByUserId(Long userId) {
        return loanRepository.findByUserIdAndLoanStatus(userId, LoanStatus.ACTIVE)
                .stream()
                .map(entityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Loan> findDelayedLoans() {
        return loanRepository.findByLoanStatusAndExpectedReturnDateBefore(LoanStatus.ACTIVE, LocalDate.now())
                .stream()
                .map(entityMapper::toDomain)
                .collect(Collectors.toList());
    }
}
