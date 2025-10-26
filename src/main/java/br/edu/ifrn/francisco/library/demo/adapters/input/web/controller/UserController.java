package br.edu.ifrn.francisco.library.demo.adapters.input.web.controller;

import br.edu.ifrn.francisco.library.demo.domain.model.User;
import br.edu.ifrn.francisco.library.demo.domain.ports.input.UserServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserServicePort userServicePort;

    @GetMapping
    public ResponseEntity<List<User>> getUsersByName(@RequestParam String name) {
        return ResponseEntity.ok(userServicePort.findUsersByName(name));
    }
}
