package dev.ifrs.repository;
import java.util.ArrayList;

import dev.ifrs.entity.User;

public class Repository implements IRepository {

    ArrayList<User> userList = new ArrayList<User>();

    @Override
    public User persistUser(User user) {
        userList.add(user);

        return user;
    }
    
}
