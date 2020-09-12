package by.tms.service;

import by.tms.entity.User;
import by.tms.service.exceptions.DouplicateUserException;

import java.util.List;

public interface UserService {
    void createUser(User user) throws DouplicateUserException;
    User getUserById(long id) throws NotUserFounde;
    User getUserByLogin(String login) throws NotUserFounde;
    List<User> getAllUsers();
    void remove(long id);
    void update(String name, long id);
    void update(User user);
    boolean containUserByLogin(String login);
}
