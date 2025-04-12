package com.hackathon.hackhazards.multilingualcommunicator.Service.UserService;

import com.hackathon.hackhazards.multilingualcommunicator.Entity.User;
import com.hackathon.hackhazards.multilingualcommunicator.Entity.UserPrincipal;
import com.hackathon.hackhazards.multilingualcommunicator.Repository.UserRepo;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImple implements UserService, UserDetailsService {

    private final UserRepo userRepo;
    private final AuthenticationManager authManager;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);

    public UserServiceImple(UserRepo userRepo, @Lazy AuthenticationManager authManager) {
        this.userRepo = userRepo;
        this.authManager = authManager;
    }

    @Override
    public ResponseEntity<?> signUp(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
        return ResponseEntity.ok().body("User created");
    }

    @Override
    public ResponseEntity<?> deleteUser(String userName) {
        userRepo.deleteByUsername(userName);
        return ResponseEntity.ok().body("User deleted");
    }

    @Override
    public ResponseEntity<?> logIn(String username, String password) {
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(
                username, password
            )
        );
        if (!authentication.isAuthenticated())
            return ResponseEntity.badRequest().body("Login Failed");
        return ResponseEntity.ok().body("Login Successful");
    }

    @Override
    public ResponseEntity<?> changePassword(UUID userId, String password) {
        Optional<User> userOptional = userRepo.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setPassword(passwordEncoder.encode(password));
            userRepo.save(user);
        }
        return ResponseEntity.ok().body("Password changed successfully");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User users = userRepo.findUserByUsername(username);
        if (users == null)
            throw new UsernameNotFoundException("User Not Found");
        return new UserPrincipal(users);
    }
}