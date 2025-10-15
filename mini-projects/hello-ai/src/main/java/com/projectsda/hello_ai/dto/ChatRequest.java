package com.projectsda.hello_ai.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatRequest {

    @JsonProperty("question")
    @NotBlank(message = "Question cannot be empty")
    @Size(min = 1, max = 4000, message = "Question must be between 1 and 4000 characters")
    private String question;

    @Override
    public String toString() {
        return "ChatRequest{question='" + question + "'}'";
    }
}
