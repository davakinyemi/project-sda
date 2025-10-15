package com.projectsda.hello_ai.exception;

import com.projectsda.hello_ai.dto.ChatResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.RestClientException;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ChatServiceException.class)
    public ResponseEntity<ChatResponse> handleChatServiceException(ChatServiceException e) {
        LOGGER.error("Chat Service error: {} - {}", e.getErrorCode(), e.getMessage());

        ChatResponse response = ChatResponse.builder()
                .answer("Chat service is temporarily unavailable. Please try again later.")
                .status("chat_service_error")
                .build();

        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(response);
    }

    @ExceptionHandler(RestClientException.class)
    public ResponseEntity<ChatResponse> handleRestClientException(RestClientException e) {
        LOGGER.error("OpenAI API error: {}", e.getMessage());

        ChatResponse response = ChatResponse.builder()
                .answer("Unable to connect to AI service. Please check your connection.")
                .status("connection_error")
                .build();

        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ChatResponse> handleValidationException(MethodArgumentNotValidException e) {
        LOGGER.error("Validation error: {}", e.getMessage());

        ChatResponse response = ChatResponse.builder()
                .answer("Invalid request format. Please check your input")
                .status("validation_error")
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ChatResponse> handleGenericException(Exception e) {
        LOGGER.error("Unexpected error: {}", e.getMessage(), e);

        ChatResponse response = ChatResponse.builder()
                .answer("An unexpected error occurred. Please try again.")
                .status("internal_error")
                .build();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
