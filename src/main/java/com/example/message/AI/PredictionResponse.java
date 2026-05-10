package com.example.message.AI;

public class PredictionResponse {
    private String label;
    private Double confidence;

    public PredictionResponse(String label, Double confidence) {
        this.label = label;
        this.confidence = confidence;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Double getConfidence() {
        return confidence;
    }

    public void setConfidence(Double confidence) {
        this.confidence = confidence;
    }
}
