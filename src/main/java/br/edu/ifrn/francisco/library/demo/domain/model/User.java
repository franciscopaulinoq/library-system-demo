package br.edu.ifrn.francisco.library.demo.domain.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true, exclude = "loans")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class User extends AbstractDomain {
    private Long id;
    private String name;
    private String cpf;
    private String email;
    private String phone;
    private LocalDate registrationDate;
    private String address;
    private Boolean active;

    private List<Loan> loans;
}
