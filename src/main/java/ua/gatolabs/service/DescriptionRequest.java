package ua.gatolabs.service;

public class DescriptionRequest {
    private String description;


    public DescriptionRequest() {
    }

    public DescriptionRequest(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
