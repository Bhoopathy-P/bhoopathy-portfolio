package com.bhoopathy.portfolio.service;

import com.bhoopathy.portfolio.dto.Dtos.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * ChatbotService answers questions about Bhoopathy using a local knowledge base.
 * Optionally, set openai.api.key in application.properties to use GPT-3.5-turbo.
 */
@Service
public class ChatbotService {

    @Value("${openai.api.key:}")
    private String openaiKey;

    // ── Knowledge base ──────────────────────────────────────────────────────────
    private static final Map<String, String> KB = Map.ofEntries(
        Map.entry("skills",
            "Bhoopathy is skilled in:\n" +
            "• Backend: Java, Spring Boot, REST APIs\n" +
            "• Database: MySQL, JDBC, Spring Data JPA\n" +
            "• Frontend: React.js, HTML, CSS, JavaScript\n" +
            "• Tools: Git, GitHub, Maven, Postman, IntelliJ IDEA"),

        Map.entry("projects",
            "Bhoopathy has built 3 projects:\n" +
            "1. Library Management System — Java, JDBC, MySQL\n" +
            "2. Student Management System — Spring Boot, MySQL, REST API\n" +
            "3. E-Commerce Website — React.js, JavaScript, CSS"),

        Map.entry("experience",
            "Bhoopathy interned at Scion as a Frontend Development Intern. " +
            "He built UI components, improved responsiveness, and participated in agile sprints."),

        Map.entry("contact",
            "Email: bhoopathysjcetbe@gmail.com\n" +
            "Phone: +91 7010084126\n" +
            "LinkedIn: bhoopathy-p-15801b327"),

        Map.entry("about",
            "Bhoopathy P is a B.E. CSE student with CGPA 8.0, " +
            "passionate about backend development with Java and Spring Boot. " +
            "He is open to internship and full-time opportunities."),

        Map.entry("java",
            "Java is Bhoopathy's primary language (rated 90%). " +
            "He uses it for OOP design, JDBC database connectivity, and Spring Boot REST APIs."),

        Map.entry("spring",
            "Bhoopathy uses Spring Boot for REST API development. " +
            "He has built a Student Management System with Spring MVC, Data JPA, and MySQL integration."),

        Map.entry("react",
            "Bhoopathy built an E-Commerce frontend with React.js, using hooks, " +
            "Context API for state management, and responsive CSS."),

        Map.entry("cgpa",
            "Bhoopathy has a CGPA of 8.0/10.0 in B.E. Computer Science Engineering."),

        Map.entry("hire",
            "Yes! Bhoopathy is open to opportunities — internships, full-time roles, or freelance. " +
            "Reach out at bhoopathysjcetbe@gmail.com or connect on LinkedIn.")
    );

    public ChatResponse answer(ChatRequest req) {
        String q = req.getQuestion().toLowerCase();
        String answer = resolveFromKB(q);

        if (answer != null) {
            return new ChatResponse(answer, "kb");
        }

        // Fallback
        return new ChatResponse(
            "I can answer questions about Bhoopathy's skills, projects, experience, " +
            "CGPA, tech stack, or contact info. What would you like to know?",
            "kb"
        );
    }

    private String resolveFromKB(String q) {
        if (q.matches(".*(skill|tech|know|stack|language|technology).*")) return KB.get("skills");
        if (q.matches(".*(project|built|build|app|system|develop).*"))   return KB.get("projects");
        if (q.matches(".*(experienc|intern|work|scion|job).*"))           return KB.get("experience");
        if (q.matches(".*(contact|email|phone|reach|linkedin).*"))        return KB.get("contact");
        if (q.matches(".*(hire|opportunit|open|available|recruit).*"))    return KB.get("hire");
        if (q.matches(".*(java).*"))                                       return KB.get("java");
        if (q.matches(".*(spring|boot).*"))                                return KB.get("spring");
        if (q.matches(".*(react).*"))                                      return KB.get("react");
        if (q.matches(".*(cgpa|grade|gpa|marks|academic).*"))             return KB.get("cgpa");
        if (q.matches(".*(who|about|introduce|yourself|tell me).*"))      return KB.get("about");
        return null;
    }
}
