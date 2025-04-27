package dio.web.api.repository;

import dio.web.api.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    private List<User> users = new ArrayList<>();

    public List<User> findAll() {
        users.add(new User("batata123", "123456"));
        users.add(new User("123batata", "456789"));
        return users;
    }

    public Optional<User> findByUsername(String username) {
        return users.stream()
                .filter(user -> user.getLogin().equals(username))
                .findFirst();
    }

    public Optional<User> findById(int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst();
    }

    public User save(User user) {
        // Se o ID for zero ou não existir, cria um novo ID
        if (user.getId() == 0) {
            user.setId(users.size() + 1);
        }
        users.add(user);
        return user;
    }

    public void deleteById(int id) {
        System.out.println("Conta de id: " + id + " Deletada.");
    }
}
