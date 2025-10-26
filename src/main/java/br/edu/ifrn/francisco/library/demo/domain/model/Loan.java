package br.edu.ifrn.francisco.library.demo.domain.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true, exclude = "items")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Loan extends AbstractDomain {
    private Long id;
    private User user;
    private LocalDate loanDate;
    private LocalDate expectedReturnDate;
    private LocalDate effectiveReturnDate;
    private LoanStatus loanStatus;
    private Double valueFine;

    private List<LoanItem> items = new ArrayList<>();
}
