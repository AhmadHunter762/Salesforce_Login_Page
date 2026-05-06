# Salesforce_Login_Page

# 🚀 Salesforce Validation Rule Manager

A full-stack application to fetch, view, and manage Salesforce Validation Rules using React, Spring Boot, and Salesforce OAuth 2.0.

---

## 🧩 Tech Stack

### Frontend

* React.js
* JavaScript
* HTML/CSS

### Backend

* Spring Boot (Java)
* REST APIs
* WebClient

### Integration

* Salesforce OAuth 2.0
* Salesforce Tooling API

---

## 🔐 Features

* Login with Salesforce (OAuth 2.0)
* Fetch Validation Rules from Salesforce
* Enable/Disable validation rules
* Deploy changes back to Salesforce
* Secure token-based communication

---

## 🏗️ Architecture

User → React Frontend → Spring Boot Backend → Salesforce APIs

---

## ⚙️ Setup Instructions

### 1️⃣ Clone Repository

```bash
git clone https://github.com/your-username/salesforce-validation-app.git
cd salesforce-validation-app
```

---

## 🖥️ Backend Setup (Spring Boot)

### Configure application.properties

```properties
server.port=8080

sf.client.id=YOUR_CONSUMER_KEY
sf.client.secret=YOUR_CONSUMER_SECRET
sf.redirect.uri=http://localhost:8080/auth/callback
sf.auth.url=https://login.salesforce.com
```

### Run Backend

```bash
mvn spring-boot:run
```

---

## 🌐 Frontend Setup (React)

```bash
cd frontend
npm install
npm start
```

Frontend will run on:
http://localhost:3000

---

## 🔑 Salesforce Setup

1. Go to Salesforce Setup
2. Create a Connected App
3. Enable OAuth Settings
4. Set Callback URL:
   http://localhost:8080/auth/callback
5. Add OAuth Scopes:

   * Full Access (full)
   * Perform requests on your behalf (refresh_token, offline_access)

---

## 🔄 Application Flow

1. User clicks "Login with Salesforce"
2. Redirect to Salesforce login page
3. User authorizes access
4. Backend receives authorization code
5. Backend exchanges code for access token
6. Frontend stores token
7. User fetches validation rules
8. Backend calls Salesforce Tooling API
9. Rules displayed in UI

---

## 📡 API Endpoints

### Auth

* GET /auth/login → Redirect to Salesforce login
* GET /auth/callback → Handle OAuth callback

### Validation Rules

* GET /rules → Fetch validation rules
* POST /deploy → Deploy changes

---

## 🚀 Deployment

### Frontend

* Vercel / Netlify

### Backend

* Render / Railway / Heroku

### Important:

Update callback URL in Salesforce Connected App after deployment.

---

## ⚠️ Common Issues

* invalid_client_id → Wrong Connected App
* redirect_uri_mismatch → Callback URL mismatch
* CORS error → Backend CORS config missing

---

## 📌 Future Enhancements

* Role-based access control
* UI improvements
* Bulk deployment optimization
* Error handling & logging

---

## 👨‍💻 Author

Your Name

---

## 📄 License

This project is for learning purposes.
