package com.hackathon.hackhazards.multilingualcommunicator.Controller;

import com.hackathon.hackhazards.multilingualcommunicator.DTO.TextTranslateRequestDTO;
import com.hackathon.hackhazards.multilingualcommunicator.Service.TextTranslateService.TextTranslateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/text")
public class TextTranslateController {
    private final TextTranslateService translateService;

    public TextTranslateController(TextTranslateService translateService) {
        this.translateService = translateService;
    }
    @PostMapping
    public ResponseEntity<String> translate(@RequestBody TextTranslateRequestDTO translateRequestDTO){
        return translateService.translate(translateRequestDTO.getInput(), translateRequestDTO.getOutputLang());
    }

}
