package com.hackathon.hackhazards.multilingualcommunicator.Controller;

import com.hackathon.hackhazards.multilingualcommunicator.DTO.Request.LoginDTO;
import com.hackathon.hackhazards.multilingualcommunicator.DTO.Request.PasswordChangeRequestDTO;
import com.hackathon.hackhazards.multilingualcommunicator.Entity.User;
import com.hackathon.hackhazards.multilingualcommunicator.Repository.UserRepo;
import com.hackathon.hackhazards.multilingualcommunicator.Service.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final UserRepo userRepo;

    @Autowired
    public UserController(UserService userService, UserRepo userRepo){
        this.userService = userService;
        this.userRepo = userRepo;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<String> signUp(@RequestBody User user) {
        if (userRepo.findUserByUsername(user.getUsername()) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already exists");
        }
        userService.signUp(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        return userService.logIn(loginDTO.getUsername(), loginDTO.getPassword());
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<?> deleteUser(@PathVariable String username) {
       return userService.deleteUser(username);
    }

    @GetMapping("/name/{username}")
    public String usernameToName(@PathVariable String username) {
        return userRepo.findUserByUsername(username).getName();
    }

    @GetMapping("/{username}")
    public UUID usernameToId(@PathVariable String username) {
        return userRepo.findUserByUsername(username).getId();
    }

    @GetMapping("/valid/{username}")
    public Boolean validUsername(@PathVariable String username) {
        return userRepo.findUserByUsername(username) != null;
    }

    @PatchMapping("/password/{userId}")
    public ResponseEntity<?> changeUserPassword(@PathVariable UUID userId, @RequestBody PasswordChangeRequestDTO passwordChangeRequestDTO) {
        return userService.changePassword(userId, passwordChangeRequestDTO.getPassword());
    }
}