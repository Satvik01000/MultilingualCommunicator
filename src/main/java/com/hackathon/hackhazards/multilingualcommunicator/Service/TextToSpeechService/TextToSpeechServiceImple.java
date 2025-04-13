package com.hackathon.hackhazards.multilingualcommunicator.Service.TextToSpeechService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TextToSpeechServiceImple implements TextToSpeechService {

    private final RestTemplate restTemplate;

    public TextToSpeechServiceImple(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${API_KEY}")
    private String apiKey;

    @Value("${API_URL_TEXT_SPEECH}")
    private String apiUrl;

    @Override
    public ResponseEntity<byte[]> textToSpeech(String inputText, String voice) {
        try {
            // Set headers
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setBearerAuth(apiKey);

            // JSON request body
            String requestBody = String.format(
                    "{\"model\": \"playai-tts\", \"input\": \"%s\", \"voice\": \"%s\", \"response_format\": \"wav\"}",
                    inputText.replace("\"", "\\\""),  // escape quotes if any
                    voice
            );

            HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

            // Make POST request
            ResponseEntity<byte[]> response = restTemplate.exchange(
                    apiUrl,
                    HttpMethod.POST,
                    entity,
                    byte[].class
            );

            return response;

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
