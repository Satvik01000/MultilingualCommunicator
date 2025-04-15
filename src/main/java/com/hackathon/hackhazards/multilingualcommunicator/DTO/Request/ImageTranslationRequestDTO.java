package com.hackathon.hackhazards.multilingualcommunicator.DTO.Request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class ImageTranslationRequestDTO {
    MultipartFile file;
    String outputLang;
}
