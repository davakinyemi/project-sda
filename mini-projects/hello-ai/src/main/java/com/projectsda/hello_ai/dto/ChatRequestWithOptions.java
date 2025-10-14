package com.projectsda.hello_ai.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ChatRequestWithOptions extends ChatRequest {

    @JsonProperty("temperature")
    private double temperature = 1.0;

    @JsonProperty("max_completion_tokens")
    private int maxCompletionTokens = 150;

    /* public ChatRequestWithOptions(String question, double temperature, int maxCompletionTokens) {
        super(question);
        this.temperature = temperature;
        this.maxCompletionTokens = maxCompletionTokens;
    } */

}
