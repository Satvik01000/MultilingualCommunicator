package com.hackathon.hackhazards.multilingualcommunicator.DTO.Request;

import lombok.Data;

@Data
public class TextToSpeechRequestDTO {
    String inputText;
    String voice;
}
