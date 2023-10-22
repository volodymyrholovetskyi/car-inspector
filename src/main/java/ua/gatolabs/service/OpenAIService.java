package ua.gatolabs.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ua.gatolabs.web.dto.CarCharacteristic;
import ua.gatolabs.web.dto.ChatRequest;
import ua.gatolabs.web.dto.ChatResponse;

@Service
public class OpenAIService {

    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.url}")
    private String apiUrl;
    @Value("${prefix.prompt.description}")
    private String promptDescription;

    @Value("${prefix.prompt.characteristics}")
    private String promptCharacteristics;

    private String contentDescription;

    private final RestTemplate restTemplate;

    private final ObjectMapper objectMapper;

    public OpenAIService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public ChatResponse getCharacteristicsFromDescription(final DescriptionRequest request) {
        final String prompt = promptDescription + ". " + request.getDescription();
        ResponseEntity<ChatResponse> responseBody = getResponseBody(prompt);
        ChatResponse result = responseBody.getBody();
        if (result != null) {
            this.contentDescription = result.getChoices().get(0).getMessage().getContent();
        }
        return result;
    }

    public ChatResponse compareCharacteristics(CarCharacteristic carCharacteristic) {
        try {
            String jsonResult = objectMapper.writeValueAsString(carCharacteristic);
            final var prompt = promptCharacteristics + " " + this.contentDescription + " and " + jsonResult;
            return getResponseBody(prompt).getBody();
        } catch (Exception e) {
            throw new IllegalStateException("Error in method compareCharacteristics()!!!");
        }
    }

    private ResponseEntity<ChatResponse> getResponseBody(String prompt) {
        final var chatRequest = new ChatRequest(model, prompt);
        final var http = new HttpEntity<>(chatRequest);
        return restTemplate.exchange(apiUrl, HttpMethod.POST, http,
                new ParameterizedTypeReference<ChatResponse>() {
                });
    }

}
