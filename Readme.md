# Quizpoint-upgrade
QuizPoint

QuizPoint is a web application developed for conducting quizzes. 
It is developed using Spring Boot as the backend, Angular as the frontend, and MySQL as the database.


Features

User registration and authentication
Quiz creation and management
Question creation and management
User progress tracking and score calculation
Admin section for managing quizzes, questions, and users


Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.


Prerequisites

Java Development Kit (JDK) 1.8 or later
Node.js
Angular CLI
Git
MySQL Server


Installing
Clone the repository: 
git clone https://github.com/kunalthakurani19/QuizPoint-upgrade.git


Navigate to the project directory:
cd QuizPoint

Create a database in MySQL with the name "exam"

Modify the database connection settings in the application.properties file in the src/main/resources directory to match your MySQL configuration:

spring.datasource.url=jdbc:mysql://localhost:3306/quizpoint // i use 3307
spring.datasource.username=root
spring.datasource.password=your_password


Install the backend dependencies:
./mvnw install

Install the frontend dependencies:
cd src/main/frontend
npm install


Running the Application
To run the application, execute the following command in the project directory:
./mvnw spring-boot:run
The backend will start on port 8080 by default.

To run the frontend, execute the following command in a separate terminal window:
cd src/main/frontend
ng serve

The frontend will start on port 4200 by default.

Built With
Spring Boot - Java web framework
Angular - TypeScript-based web application framework
MySQL - Relational database management system

Authors
Kunal Thakurani - GitHub Profile

License
This project is licensed under the MIT License - see the LICENSE.md file for details.

