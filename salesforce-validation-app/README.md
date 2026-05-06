# Salesforce Validation Rule Manager

## Tech Stack
- Backend: Spring Boot
- Frontend: React
- API: Salesforce Tooling API

## Prerequisites
- Java 17+
- Maven
- Node.js 18+

## Configure
Edit `backend/src/main/resources/application.properties`:
- sf.client.id
- sf.client.secret
- sf.redirect.uri (must match Connected App)

## Run

### Backend
cd backend
mvn spring-boot:run

### Frontend
cd frontend
npm install
npm start

App will be at http://localhost:3000
Backend at http://localhost:8080
