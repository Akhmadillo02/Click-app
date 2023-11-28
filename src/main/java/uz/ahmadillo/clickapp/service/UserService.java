package uz.ahmadillo.clickapp.service;

import org.springframework.stereotype.Service;
import uz.ahmadillo.clickapp.entity.User;
import uz.ahmadillo.clickapp.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long userId, User user) {
        User existingUser = userRepository.findById(userId).orElseThrow();
        existingUser.setUsername(user.getUsername());
        existingUser.setBalance(user.getBalance());
        return userRepository.save(existingUser);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public void addMoneyToUserBalance(Long userId, double amount) {
        User user = getUserById(userId);
        user.setBalance(user.getBalance() + amount);
        updateUser(userId, user);
    }
}

