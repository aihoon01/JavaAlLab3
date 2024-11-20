package org.exercises.userservice;

import org.exercises.userservice.Entity.User;
import org.exercises.userservice.UserRepository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepo;

    public UserService(UserRepository userRepository) {
        this.userRepo = userRepository;
    }

    public User registerUser(User user) {
        //Logic for password hashing and saving the user
        return userRepo.save(user);
    }
}
