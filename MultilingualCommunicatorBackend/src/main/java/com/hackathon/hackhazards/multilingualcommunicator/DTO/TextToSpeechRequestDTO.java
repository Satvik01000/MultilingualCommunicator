package com.hackathon.hackhazards.multilingualcommunicator.DTO;

import lombok.Data;

@Data
public class TextToSpeechRequestDTO {
    String inputText;
    String voice;
}
