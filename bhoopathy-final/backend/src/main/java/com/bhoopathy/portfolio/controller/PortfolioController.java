package com.bhoopathy.portfolio.controller;

import com.bhoopathy.portfolio.dto.Dtos.*;
import com.bhoopathy.portfolio.model.Project;
import com.bhoopathy.portfolio.service.ChatbotService;
import com.bhoopathy.portfolio.service.ContactService;
import com.bhoopathy.portfolio.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class PortfolioController {

    private final ContactService contactService;
    private final ProjectService projectService;
    private final ChatbotService chatbotService;

    // ── Health check ──────────────────────────────────────────────────────────
    @GetMapping("/health")
    public ResponseEntity<ApiResponse> health() {
        return ResponseEntity.ok(new ApiResponse(true, "Portfolio API is running ✓"));
    }

    // ── Contact ───────────────────────────────────────────────────────────────
    @PostMapping("/contact")
    public ResponseEntity<ApiResponse> submitContact(@RequestBody ContactRequest req) {
        return ResponseEntity.ok(contactService.submitContact(req));
    }

    // ── Projects ──────────────────────────────────────────────────────────────
    @GetMapping("/projects")
    public ResponseEntity<List<Project>> getProjects() {
        return ResponseEntity.ok(projectService.getAllProjects());
    }

    @GetMapping("/projects/{id}")
    public ResponseEntity<Project> getProject(@PathVariable Long id) {
        return ResponseEntity.ok(projectService.getProjectById(id));
    }

    // ── Chatbot ───────────────────────────────────────────────────────────────
    @PostMapping("/chat")
    public ResponseEntity<ChatResponse> chat(@RequestBody ChatRequest req) {
        return ResponseEntity.ok(chatbotService.answer(req));
    }
}
