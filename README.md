# 🛒 E-Commerce Microservices Project

This is an **E-Commerce Application** built using **Spring Boot Microservices**.  
It includes core business services like **Order, Product, User, and Notification**, along with **Eureka Service Discovery, API Gateway, Config Server, Docker Compose, Prometheus, Grafana, and Centralized Logging**.

---

## 📂 Services

- **Config Server** → Centralized configuration management  
- **Eureka** → Service registry & discovery  
- **Gateway** → API Gateway & routing  
- **Order Service** → Handles customer orders  
- **Product Service** → Manages product catalog  
- **User Service** → Manages users  
- **Notification Service** → Sends notifications  

---

## ⚙️ Tech Stack

- Java, Spring Boot, Spring Cloud  
- PostgreSQL/MySQL (DB)  
- Maven  
- Docker, Docker Compose  
- Prometheus & Grafana (Monitoring)  
- Centralized Logging  

---

## 🚀 How to Run

### Clone the repository
```bash
git clone https://github.com/your-username/E-Commerce-application-.git
cd E-Commerce-application-

### Build all services
```bash
./mvnw clean package -DskipTests

cd deploy/docker
docker-compose up -d

