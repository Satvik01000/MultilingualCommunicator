package com.hackathon.hackhazards.multilingualcommunicator.DTO;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class AudioTranslationRequestDTO {
    private MultipartFile file;
    private String outputLang;
}
