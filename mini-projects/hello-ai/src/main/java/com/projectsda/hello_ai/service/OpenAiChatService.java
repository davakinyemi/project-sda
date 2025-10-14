package com.projectsda.hello_ai.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OpenAiChatService implements ChatService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OpenAiChatService.class);

    private final ChatClient chatClient;

    @Override
    public String generateResponse(String prompt) {
        LOGGER.info("Generating response for prompt: {}", prompt);

        try {
            String response = chatClient.prompt()
                    .user(prompt)
                    .call()
                    .content();

            LOGGER.info("Successfully generated response");
            return response;

        } catch (Exception e) {
            LOGGER.error("Error generating response: {}", e.getMessage());
            throw new RuntimeException("Failed to generate AI response", e);
        }
    }

    @Override
    public String generatedResponseWithOptions(String prompt, double temperature, int maxTokens) {
        LOGGER.info("Generating response with custom options - temp: {}, maxTokens: {}", temperature, maxTokens);

        try {
            String response = chatClient.prompt()
                    .user(prompt)
                    .options(OpenAiChatOptions.builder()
                            .temperature(temperature)
                            .maxTokens(maxTokens)
                            .build())
                    .call()
                    .content();

            LOGGER.info("Successfully generated response with custom options");
            return response;

        } catch (Exception e) {
            LOGGER.error("Error generating response with options: {}", e.getMessage());
            throw new RuntimeException("Failed to generate AI response", e);
        }
    }
}
