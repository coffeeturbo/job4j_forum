package forum.service;

import forum.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class UserService {

    AtomicInteger it = new AtomicInteger();

    private final List<User> users = new ArrayList<>();

    public UserService() {
        users.add(User.builder()
                .id(it.incrementAndGet()).username("user").password("1234")
                .build());
    }

    public User add(User user) throws Exception {

        var duplicateUser = findByUsername(user.getUsername());
        if (duplicateUser != null) {
            throw new Exception("user with this name already exists");
        }

        user.setId(it.incrementAndGet());
        users.add(user);

        return user;
    }

    public User findByUsername(String userName) {

        for (User user : users) {
            if (user.getUsername().equals(userName)) {
                return user;
            }
        }

        return null;
    }
}
