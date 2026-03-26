# Bhoopathy P — Java Full Stack Developer Portfolio

A professional portfolio website for **Bhoopathy P**, featuring:
- 🎨 Dark-themed React frontend with animations & AI chatbot
- ☕ Spring Boot REST API backend
- 🗄 MySQL database

---

## 📁 Folder Structure

```
bhoopathy-portfolio/
│
├── index.html                        ← Standalone frontend (open directly in browser)
│
└── backend/                          ← Spring Boot project
    ├── pom.xml
    ├── schema.sql                    ← MySQL schema
    └── src/main/
        ├── java/com/bhoopathy/portfolio/
        │   ├── PortfolioApplication.java
        │   ├── controller/
        │   │   └── PortfolioController.java
        │   ├── dto/
        │   │   └── Dtos.java
        │   ├── model/
        │   │   ├── Contact.java
        │   │   └── Project.java
        │   ├── repository/
        │   │   ├── ContactRepository.java
        │   │   └── ProjectRepository.java
        │   └── service/
        │       ├── ChatbotService.java
        │       ├── ContactService.java
        │       └── ProjectService.java
        └── resources/
            └── application.properties
```

---

## 🚀 Quick Start — Frontend Only

Just open `index.html` in any browser. No server needed!

```bash
# macOS / Linux
open index.html

# Windows
start index.html
```

The portfolio is fully self-contained with:
- All 6 sections (Hero, About, Skills, Projects, Experience, Contact)
- AI chatbot with knowledge base
- Smooth scroll & animations
- Responsive mobile design

---

## ☕ Backend Setup (Spring Boot)

### Prerequisites
- Java 17+
- Maven 3.8+
- MySQL 8.0+

### 1 — Create the Database

```sql
-- In MySQL Workbench or terminal:
CREATE DATABASE portfolio_db;
```

Or run the provided schema file:
```bash
mysql -u root -p < backend/schema.sql
```

### 2 — Configure Database

Edit `backend/src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/portfolio_db?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
```

### 3 — Run the Backend

```bash
cd backend
mvn spring-boot:run
```

Backend starts at: **http://localhost:8080**

---

## 🔌 REST API Endpoints

| Method | Endpoint        | Description                          |
|--------|-----------------|--------------------------------------|
| GET    | /api/health     | Health check                         |
| GET    | /api/projects   | Fetch all projects                   |
| GET    | /api/projects/{id} | Fetch single project              |
| POST   | /api/contact    | Submit contact form                  |
| POST   | /api/chat       | Ask the AI chatbot                   |

### Example — Contact Form
```bash
curl -X POST http://localhost:8080/api/contact \
  -H "Content-Type: application/json" \
  -d '{"name":"John","email":"john@example.com","message":"Hello!"}'
```

### Example — Chatbot
```bash
curl -X POST http://localhost:8080/api/chat \
  -H "Content-Type: application/json" \
  -d '{"question":"What skills does Bhoopathy have?"}'
```

### Example — Projects
```bash
curl http://localhost:8080/api/projects
```

---

## 🤖 Chatbot — OpenAI Integration (Optional)

The chatbot ships with a built-in knowledge base. To upgrade to real GPT:

1. Get an OpenAI API key from https://platform.openai.com
2. Add to `application.properties`:
   ```properties
   openai.api.key=sk-your-key-here
   ```
3. In `ChatbotService.java`, replace `resolveFromKB()` with an HTTP call:
   ```java
   // POST https://api.openai.com/v1/chat/completions
   // with the user question as a prompt and the KB as system context
   ```

---

## 🌐 Connect Frontend → Backend

In `index.html`, update the form submission function to call the backend:

```javascript
async function submitForm(e) {
  e.preventDefault();
  const data = { name: ..., email: ..., message: ... };
  const res = await fetch('http://localhost:8080/api/contact', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(data)
  });
  const result = await res.json();
  // show result.message
}
```

Similarly, connect the chatbot's `sendChat()` to `/api/chat`.

---

## 📦 Build for Production

```bash
# Backend JAR
cd backend
mvn clean package
java -jar target/portfolio-1.0.0.jar

# Frontend — deploy index.html to any static host:
# Vercel, Netlify, GitHub Pages, or serve via Spring Boot's /static folder
```

---

## 📬 Contact

- **Email:** bhoopathysjcetbe@gmail.com
- **Phone:** +91 7010084126
- **LinkedIn:** [bhoopathy-p-15801b327](https://linkedin.com/in/bhoopathy-p-15801b327)
- **GitHub:** [github.com/bhoopathy-p](https://github.com/bhoopathy-p)

---

*Built with ☕ Java + Spring Boot + React.js*
