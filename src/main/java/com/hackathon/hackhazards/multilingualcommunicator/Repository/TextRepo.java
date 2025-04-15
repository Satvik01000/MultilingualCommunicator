package com.hackathon.hackhazards.multilingualcommunicator.Repository;

import com.hackathon.hackhazards.multilingualcommunicator.Entity.Text;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TextRepo extends JpaRepository<Text, UUID> {
}
