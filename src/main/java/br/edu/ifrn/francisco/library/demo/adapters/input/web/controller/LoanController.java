package br.edu.ifrn.francisco.library.demo.adapters.input.web.controller;

import br.edu.ifrn.francisco.library.demo.domain.model.Loan;
import br.edu.ifrn.francisco.library.demo.domain.ports.input.LoanServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
@RequiredArgsConstructor
public class LoanController {
    private final LoanServicePort loanServicePort;

    @GetMapping("/active/{user_id}")
    public ResponseEntity<List<Loan>> getActiveLoansByUser(@PathVariable Long user_id) {
        return ResponseEntity.ok(loanServicePort.findActiveLoansByUserId(user_id));
    }

    @GetMapping("/delayed")
    public ResponseEntity<List<Loan>> getDelayedLoans() {
        return ResponseEntity.ok(loanServicePort.findDelayedLoans());
    }
}
