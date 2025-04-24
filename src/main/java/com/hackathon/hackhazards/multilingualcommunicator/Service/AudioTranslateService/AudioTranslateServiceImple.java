package com.hackathon.hackhazards.multilingualcommunicator.Service.AudioTranslateService;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathon.hackhazards.multilingualcommunicator.Helper.MultipartInputStreamFileResource;
import com.hackathon.hackhazards.multilingualcommunicator.Service.TextToSpeechService.TextToSpeechService;
import com.hackathon.hackhazards.multilingualcommunicator.Service.TextTranslateService.TextTranslateService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AudioTranslateServiceImple implements AudioTranslateService{
    private final RestTemplate restTemplate;
    private final TextTranslateService textTranslateService;
    private final TextToSpeechService textToSpeechService;

    @Value("${API_URL_AUDIO}")
    private String apiUrlAudio;

    @Value("${API_URL_AUDIO_TRANSCRIBE}")
    private String apiUrlAudioTranscribe;

    @Value("${API_KEY}")
    private String apiKey;

    public AudioTranslateServiceImple(RestTemplate restTemplate, TextTranslateService textTranslateService, TextToSpeechService textToSpeechService) {
        this.restTemplate = restTemplate;
        this.textTranslateService = textTranslateService;
        this.textToSpeechService = textToSpeechService;
    }

    @Override
    public ResponseEntity<?> audioTranslate(MultipartFile file, String outputLang) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);
            headers.setBearerAuth(apiKey);

            MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
            body.add("file", new MultipartInputStreamFileResource(file.getInputStream(), file.getOriginalFilename()));
            body.add("model", "whisper-large-v3");

            HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

            ResponseEntity<String> response;
            ResponseEntity<String> ans;

            response = restTemplate.postForEntity(apiUrlAudio, requestEntity, String.class);
            if(outputLang.equals("English")) {
                return ResponseEntity.ok(response.getBody());
            } else{
                String transcribedText= new ObjectMapper().readTree(response.getBody()).get("text").asText();
                ans = textTranslateService.textTranslate(transcribedText, outputLang);
                return  ResponseEntity.ok(ans.getBody());
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Such file type is not accepted " + e.getMessage());
        }
    }

    @Override
    public ResponseEntity<byte[]> audioTranslateSpeech(MultipartFile file, String outputLang, String voice) {
        try {
            // Step 1: Get translation response
            ResponseEntity<?> translationResponse = audioTranslate(file, outputLang);
            if (!translationResponse.getStatusCode().is2xxSuccessful() || translationResponse.getBody() == null) {
                return ResponseEntity.status(500).body(null);
            }

            // Step 2: Parse translated text
            ObjectMapper objectMapper = new ObjectMapper();
            String bodyAsString = translationResponse.getBody().toString();
            String translatedText;

            if (outputLang.equalsIgnoreCase("English")) {
                translatedText = objectMapper.readTree(bodyAsString).get("text").asText();
            } else {
                translatedText = bodyAsString;
            }

            return textToSpeechService.textToSpeech(translatedText, voice);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }


}
