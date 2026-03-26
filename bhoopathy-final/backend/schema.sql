-- ─────────────────────────────────────────────────────────────────────────────
-- Bhoopathy P — Portfolio Database Schema
-- Run this once before starting the Spring Boot application (or let JPA auto-create)
-- ─────────────────────────────────────────────────────────────────────────────

CREATE DATABASE IF NOT EXISTS portfolio_db;
USE portfolio_db;

-- Contacts table: stores messages from the contact form
CREATE TABLE IF NOT EXISTS contacts (
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    name       VARCHAR(120)  NOT NULL,
    email      VARCHAR(180)  NOT NULL,
    subject    VARCHAR(250),
    message    TEXT          NOT NULL,
    created_at DATETIME      DEFAULT CURRENT_TIMESTAMP
);

-- Projects table: portfolio projects
CREATE TABLE IF NOT EXISTS projects (
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    title       VARCHAR(200) NOT NULL,
    description TEXT,
    tech_stack  VARCHAR(500),  -- comma-separated e.g. "Java,JDBC,MySQL"
    github_url  VARCHAR(500),
    demo_url    VARCHAR(500),
    icon        VARCHAR(20)
);

-- Seed default projects (Spring Boot also seeds via @PostConstruct)
INSERT IGNORE INTO projects (id, title, description, tech_stack, github_url, icon) VALUES
(1, 'Library Management System',
 'Full-featured app for managing library resources using Java, JDBC, and MySQL.',
 'Java,JDBC,MySQL,OOP',
 'https://github.com/bhoopathy-p/library-management', '📚'),

(2, 'Student Management System',
 'RESTful Spring Boot service for student CRUD, enrollment, and grade tracking.',
 'Spring Boot,REST API,MySQL,JPA',
 'https://github.com/bhoopathy-p/student-management', '🎓'),

(3, 'E-Commerce Website',
 'Responsive React.js e-commerce frontend with cart state and product listing.',
 'React,JavaScript,CSS3,Context API',
 'https://github.com/bhoopathy-p/ecommerce-react', '🛒');
