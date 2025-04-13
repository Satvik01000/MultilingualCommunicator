package com.hackathon.hackhazards.multilingualcommunicator.Service.TextToSpeechService;

import org.springframework.http.ResponseEntity;

public interface TextToSpeechService {
    ResponseEntity<byte[]> textToSpeech(String inputText, String voice);
}
