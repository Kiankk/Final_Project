# Final Project - Course Management System (Java Assignment)

## Author: Kian Dehghani

## 📌 Overview
This project is a Java-based application designed to manage the academic relationships between **Students**, **Courses**, **Departments**, and **Assignments**. It simulates a simplified school system where students can register for courses, assignments can be graded (randomly generated or manually set), and weighted averages are calculated automatically.

The project demonstrates object-oriented programming principles, strict data validation, automatic ID generation, and unit testing using **JUnit 5**.

---

## 🚀 Features

### 1. Data Validation & Formatting
* **Address Validation**: strict validation of Canadian postal codes (format `A1A1A1`). Invalid postal codes result in nullified address fields.
* **Title Case Conversion**: Utility class ensures all names (Student, Department, Course) are automatically converted to Title Case (e.g., "computer science" → "Computer Science").
* **Department Names**: Validates that department names contain only letters or spaces.

### 2. Automatic ID Generation
* **Student ID**: Auto-increments in the format `S000001`.
* **Department ID**: Auto-increments in the format `D01`, `D02`.
* **Course ID**: Complex formatting combining Department ID and auto-increment, e.g., `C-D01-05`.
* **Assignment ID**: Auto-increments in the format `A01`.

### 3. Academic Logic
* **Registration System**: Students can register for courses. This links the student to the course and initializes placeholder scores for all existing assignments.
* **Score Simulation**: Ability to generate random scores for assignments based on specific probability distributions (e.g., higher probability for scores between 80-90).
* **Weighted Averages**: Calculates final course grades based on assignment weights (must sum to 100%).

### 4. Robust Testing
* Comprehensive **JUnit 5** test suite covering normal, null, and edge cases for all classes.

---

## 🛠️ Technologies Used
* **Java**: Core logic and object-oriented design.
* **JUnit 5**: Unit testing framework.
* **Project Lombok**: Used to reduce boilerplate code (Getters, Setters, ToString) while manually overriding specific methods (`equals`, `constructors`) where complex logic was required.

---

## 📂 Project Structure

```text
src/
├── main/
│   └── java/
│       ├── Address.java       
│       ├── Assignment.java    
│       ├── Course.java        
│       ├── Department.java    
│       ├── Student.java       
│       └── util/
│           └── Util.java      
└── test/
    └── java/
        └── org/example/
            ├── AddressTest.java
            ├── AssignmentTest.java
            ├── CourseTest.java
            ├── DepartmentTest.java
            ├── StudentTest.java
            └── UtilTest.java
