package com.projectsda.hello_ai.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ChatRequestWithOptions extends ChatRequest {

    @JsonProperty("temperature")
    @DecimalMin(value = "1.0", message = "Temperature must be at least 1.0")
    @DecimalMax(value = "1.0", message = "Temperature must not exceed 1.0")
    private double temperature = 1.0;

    @JsonProperty("max_completion_tokens")
    @Min(value = 100, message = "Max completion tokens must be at least 100")
    @Max(value = 4000, message = "Max completion tokens cannot exceed 4000")
    private int maxCompletionTokens = 150;

}
