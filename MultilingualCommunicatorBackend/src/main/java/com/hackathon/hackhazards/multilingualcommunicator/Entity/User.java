package com.hackathon.hackhazards.multilingualcommunicator.Entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class User extends BaseModel{
    private String name;
    private String username;
    private String email;
    private String password;
}
