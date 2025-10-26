package br.edu.ifrn.francisco.library.demo.domain.ports.output;

import br.edu.ifrn.francisco.library.demo.domain.model.Loan;

import java.util.List;

public interface LoanRepositoryPort {
    List<Loan> findActiveLoansByUserId(Long userId);
    List<Loan> findDelayedLoans();
}
