package br.edu.ifrn.francisco.library.demo.adapters.output.persistence.adapters;

import br.edu.ifrn.francisco.library.demo.adapters.output.persistence.mapper.UserEntityMapper;
import br.edu.ifrn.francisco.library.demo.adapters.output.persistence.repository.UserRepository;
import br.edu.ifrn.francisco.library.demo.domain.model.User;
import br.edu.ifrn.francisco.library.demo.domain.ports.output.UserRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepositoryPort {
    private final UserRepository userRepository;
    private final UserEntityMapper entityMapper;

    @Override
    public List<User> findUsersByName(String partialName) {
        return userRepository.findByNameContainingIgnoreCase(partialName)
                .stream()
                .map(entityMapper::toDomain)
                .collect(Collectors.toList());
    }
}
