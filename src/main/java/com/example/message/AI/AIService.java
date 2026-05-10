package com.example.message.AI;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AIService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String API_URL = "https://khanhduy2904-spam-detection-api.hf.space/predict";


    public PredictionResponse predict(String text) {
        MessageRequest newRequest = new MessageRequest(text);

        PredictionResponse response = restTemplate.postForObject(
                API_URL,
                newRequest,
                PredictionResponse.class
        );
        if (response == null) {
            throw new RuntimeException("AI API returned null");
        }

        return response;
    }

}
