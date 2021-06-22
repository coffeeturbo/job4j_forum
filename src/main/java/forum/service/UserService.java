package forum.service;

import forum.model.User;
import forum.repository.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User add(User user) throws Exception {

        var duplicateUser = findByUsername(user.getUsername());
        if (duplicateUser != null) {
            throw new Exception("user with this name already exists");
        }

        repository.save(user);

        return user;
    }

    public User findByUsername(String userName) {
        return repository.findByUsername(userName);
    }
}
