package com.bhoopathy.portfolio.dto;

import lombok.*;

public class Dtos {

    @Getter @Setter @NoArgsConstructor @AllArgsConstructor
    public static class ContactRequest {
        private String name;
        private String email;
        private String subject;
        private String message;
    }

    @Getter @Setter @NoArgsConstructor @AllArgsConstructor
    public static class ApiResponse {
        private boolean success;
        private String message;
    }

    @Getter @Setter @NoArgsConstructor @AllArgsConstructor
    public static class ChatRequest {
        private String question;
    }

    @Getter @Setter @NoArgsConstructor @AllArgsConstructor
    public static class ChatResponse {
        private String answer;
        private String source; // "kb" or "ai"
    }
}
