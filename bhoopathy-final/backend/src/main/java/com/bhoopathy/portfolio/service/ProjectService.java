package com.bhoopathy.portfolio.service;

import com.bhoopathy.portfolio.model.Project;
import com.bhoopathy.portfolio.repository.ProjectRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    /** Seed default projects if DB is empty */
    @PostConstruct
    public void seedProjects() {
        if (projectRepository.count() == 0) {
            projectRepository.saveAll(List.of(
                Project.builder()
                    .title("Library Management System")
                    .description("A full-featured application for managing library resources — books, members, issue/return workflows, and fine calculation using core Java and JDBC.")
                    .techStack("Java,JDBC,MySQL,OOP")
                    .githubUrl("https://github.com/bhoopathy-p/library-management")
                    .icon("📚")
                    .build(),
                Project.builder()
                    .title("Student Management System")
                    .description("A RESTful web service with Spring Boot handling student CRUD operations, course enrollment, and grade tracking backed by MySQL via Spring Data JPA.")
                    .techStack("Spring Boot,REST API,MySQL,JPA")
                    .githubUrl("https://github.com/bhoopathy-p/student-management")
                    .icon("🎓")
                    .build(),
                Project.builder()
                    .title("E-Commerce Website")
                    .description("A responsive React.js e-commerce frontend with product listing, cart state via Context API, search/filter, and smooth checkout UI.")
                    .techStack("React,JavaScript,CSS3,Context API")
                    .githubUrl("https://github.com/bhoopathy-p/ecommerce-react")
                    .demoUrl("https://bhoopathy-ecommerce.vercel.app")
                    .icon("🛒")
                    .build()
            ));
        }
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project getProjectById(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found: " + id));
    }
}
