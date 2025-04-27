package dio.web.api.controller;

import dio.web.api.model.User;
import dio.web.api.repository.UserRepository;
import dio.web.api.handler.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository repository;

    // Endpoint para listar todos os usuários
    @GetMapping
    public List<User> getUsers() {
        return repository.findAll();
    }

    // Endpoint para obter um usuário pelo nome de usuário
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username) {
        return repository.findByUsername(username)
                .orElseThrow(() -> new BusinessException("User not found with username: " + username));
    }

    // Endpoint para criar um novo usuário
    @PostMapping
    public String createUser(@RequestBody User user) {
        if (user.getLogin() == null || user.getLogin().isEmpty()) {
            throw new BusinessException("Username is required");
        }
        User savedUser = repository.save(user);
        return "Usuário " + savedUser.getLogin() + " criado com sucesso!";
    }

    // Endpoint para excluir um usuário
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        repository.deleteById(id);
        return "Usuário com id " + id + " deletado com sucesso!";
    }
}
