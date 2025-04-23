package com.hackathon.hackhazards.multilingualcommunicator.Controller;

import com.hackathon.hackhazards.multilingualcommunicator.DTO.Request.ImageTranslationRequestDTO;
import com.hackathon.hackhazards.multilingualcommunicator.Service.ScanTranslationService.VisionTranslationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/vision")
public class VisionTranslatorController {
    private final VisionTranslationService visionTranslationService;

    public VisionTranslatorController(VisionTranslationService visionTranslationService) {
        this.visionTranslationService = visionTranslationService;
    }
    @PostMapping("/image/translate")
    ResponseEntity<?> imageTranslate(@ModelAttribute ImageTranslationRequestDTO request) throws IOException {
        return visionTranslationService.imageTranslate(request.getFile(), request.getOutputLang());
    }
}
