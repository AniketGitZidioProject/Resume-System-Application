# Resume System Backend (Spring Boot + MySQL + Spring Security)
This is the backend service for the Resume System Application.
It is built using Spring Boot, Spring Data JPA, Spring Security (JWT), and MySQL.
The backend exposes a REST API for managing Users, Projects, Courses, Skills, Achievements and for assembling / deleting a full resume.

## ⚡ Features
+ Authentication & Authorization → Role-based or basic auth support using Spring Security + JWT.
+ CRUD APIs → for Users, Projects, Courses, Skills, Achievements.
+ Resume Aggregation → single endpoint to fetch a user's full resume (projects, courses, skills, achievements).
+ Bulk deletion → delete all resume parts for a user (full resume delete).
+ JSON REST API → well-structured endpoints for frontend or clients (Postman friendly).
+ File upload support (optional) → for certificates / resumes (can be added to use local storage or cloud providers).
+ Validation & Error handling → request validation + centralized exception responses.
--
## 🛠️ Tech Stack
+ Language → Java 17 (upgradable to 21)
+ **Framework →**
    - Spring Boot Starter Web (REST APIs)
    - Spring Boot Starter Data JPA (Hibernate ORM + MySQL)
    - Spring Boot Starter Validation (Request validation)
    - Spring Boot Starter Security + JWT (Authentication)
    - Spring Boot DevTools (Hot reload)
    - Spring Boot Starter WebFlux (Reactive APIs)
    - Spring Boot Starter Test (Testing)
+ **Database** → MySQL + JPA
+ **Authentication** → JWT (io.jsonwebtoken / jjwt)
+ **File & Media Handling →**
  - Apache Commons IO, Cloud SDKs (if integrated)
+ **Networking →** Reactor Netty, Jersey REST client
+ **Build Tool →** Maven (Spring Boot Maven Plugin)
+ **Testing Tool →** Postman (API Testing)


## ⚙️ Setup & Installation
## 1. Clone the Repository
git clone https://github.com/AniketGitZidioProject/Resume-System-Application.git
cd Resume-System-Application

## 2. Configure Database
+ Create a database in MySQL:
CREATE DATABASE resume_system_db;

+ Update your src/main/resources/application.properties (or application.yml):

spring.datasource.url=jdbc:mysql://localhost:3306/resume_system_db
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# (Optional) JWT and security properties
jwt.secret=your_jwt_secret
jwt.expiration=86400000


## 3. Run the Application
+ Use Maven Wrapper

./mvnw spring-boot:run

+ Or using Maven directly:

mvn spring-boot:run

**The server will start at:** 👉 http://localhost:8080

## ⚙️Create Project via Spring Initializr (if you want to regenerate)

+ **🚀 Create Project with Spring Initializr**
You can generate this project using Spring Initializr or directly via your IDE (IntelliJ IDEA / Eclipse / VS Code).

## 1. Go to Spring Initializr
👉 https://start.spring.io/

## 2. Project Settings
+ **Project:** Maven
+ **Language:** Java
+ **Spring Boot Version:** 2.7.15 (or latest LTS compatible with Java 17/21)
+ **Project Metadata:**
    - **Group:** com.example
    - **Artifact:** resume_system_application
    - **Name:** resume_system_application
    - **Package:** com.example.job_portal
+ **Java Version:** 17 (can also upgrade to 21 later)

## 2. Select Dependencies
+ **Spring Boot Starts:**
  
    - Spring Web
    - Spring Data JPA
    - Spring Security
    - Validation
    - Spring Boot DevTools
    - Spring Boot Test
    - Validation
    - MySQL Driver
   

+ **Database:** MySQL Driver  
+ **other:**
   - Spring Mail
   - Webflux (for reactive APIs) ⚡ After generation, you’ll get a ZIP → unzip it and open in your IDE.

## 4. Import as Maven Project
+ Open your IDE(IntelliJ/Eclipse).
+ Select Import Project → Maven.
+ Point to the unzipped folder.
+ Maven will automatically download all dependencies from pom.xml.

## 5. Run the Application
+ **Use Maven Wrapper:**

./mvnw spring-boot:run

+ **Or using Maven directly:**

mvn spring-boot:run


# 📬 API Endpoints (Test with Postman)
All responses are JSON unless otherwise noted.
Base path: 👉 http://localhost:8080/api

## 🔑 Authentication
+ **Register →** POST /api/auth/register
+ **Login →** POST /api/auth/login

## 👤 Users
+ **Create user →**  POST /api/users/create
+ **Get user by id** →GET /api/users/{id}
+ **Update user →** PUT /api/users/{id}
+ **Delete user →** DELETE /api/users/{id}

```json
{
  "name": "Aniket Dharane",
  "email": "aniketdharane3919@gmail.com",
  "password": "newPassword123"
}
```
  

## 💻 Projects
+ **Create project** → POST /api/projects/create/{userId}
+ **Get projects by user →** GET /api/projects/user/{userId}
+ **Update project →** PUT /api/projects/{id}
+ **Delete project →** DELETE /api/projects/{id}
+ **Delete all projects by user →** DELETE /api/projects/user/{userId}

  ```json
{
  "title": "AI Research Project",
  "description": "Developed an AI summarization model",
  "startDate": "2025-09-01",
  "endDate": "2025-10-15",
  "link": "https://github.com/username/ai-project"
}
```

##📚 Courses
+ **Create course →** POST /api/courses/create/{userId}
+ **Get courses by user →** GET /api/courses/user/{userId}
+ **Update course →** PUT /api/courses/{id}
+ **Delete course →** DELETE /api/courses/{id}
+ **Delete all courses by user →** DELETE /api/courses/user/{userId}

 ```json
{
  "title": "Full Stack Java Development",
  "institution": "Coursera",
  "completionDate": "2025-10-15",
  "certificateUrl": "https://coursera.org/certificate/abc123"
}


```

## 🏆 Achievements
+ **Create achievement →** POST /api/achievement/create/{userId}
+ **Get achievements by user →** GET /api/achievement/user/{userId}
+ **Update achievemen →** PUT /api/achievement/{id}
+ **Delete achievement →** DELETE /api/achievement/{id}
+ **Delete all achievements by user →** DELETE /api/achievement/user/{userId}

**Create achievement body (camelCase)**

 ```json
{
  "title": "Best Creator Award",
  "description": "Awarded for creator project contributions",
  "date": "2025-10-20",
  "verificationUrl": "https://example.com/verify/award"
}



```


## 💡 Skills
+ **Create skill →** POST /api/skills/create/{userId}
+ **Get skills by user →** GET /api/skills/user/{userId}
+ **Update skill →** PUT /api/skills/{id}
+ **Delete skill →** DELETE /api/skills/{id}
+ **Delete all skills by user →** DELETE /api/skills/user/{userId}

  **Create skill body (camelCase)**

   ```json
{
  "name": "Java",
  "level": "Expert",
  "endorsements": 10
}




```


## 📦 Full Resume Endpoints
+ **Get full resume →** GET /api/resume/{userId}
 - **Returns a JSON object with keys: user, projects, courses, achievements, skills** 
+ **Delete full resume →** DELETE /api/resume/{userId}
  - **Deletes all projects, courses, achievements, skills for the user and deletes the user.** 

## 🧪 Testing with Postman

1. Create a user (POST /api/users/create) and note the returned id.
2. Create resources for that user using POST /api/{resource}/create/{userId}.
3. Retrieve the assembled resume with GET /api/resume/{userId}.
4. Use PUT to update and DELETE endpoints to remove data.

```json
{
  "username": "testuser",
  "password": "password123",
  "email": "testuser@example.com"
}
```

## 📂 Project Structure
```text
src/main/java/com/example/resume_system
├── Controller     # REST controllers (API layer)
├── Entity         # JPA entities (User, Project, Course, Skill, Achievement)
├── Repository     # Spring Data JPA repositories
├── Service        # Business logic services
├── Security       # JWT & Spring Security configuration
├── Exception      # Custom exceptions and handlers
└── DTO            # (optional) Data Transfer Objects

## ✅ Tips & Notes

+ Use camelCase in JSON request bodies to match Java field names (unless @JsonProperty is used).
+ If you get 404 for an endpoint, confirm controller @RequestMapping base path and method mapping.
+ For 400 related to serialization (Hibernate proxies), add @JsonIgnoreProperties({"hibernateLazyInitializer","handler"}) to entities or return DTOs.
+ Use DTOs for production-ready APIs to avoid exposing sensitive fields (e.g., password hashes).
+ Add a .gitignore to exclude target/, .idea/, *.iml, and sensitive config files.





























