package com.hackathon.hackhazards.multilingualcommunicator.Service.TextTranslateService;

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

    private final RestTemplate restTemplate;
    @Value("${API_URL_TEXT}")
    private String apiUrl;
    @Value("${API_KEY}")
    private String apiKey;

    public TextTranslateServiceImple(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public ResponseEntity<String> textTranslate(String prompt, String outputLang) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("model", "llama3-70b-8192");

        List<Map<String, String>> messages = new ArrayList<>();
        Map<String, String> message = new HashMap<>();
        message.put("role", "user");
        message.put("content", "Only translate it from the given language to the " + outputLang + ": " + prompt + "just translate from that language to " + outputLang + " no need for any explanation, I just need from give to the one I need in, just one answer which is the translated answer");
        requestBody.put("messages", messages);
        messages.add(message);

        requestBody.put("messages", messages);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(apiUrl, entity, String.class);
        System.out.println(response);
        return response;
    }
}
