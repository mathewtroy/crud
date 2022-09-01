package applifting.service;

import applifting.interfaces.UserRepository;
import applifting.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public static User setUser(User user) {
        return user;
    }

    //getting all users record by using the method findaAll() of CrudRepository
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //getting a specific record by using the method findById() of CrudRepository
    public User getUserById(Long id) {
        return userRepository.getReferenceById(id);
    }

    //saving a specific record by using the method save() of CrudRepository
    public void saveOrUpdate(User user) {
        userRepository.save(user);
    }

    //deleting a specific record by using the method deleteById() of CrudRepository
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    //updating a record
    public void update(User user) {
        userRepository.save(user);
    }

    public List<User> getUser() {
        return null;
    }
}
