package com.projectsda.hello_ai.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatRequest {

    @JsonProperty("question")
    private String question;

    @Override
    public String toString() {
        return "ChatRequest{question='" + question + "'}'";
    }
}
