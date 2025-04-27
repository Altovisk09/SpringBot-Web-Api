package dio.web.api.controller;

import dio.web.api.model.User;
import dio.web.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository repository;
    @GetMapping("/users")
    public List<User> getUsers(){
        return repository.findAll();
    }
    @GetMapping("/users/{username}")
    public User getUser(@PathVariable("username") String username) {
        return repository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found with username: " + username));
    }
    @PostMapping("/users")
    public String createUser(@RequestBody User user) {
        System.out.println("Chamando o método createUser para criar um novo usuário.");
        User savedUser = repository.save(user);
        return "Usuário " + savedUser.getLogin() + " criado com sucesso!";  // Retorna uma mensagem de sucesso
    }
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable("id") int id){
        repository.deleteById(id);
    }
}
