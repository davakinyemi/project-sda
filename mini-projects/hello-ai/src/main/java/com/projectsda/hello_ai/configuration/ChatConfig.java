package com.projectsda.hello_ai.configuration;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatConfig {

    private final ChatClient.Builder chatClientBuilder;

    public ChatConfig(ChatClient.Builder chatClientBuilder) {
        this.chatClientBuilder = chatClientBuilder;
    }

    @Bean
    public ChatClient chatClient() {
        return chatClientBuilder
                .defaultOptions(OpenAiChatOptions
                        .builder()
                        .model("gpt-5-nano")
                        .temperature(1.0)
                        .build())
                .build();
    }
}
