package com.projectsda.hello_ai.controller;

import com.projectsda.hello_ai.dto.ChatRequest;
import com.projectsda.hello_ai.dto.ChatRequestWithOptions;
import com.projectsda.hello_ai.dto.ChatResponse;
import com.projectsda.hello_ai.service.ChatService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/chat")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class ChatController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChatController.class);

    private final ChatService chatService;

    @PostMapping("/ask")
    public ResponseEntity<ChatResponse> askQuestion(
            @Valid @RequestBody ChatRequest request
    ) {
        LOGGER.info("Received chat request: {}", request.getQuestion());

        try {
            String response = chatService.generateResponse(request.getQuestion());
            ChatResponse chatResponse = ChatResponse.builder()
                    .answer(response)
                    .status("SUCCESS")
                    .build();

            return ResponseEntity.ok(chatResponse);

        } catch (Exception e) {
            LOGGER.error("Error processing chat request: {}", e.getMessage());
            ChatResponse errorResponse = ChatResponse.builder()
                    .answer("Sorry, I'm having trouble processing your request.")
                    .status("ERROR")
                    .build();

            return ResponseEntity.internalServerError().body(errorResponse);
        }
    }

    @PostMapping("/ask-custom")
    public ResponseEntity<ChatResponse> askWithOptions(
            @Valid @RequestBody ChatRequestWithOptions request
    ) {
        LOGGER.info("Received chat request with options: {}", request);

        try {
            String response = chatService.generatedResponseWithOptions(
                    request.getQuestion(),
                    request.getTemperature(),
                    request.getMaxCompletionTokens()
            );
            ChatResponse chatResponse = ChatResponse.builder()
                    .answer(response)
                    .status("SUCCESS")
                    .build();

            return ResponseEntity.ok(chatResponse);

        }  catch (Exception e) {
            LOGGER.error("Error processing custom chat request: {}", e.getMessage());
            ChatResponse errorResponse = ChatResponse.builder()
                    .answer("Sorry, I'm having trouble processing your request.")
                    .status("ERROR")
                    .build();
            return ResponseEntity.internalServerError().body(errorResponse);
        }
    }

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("Chat service is running!");
    }
}
