package com.hackathon.hackhazards.multilingualcommunicator.Service.UserService;

import com.hackathon.hackhazards.multilingualcommunicator.Entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public interface UserService {
    ResponseEntity<?> signUp(User user);
    ResponseEntity<?> deleteUser(String userName);
    ResponseEntity<?> logIn(String username, String password);
    ResponseEntity<?> changePassword(UUID userId, String password);
}

