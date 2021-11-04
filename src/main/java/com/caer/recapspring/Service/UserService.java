package com.caer.recapspring.Service;

import com.caer.recapspring.Model.User;
import com.caer.recapspring.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository ur;

    public void addUserToDatabase(User u) {
        ur.addUserToDatabase(u);
    }

    public User findUserById(String id) {
        return ur.findUserById(id);
    }

    public void deleteUserFromDatabase(String id) {
        ur.deleteUserFromDatabase(id);
    }

    public void updateUserInDatabase(User u) {
        ur.updateUserInDatabase(u);
    }

    public List<User> listUsersInDatabase() {
        return ur.listUsersInDatabase();
    }
}
