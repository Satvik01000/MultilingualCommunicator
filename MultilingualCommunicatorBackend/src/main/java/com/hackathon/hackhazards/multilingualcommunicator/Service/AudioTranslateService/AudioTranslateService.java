package com.hackathon.hackhazards.multilingualcommunicator.Service.AudioTranslateService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface AudioTranslateService {
    ResponseEntity<?> audioTranslate(MultipartFile file, String outputLang);
    ResponseEntity<byte[]> audioTranslateSpeech(MultipartFile file, String outputLang, String voice);
}
