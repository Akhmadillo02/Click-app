package uz.ahmadillo.clickapp.controller;

import org.springframework.web.bind.annotation.*;
import uz.ahmadillo.clickapp.TransferRequest;
import uz.ahmadillo.clickapp.entity.User;
import uz.ahmadillo.clickapp.service.ClickAppService;
import uz.ahmadillo.clickapp.service.UserService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/userId")
    public User updateUser(@PathVariable Long userId, @RequestBody User user) {
        User existingUser = userService.getUserById(userId);
        existingUser.setUsername(user.getUsername());
        existingUser.setBalance(user.getBalance());
        return userService.createUser(existingUser);
    }

    @DeleteMapping("/deleteByUserId")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }


    @PostMapping("/userId/addMoney")
    public void addMoneyToUserBalance(@PathVariable Long userId,@RequestParam double amount ){
        userService.addMoneyToUserBalance(userId, amount);
    }

}

