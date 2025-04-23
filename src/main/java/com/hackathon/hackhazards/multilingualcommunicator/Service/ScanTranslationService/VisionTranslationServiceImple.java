package com.hackathon.hackhazards.multilingualcommunicator.Service.ScanTranslationService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
public class VisionTranslationServiceImple implements VisionTranslationService {

    @Value("${API_URL_IMAGE}")
    private String API_URL_IMAGE;
    @Value("${API_KEY}")
    private String API_KEY;
    @Value("${IMAGE_DIRECTORY}")
    private String uploadPath;

    public ResponseEntity<?> imageTranslate(MultipartFile file, String outputLang) throws IOException {
        byte[] imageBytes = file.getBytes();
        String base64Image = Base64.getEncoder().encodeToString(imageBytes);

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("model", "meta-llama/llama-4-scout-17b-16e-instruct");
        requestBody.put("temperature", 1);
        requestBody.put("max_tokens", 1024);
        requestBody.put("top_p", 1);
        requestBody.put("stream", false);

        List<Map<String, Object>> contentList = new ArrayList<>();

        contentList.add(Map.of(
                "type", "text",
                "text", "Translate this image to " + outputLang + ". Only return the translated text, nothing else."
        ));

        Map<String, Object> imageMap = new HashMap<>();
        imageMap.put("type", "image_url");
        imageMap.put("image_url", Map.of(
                "url", "data:image/jpeg;base64," + base64Image
        ));
        contentList.add(imageMap);

        Map<String, Object> message = new HashMap<>();
        message.put("role", "user");
        message.put("content", contentList);

        requestBody.put("messages", List.of(message));

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + API_KEY);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.exchange(API_URL_IMAGE, HttpMethod.POST, entity, String.class).getBody();
        String translatedText = new ObjectMapper()
                .readTree(response)
                .get("choices")
                .get(0)
                .get("message")
                .get("content")
                .asText();
        return ResponseEntity.ok().body(translatedText);
    }

}