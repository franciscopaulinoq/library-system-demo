package br.edu.ifrn.francisco.library.demo.adapters.output.persistence.entity;

import br.edu.ifrn.francisco.library.demo.domain.model.LoanStatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "loans")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true, exclude = "items")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class LoanEntity extends AbstractEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    private LocalDate loanDate;
    private LocalDate expectedReturnDate;
    private LocalDate effectiveReturnDate;

    @Enumerated(EnumType.STRING)
    private LoanStatus loanStatus;
    private Double valueFine;

    @OneToMany(mappedBy = "loan", cascade = CascadeType.ALL)
    private List<LoanItemEntity> items = new ArrayList<>();
}
