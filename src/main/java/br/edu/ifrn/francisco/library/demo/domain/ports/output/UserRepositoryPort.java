package br.edu.ifrn.francisco.library.demo.domain.ports.output;

import br.edu.ifrn.francisco.library.demo.domain.model.User;

import java.util.List;

public interface UserRepositoryPort {
    List<User> findUsersByName(String partialName);
}
