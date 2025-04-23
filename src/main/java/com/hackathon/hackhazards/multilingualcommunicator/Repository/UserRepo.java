package com.hackathon.hackhazards.multilingualcommunicator.Repository;

import com.hackathon.hackhazards.multilingualcommunicator.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepo extends JpaRepository<User, UUID> {
    User findUserByUsername(String username);
    void deleteByUsername(String username);
}
