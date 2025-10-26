package br.edu.ifrn.francisco.library.demo.adapters.output.persistence.repository;

import br.edu.ifrn.francisco.library.demo.adapters.output.persistence.entity.LoanEntity;
import br.edu.ifrn.francisco.library.demo.domain.model.LoanStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface LoanRepository extends JpaRepository<LoanEntity, Long> {
    List<LoanEntity> findByUserIdAndLoanStatus(Long userId, LoanStatus status);

    List<LoanEntity> findByLoanStatusAndExpectedReturnDateBefore(LoanStatus status, LocalDate today);
}
