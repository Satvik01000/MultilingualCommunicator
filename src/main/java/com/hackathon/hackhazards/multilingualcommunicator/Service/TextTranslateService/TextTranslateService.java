package com.hackathon.hackhazards.multilingualcommunicator.Service.TextTranslateService;

import org.springframework.http.ResponseEntity;

public interface TextTranslateService {
    ResponseEntity<String> textTranslate(String prompt, String outputLang);
}
