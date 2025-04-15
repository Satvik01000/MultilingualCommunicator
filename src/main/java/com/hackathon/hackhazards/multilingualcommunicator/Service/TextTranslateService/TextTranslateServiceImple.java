package com.hackathon.hackhazards.multilingualcommunicator.Service.TextTranslateService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathon.hackhazards.multilingualcommunicator.Entity.Text;
import com.hackathon.hackhazards.multilingualcommunicator.Repository.TextRepo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TextTranslateServiceImple implements TextTranslateService {
    private final TextRepo textRepo;
    private final RestTemplate restTemplate;
    @Value("${API_URL_TEXT}")
    private String apiUrl;
    @Value("${API_KEY}")
    private String apiKey;
    public TextTranslateServiceImple(TextRepo textRepo, RestTemplate restTemplate) {
        this.textRepo = textRepo;
        this.restTemplate = restTemplate;
    }

    @Override
    public ResponseEntity<String> textTranslate(String prompt, String outputLang) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("model", "llama3-70b-8192");

        List<Map<String, String>> messages = new ArrayList<>();
        Map<String, String> message = new HashMap<>();
        message.put("role", "user");
        String finalPrompt = "Translate the following to " + outputLang +
                ". Respond with only the translated text and nothing else: " + prompt;
        message.put("content", finalPrompt);
        requestBody.put("messages", messages);
        messages.add(message);

        requestBody.put("messages", messages);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(apiUrl, entity, String.class);
        String responseBody = response.getBody();
        String translatedText = new ObjectMapper()
                .readTree(responseBody)
                .get("choices")
                .get(0)
                .get("message")
                .get("content")
                .asText();
        return ResponseEntity.ok().body(translatedText);
    }
}
