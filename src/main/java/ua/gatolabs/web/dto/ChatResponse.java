package ua.gatolabs.web.dto;

import java.util.List;

public class ChatResponse {
    private List<Choice> choices;

    public ChatResponse() {
    }

    public ChatResponse(List<Choice> choices) {
        this.choices = choices;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }
}
