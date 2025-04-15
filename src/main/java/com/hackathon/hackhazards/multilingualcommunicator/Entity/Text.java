package com.hackathon.hackhazards.multilingualcommunicator.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Text extends BaseModel{
    private String message;
    private String translatedText;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
