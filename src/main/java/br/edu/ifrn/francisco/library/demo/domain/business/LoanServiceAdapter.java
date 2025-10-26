package br.edu.ifrn.francisco.library.demo.domain.business;

import br.edu.ifrn.francisco.library.demo.domain.model.Loan;
import br.edu.ifrn.francisco.library.demo.domain.ports.input.LoanServicePort;
import br.edu.ifrn.francisco.library.demo.domain.ports.output.LoanRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanServiceAdapter implements LoanServicePort {
    private final LoanRepositoryPort loanRepositoryPort;

    @Override
    public List<Loan> findActiveLoansByUserId(Long userId) {
        return loanRepositoryPort.findActiveLoansByUserId(userId);
    }

    @Override
    public List<Loan> findDelayedLoans() {
        return loanRepositoryPort.findDelayedLoans();
    }
}
