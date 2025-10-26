package br.edu.ifrn.francisco.library.demo.domain.business;

import br.edu.ifrn.francisco.library.demo.domain.model.User;
import br.edu.ifrn.francisco.library.demo.domain.ports.input.UserServicePort;
import br.edu.ifrn.francisco.library.demo.domain.ports.output.UserRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceAdapter implements UserServicePort {
    private final UserRepositoryPort userRepositoryPort;

    @Override
    public List<User> findUsersByName(String partialName) {
        return userRepositoryPort.findUsersByName(partialName);
    }
}
