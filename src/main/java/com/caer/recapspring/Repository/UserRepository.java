package com.caer.recapspring.Repository;

import com.caer.recapspring.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    @Autowired
    JdbcTemplate template;

    public void addUserToDatabase(User u) {
        String sql = "INSERT INTO users VALUES (?, ?)";
        template.update(sql, u.getId(), u.getUsername());
    }

    public User findUserById(String id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        RowMapper<User> rm = new BeanPropertyRowMapper<>(User.class);
        return template.queryForObject(sql, rm, id);
    }

    public void deleteUserFromDatabase(String id) {
        String sql = "DELETE FROM users WHERE id = ?";
        template.update(sql, id);
    }

    public void updateUserInDatabase(User u) {
        String sql = "UPDATE users SET username = ? WHERE id = ?";
        template.update(sql, u.getUsername(), u.getId());
    }

    public List<User> listUsersInDatabase() {
        String sql = "SELECT * FROM users";
        RowMapper<User> rm = new BeanPropertyRowMapper<>(User.class);
        return template.query(sql, rm);
    }
}
