package com.projectsda.hello_ai.service;

import com.projectsda.hello_ai.exception.ChatServiceException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;

@Service
@RequiredArgsConstructor
public class OpenAiChatService implements ChatService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OpenAiChatService.class);

    private final ChatClient chatClient;

    @Override
    @Cacheable(value = "chat-responses", key = "#prompt")
    public String generateResponse(String prompt) {
        validatePrompt(prompt);

        LOGGER.info("Generating response for prompt: {}", prompt.substring(0, Math.min(prompt.length(), 50)));

        try {
            String response = chatClient.prompt()
                    .user(prompt)
                    .call()
                    .content();

            if (response == null || response.trim().isEmpty()) {
                LOGGER.warn("Received empty response from AI service");
                throw new ChatServiceException("AI service returned empty response", "EMPTY_RESPONSE");
            }

            LOGGER.info("Successfully generated response of {} characters", response.length());
            return response.trim();

        } catch (ResourceAccessException e) {
            LOGGER.error("Network error connection to AI service: {}", e.getMessage());
            throw new ChatServiceException("Network connection failed", "NETWORK_ERROR", e);

        } catch (RestClientException e) {
            LOGGER.error("OpenAI API error: {}",  e.getMessage());
            throw new ChatServiceException("AI service API error", "API_ERROR", e);

        } catch (Exception e) {
            LOGGER.error("Unexpected error in AI service: {}", e.getMessage(), e);
            throw new ChatServiceException("Unexpected AI service error", "UNKNOWN_ERROR", e);
        }
    }

    @Override
    @Cacheable(value = "chat-custom-responses", key = "#prompt + '_' + #temperature + '_' + #maxCompletionTokens")
    public String generatedResponseWithOptions(String prompt, double temperature, int maxCompletionTokens) {
        validatePrompt(prompt);
        validateOptions(temperature, maxCompletionTokens);

        LOGGER.info("Generating response with options - temp: {}, maxCompletionTokens: {}", temperature, maxCompletionTokens);

        try {
            String response = chatClient.prompt()
                    .user(prompt)
                    .options(OpenAiChatOptions.builder()
                            .temperature(temperature)
                            .maxCompletionTokens(maxCompletionTokens)
                            .build())
                    .call()
                    .content();

            if (response == null || response.trim().isEmpty()) {
                LOGGER.warn("Received empty response from AI service with custom options");
                throw new ChatServiceException("AI service returned empty response", "EMPTY_RESPONSE");
            }

            LOGGER.info("Successfully generated response with options: {} characters", response.length());
            return response.trim();

        } catch (ResourceAccessException e) {
            LOGGER.error("Network error with custom options: {}", e.getMessage());
            throw new ChatServiceException("Network connection failed", "NETWORK_ERROR", e);

        }  catch (RestClientException e) {
            LOGGER.error("OpenAI API error with custom options: {}",  e.getMessage());
            throw new  ChatServiceException("AI service API error", "API_ERROR", e);

        } catch (Exception e) {
            LOGGER.error("Unexpected error with custom options: {}", e.getMessage(), e);
            throw new ChatServiceException("Unexpected AI service error", "UNKNOWN_ERROR", e);
        }
    }

    private void validatePrompt(String prompt) {
        if (prompt == null || prompt.trim().isEmpty()) {
            throw new IllegalArgumentException("Prompt cannot be null or empty");
        }
        if (prompt.length() > 4000) {
            throw new IllegalArgumentException("Prompt too long (max 4000 characters)");
        }
    }

    private void validateOptions(double temperature, int maxCompletionTokens) {
        if (temperature < 1.0 || temperature > 1.0) {
            throw new IllegalArgumentException("For current mode gpt-5-nano, temperature must be 1.0");
        }
        if (maxCompletionTokens < 500 || maxCompletionTokens > 4000) {
            throw new IllegalArgumentException("Max completion tokens must be between 500 and less than 4000");
        }
    }
}
