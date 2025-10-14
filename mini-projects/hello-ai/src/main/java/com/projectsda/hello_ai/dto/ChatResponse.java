package com.projectsda.hello_ai.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatResponse {

    @JsonProperty("answer")
    private String answer;

    @JsonProperty("status")
    private String status;

    @JsonProperty("timestamp")
    @Builder.Default
    private LocalDateTime timestamp = LocalDateTime.now();

}
