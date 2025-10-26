package br.edu.ifrn.francisco.library.demo.domain.ports.input;

import br.edu.ifrn.francisco.library.demo.domain.model.Loan;

import java.util.List;

public interface LoanServicePort {
    List<Loan> findActiveLoansByUserId(Long userId);
    List<Loan> findDelayedLoans();
}
