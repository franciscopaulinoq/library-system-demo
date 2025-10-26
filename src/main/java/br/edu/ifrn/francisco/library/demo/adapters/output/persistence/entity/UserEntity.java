package br.edu.ifrn.francisco.library.demo.adapters.output.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true, exclude = "loans")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class UserEntity extends AbstractEntity {
    private String name;
    private String cpf;
    private String email;
    private String phone;
    private LocalDate registrationDate;
    private String address;
    private Boolean active;

    @OneToMany(mappedBy = "user")
    private List<LoanEntity> loans = new ArrayList<>();
}
