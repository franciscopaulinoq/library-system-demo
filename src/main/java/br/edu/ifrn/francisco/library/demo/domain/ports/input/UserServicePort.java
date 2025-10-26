package br.edu.ifrn.francisco.library.demo.domain.ports.input;

import br.edu.ifrn.francisco.library.demo.domain.model.User;

import java.util.List;

public interface UserServicePort {
    List<User> findUsersByName(String partialName);
}
