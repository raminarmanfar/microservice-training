package com.armanfar.helloworld.user;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDaoService {

    private static final List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "Adam", LocalDate.now().minusYears(30)));
        users.add(new User(2, "Eve", LocalDate.now().minusYears(25)));
        users.add(new User(3, "Jim", LocalDate.now().minusYears(20)));
        users.add(new User(4, "Ramin", LocalDate.now().minusYears(42)));
    }

    private static int userCount = users.size();

    public List<User> findAll() {
        return users;
    }

    public User findOne(int id) {
        return users.stream().filter(u -> u.getId().equals(id)).findFirst().orElse(null);
    }

    public User save(User user) {
        user.setId(++userCount);
        users.add(user);
        return user;
    }

    public User delete(int id) {
        User user = findOne(id);
        if (user != null) {
            users.remove(user);
        }
        return user;
    }
}
