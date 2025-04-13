package com.hackathon.hackhazards.multilingualcommunicator.Controller;

import com.hackathon.hackhazards.multilingualcommunicator.DTO.AudioTranslationRequestDTO;
import com.hackathon.hackhazards.multilingualcommunicator.DTO.AudioTranslationSpeechRequestDTO;
import com.hackathon.hackhazards.multilingualcommunicator.DTO.TextToSpeechRequestDTO;
import com.hackathon.hackhazards.multilingualcommunicator.Service.AudioTranslateService.AudioTranslateService;
import com.hackathon.hackhazards.multilingualcommunicator.Service.TextToSpeechService.TextToSpeechService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/audio")
public class AudioTranslateController {

    private final AudioTranslateService audioTranslateService;
    private final TextToSpeechService textToSpeechService;

    @Autowired
    public AudioTranslateController(AudioTranslateService audioTranslateService, TextToSpeechService textToSpeechService) {
        this.audioTranslateService = audioTranslateService;
        this.textToSpeechService = textToSpeechService;
    }

    @PostMapping("/translate")
    public ResponseEntity<?> translateAudio(@ModelAttribute AudioTranslationRequestDTO request) {
        return audioTranslateService.audioTranslate(request.getFile(), request.getOutputLang());
    }

    @PostMapping("/translate/speech")
    public ResponseEntity<byte[]> generateSpeech(@ModelAttribute AudioTranslationSpeechRequestDTO request){
        return audioTranslateService.audioTranslateSpeech(request.getFile(), request.getOutputLang(), request.getVoice());
    }

    @PostMapping("/text-speech")
    public ResponseEntity<byte[]> convertTextToSpeech(@RequestBody TextToSpeechRequestDTO textToSpeechRequestDTO) {
        ResponseEntity<byte[]> response = textToSpeechService.textToSpeech(textToSpeechRequestDTO.getInputText(), textToSpeechRequestDTO.getVoice());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, "audio/wav")
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"speech.wav\"")
                .body(response.getBody());
    }
}
