# Challenge: Java and JavaScript Programming Procedures

![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-3.9-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![JUnit5](https://img.shields.io/badge/JUnit-5-25A162?style=for-the-badge&logo=junit5&logoColor=white)
[![Coverage](https://img.shields.io/badge/Coverage-93%25-brightgreen?style=for-the-badge)](./target/site/jacoco/index.html)

This repository contains the solution for the **"Java and JavaScript. Programming Procedures"** challenge. This project focuses on implementing robust unit testing suites for both a Java module (Sprint 1) and a JavaScript module (Sprint 2), emphasizing code quality, high test coverage, and comprehensive documentation.

---

## 🎯 Sprint 1: Java Unit Testing with JUnit

This first sprint covers the setup of a Java project and the implementation of a comprehensive test suite for a reservations module, demonstrating the critical role of testing in modern software development.

### ✨ Key Features & Technologies

*   **Project Setup:** Standard Maven project structure configured for Java 17.
*   **Unit Testing:** A full suite of tests developed with **JUnit 5 (Jupiter)**.
*   **Code Coverage:** Integrated **JaCoCo** to measure test coverage, ensuring a quality threshold of over 90%.
*   **Architecture:** The module is designed following Object-Oriented Programming (OOP) principles, using interfaces for abstraction and classes for concrete implementation.

---

### 🚀 Getting Started

Follow these instructions to set up, run the tests, and view the coverage report on your local machine.

#### Prerequisites

*   JDK 17 or higher.
*   Apache Maven.

#### Instructions

1.  **Clone the Repository**
    Clone this repository to your local machine using the following command:
    ```bash
    git clone https://github.com/carlop13/java-unit-testing.git
    ```
    *(Note: Asegúrate de que esta URL sea la correcta para tu nuevo repositorio).*

2.  **Navigate to the Project Directory**
    ```bash
    cd java-unit-testing-challenge
    ```

3.  **Run Tests and Generate Coverage Report**
    Execute the following Maven command. This will clean the project, compile the code, run all unit tests, and generate the JaCoCo code coverage report.
    ```bash
    mvn clean verify
    ```

4.  **View the Coverage Report**
    After the build successfully completes, the report will be available at:
    `target/site/jacoco/index.html`

    Open this file in your web browser to see a detailed breakdown of the test coverage.

---

### 🛠️ Test-Driven Development in Action: Bug Discovery and Resolution

A primary goal of this sprint was to demonstrate how unit testing improves code quality. The TDD (Test-Driven Development) approach was simulated by first writing tests that exposed a bug, and then fixing the code to make the tests pass.

*   #### 🐞 Issue Found
    The initial test run revealed a critical failure in the `testEditGuestName_Success` test case. The logs showed an `AssertionFailedError`, indicating that the `editGuestName` method was not correctly updating the guest's name.

    *   **Expected Value:** `Updated Name`
    *   **Actual Value:** `Original Name`

*   #### 🧐 Root Cause Analysis
    A code review of `ReservationService.java` confirmed that the line responsible for assigning the new name to the `Reservation` object was missing from the `editGuestName` method.

*   #### ✅ Resolution
    The bug was resolved by adding the `reservation.setGuestName(newGuestName);` statement. After applying the fix, the `mvn clean verify` command was re-run, and the entire test suite passed successfully. This cycle effectively demonstrates the power of unit tests to catch regressions and validate functionality.

---
###  आगे क्या है (What's Next)

*   **Sprint 2:** Implementation of the JavaScript unit test suite using Jest.
*   **Sprint 3:** Finalization of project documentation, including code comments and architecture diagrams.