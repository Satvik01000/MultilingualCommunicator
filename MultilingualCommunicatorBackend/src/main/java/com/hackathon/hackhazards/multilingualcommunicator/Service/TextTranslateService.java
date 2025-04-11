package com.hackathon.hackhazards.multilingualcommunicator.Service;

import org.springframework.http.ResponseEntity;

public interface TextTranslateService {
    ResponseEntity<String> translate(String prompt, String outputLang);
}
