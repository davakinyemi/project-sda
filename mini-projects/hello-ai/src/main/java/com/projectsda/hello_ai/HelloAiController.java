package com.projectsda.hello_ai;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloAiController {

    private static final Logger logger = LoggerFactory.getLogger(HelloAiController.class);
    private final ChatClient chatClient;

    public HelloAiController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @GetMapping("/hello-ai")
    public ResponseEntity<String> helloAi(
            @RequestParam(defaultValue = "Hello") String message
    ) {
        try {
            logger.info("Processing AI request with message: {}", message);

            String response = chatClient.prompt()
                    .user(message)
                    .call()
                    .content();

            logger.info("AI response received successfully");
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            logger.error("Error processing AI request: {}", e.getMessage());
            return ResponseEntity.internalServerError()
                    .body("Sorry, I'm having trouble processing your request right now.");
        }
    }

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("AI service is running");
    }
}
