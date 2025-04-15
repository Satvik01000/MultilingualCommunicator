package com.hackathon.hackhazards.multilingualcommunicator.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hackathon.hackhazards.multilingualcommunicator.DTO.Request.TextTranslateRequestDTO;
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
    @PostMapping("/translate")
    public ResponseEntity<String> translate(@RequestBody TextTranslateRequestDTO translateRequestDTO) throws JsonProcessingException {
        return translateService.textTranslate(translateRequestDTO.getInput(), translateRequestDTO.getOutputLang());
    }

}
