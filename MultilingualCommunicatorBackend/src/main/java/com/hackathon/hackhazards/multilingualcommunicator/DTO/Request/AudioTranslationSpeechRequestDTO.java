package com.hackathon.hackhazards.multilingualcommunicator.DTO.Request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class AudioTranslationSpeechRequestDTO {
    MultipartFile file;
    String outputLang;
    String voice;
}
