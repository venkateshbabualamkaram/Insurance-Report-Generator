# 📊 Insurance Report Generator — Java Full Stack Project

## 📌 Project Overview

The **Insurance Report Generator** is a Java Full Stack web application that enables users to manage insurance data efficiently. The system allows users to:

* Add and store insurance plan details
* Fetch and filter insurance records
* Generate reports in **Excel** and **PDF** formats
* Automatically send generated reports via **email**

This application demonstrates end-to-end full-stack development using **Spring Boot**, **React**, and **MySQL**, along with reporting and email automation capabilities.

---

## 🚀 Features

✅ Add new insurance records
✅ View and filter insurance plan details
✅ Generate Excel report
✅ Generate PDF report
✅ Download reports
✅ Email report automatically to users
✅ REST API integration between frontend and backend

---

## 🏗️ Tech Stack

### 🔹 Backend

* Java 17+
* Spring Boot
* Spring Data JPA
* Hibernate
* REST APIs
* Apache POI (Excel generation)
* iText / OpenPDF (PDF generation)
* Spring Mail (Email sending)

### 🔹 Frontend

* React JS
* Axios
* Bootstrap

### 🔹 Database

* MySQL

### 🔹 Tools & IDE

* VS Code / IntelliJ / Eclipse
* Postman
* Maven
* Git & GitHub

---

## 📂 Project Structure

```
insurance-report-generator
│
├── backend
│   ├── controller
│   ├── service
│   ├── repository
│   ├── entity
│   ├── dto
│   └── util (Excel, PDF, Email)
│
├── frontend
│   ├── components
│   ├── services
│   ├── pages
│   └── App.js
│
└── database
    └── schema.sql
```

---

## ⚙️ Installation & Setup

### 🔹 Backend Setup

1. Clone the repository

```bash
git clone <repo-url>
```

2. Navigate to backend

```bash
cd backend
```

3. Configure **application.properties**

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/insurance_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=your_email
spring.mail.password=app_password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

4. Run the application

```bash
mvn spring-boot:run
```

---

### 🔹 Frontend Setup

1. Navigate to frontend

```bash
cd frontend
```

2. Install dependencies

```bash
npm install
```

3. Start React app

```bash
npm start
```

---

## 📊 API Endpoints (Sample)

| Method | Endpoint            | Description           |
| ------ | ------------------- | --------------------- |
| POST   | `/insurance`        | Add insurance record  |
| GET    | `/insurance`        | Fetch all records     |
| POST   | `/insurance/search` | Filter records        |
| POST   | `/insurance/excel`  | Download Excel report |
| POST   | `/insurance/pdf`    | Download PDF report   |
| POST   | `/insurance/email`  | Send report via email |

---

## 📥 Report Generation

### 🔹 Excel

* Implemented using **Apache POI**
* Supports dynamic filtering
* Downloadable from UI

### 🔹 PDF

* Implemented using **iText/OpenPDF**
* Structured tabular format
* Supports download

---

## 📧 Email Automation

* Uses **Spring Mail**
* Automatically attaches generated reports
* Sends to configured recipient

---

## 🎯 Learning Outcomes

* Full Stack CRUD implementation
* REST API design
* File generation (Excel & PDF)
* Email integration
* React–Spring Boot communication
* Database integration

---

## 🔮 Future Enhancements

* Authentication & authorization
* Pagination
* Cloud storage for reports
* Scheduler-based automatic report sending
* Docker deployment

---
