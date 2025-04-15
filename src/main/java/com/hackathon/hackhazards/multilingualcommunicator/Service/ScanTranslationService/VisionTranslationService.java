package com.hackathon.hackhazards.multilingualcommunicator.Service.ScanTranslationService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface VisionTranslationService {
    ResponseEntity<?> imageTranslate(MultipartFile file, String outputLang) throws IOException;
}
