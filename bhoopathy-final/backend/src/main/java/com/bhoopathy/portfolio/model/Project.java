package com.bhoopathy.portfolio.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "projects")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String techStack;   // comma-separated e.g. "Java,JDBC,MySQL"

    private String githubUrl;

    private String demoUrl;

    private String icon;        // emoji or icon name
}
