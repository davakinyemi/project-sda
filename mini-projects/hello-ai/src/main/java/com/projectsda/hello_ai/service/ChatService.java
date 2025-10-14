package com.projectsda.hello_ai.service;

public interface ChatService {
    String generateResponse(String prompt);
    String generatedResponseWithOptions(String prompt, double temperature, int maxTokens);
}
