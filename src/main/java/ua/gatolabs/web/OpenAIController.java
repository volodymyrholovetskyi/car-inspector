package ua.gatolabs.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.gatolabs.service.DescriptionRequest;
import ua.gatolabs.service.OpenAIService;
import ua.gatolabs.web.dto.CarCharacteristic;
import ua.gatolabs.web.dto.ChatResponse;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/descriptions")
public class OpenAIController {
    private final OpenAIService service;

    public OpenAIController(OpenAIService service) {
        this.service = service;
    }

    @PostMapping
    public ChatResponse createDescription(@RequestBody DescriptionRequest description) {
       return service.getCharacteristicsFromDescription(description);
    }

    @PostMapping("/characteristics")
    public ChatResponse createCharacteristic(@RequestBody CarCharacteristic request) {
        return service.compareCharacteristics(request);
    }
}
