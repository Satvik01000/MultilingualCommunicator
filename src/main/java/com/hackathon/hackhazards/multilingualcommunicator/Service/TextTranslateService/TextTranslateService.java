package com.hackathon.hackhazards.multilingualcommunicator.Service.TextTranslateService;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;

public interface TextTranslateService {
    ResponseEntity<String> textTranslate(String prompt, String outputLang) throws JsonProcessingException;
}
