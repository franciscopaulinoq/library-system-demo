package br.edu.ifrn.francisco.library.demo.domain.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractDomain {
    private Long id;
}
