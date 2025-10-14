package com.projectsda.hello_ai;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConfigInspector implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigInspector.class);

    private final ChatClient.Builder chatClientBuilder;
    private final OpenAiChatModel chatModel;

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("ChatClient.Builder bean available: {}", chatClientBuilder != null);
        LOGGER.info("OpenAiChatModel bean available: {}", chatModel != null);
        LOGGER.info("Spring AI auto-configuration is working!");
    }
}
