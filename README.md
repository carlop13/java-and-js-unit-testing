# Challenge: Java & JavaScript Programming Procedures

![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-3.9-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![JavaScript](https://img.shields.io/badge/JavaScript-ES6-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black)
![Node.js](https://img.shields.io/badge/Node.js-18.x-339933?style=for-the-badge&logo=node.js&logoColor=white)
![JUnit5](https://img.shields.io/badge/JUnit-5-25A162?style=for-the-badge&logo=junit5&logoColor=white)
![Jest](https://img.shields.io/badge/Jest-29-C21325?style=for-the-badge&logo=jest&logoColor=white)

This repository contains the solution for the **"Java and JavaScript. Programming Procedures"** challenge. The project focuses on implementing robust unit testing suites for both a Java module (Sprint 1) and a JavaScript module (Sprint 2), emphasizing code quality, high test coverage, and comprehensive documentation.

---

## 🚀 Getting Started

Follow these instructions to set up the project, run the tests for both modules, and view the coverage reports.

#### Prerequisites
*   JDK 17 or higher
*   Apache Maven
*   Node.js and npm (v18 or higher recommended)

#### Installation

1.  **Clone the Repository**
    ```bash
    git clone https://github.com/carlop13/java-unit-testing.git
    cd java-unit-testing
    ```
    *(Note: Ensure this URL matches your repository's URL).*

2.  **Install JavaScript Dependencies**
    The JavaScript module has its own dependencies managed by npm.
    ```bash
    cd sprint-2-javascript
    npm install
    cd .. 
    ```

---

## 🎯 Sprints Overview

### Sprint 1: Java Unit Testing with JUnit (Completed ✔️)

This sprint covered the implementation of a comprehensive test suite for a Java-based reservations module using JUnit 5. The primary goals were to ensure code correctness and achieve high test coverage.

*   **Key Technologies:** Java 17, Maven, JUnit 5, JaCoCo.
*   **Final Coverage:** Achieved **93% line coverage**, exceeding the 90% project requirement.

    [![Java Coverage](https://img.shields.io/badge/Java_Coverage-93%25-brightgreen?style=for-the-badge)](./target/site/jacoco/index.html)

*   **How to Run:**
    From the project's **root directory**, execute the following Maven command.
    ```bash
    mvn clean verify
    ```
    The full report is generated at `target/site/jacoco/index.html`.

#### 🛠️ Test-Driven Development in Action
A key part of this sprint was demonstrating the value of unit testing in finding bugs. A deliberate error in the `editGuestName` method was identified by a failing test (`testEditGuestName_Success`). This allowed for a documented cycle of identifying, fixing, and verifying the resolution, showcasing a practical TDD workflow.

---

### Sprint 2: JavaScript Unit Testing with Jest (Completed ✔️)

This sprint focused on creating a unit test suite for a JavaScript module responsible for calculating nearby cities, applying feedback from Sprint 1 to ensure deeper testing of edge cases and error handling.

*   **Key Technologies:** JavaScript (ES6), Node.js, Jest.
*   **Final Coverage:** Achieved **100% line coverage**.

    [![JS Coverage](https://img.shields.io/badge/JS_Coverage-100%25-brightgreen?style=for-the-badge)](./sprint-2-javascript/coverage/lcov-report/index.html)

*   **How to Run:**
    1.  Navigate to the Sprint 2 directory:
        ```bash
        cd sprint-2-javascript
        ```
    2.  Run the tests and generate the coverage report:
        ```bash
        npm run test:coverage
        ```
    The full report is generated at `sprint-2-javascript/coverage/lcov-report/index.html`.

#### 🧠 Technical Learnings & Peer Validation
In response to Sprint 1 feedback, this sprint's testing strategy emphasized robustness. Specific tests were created for invalid inputs (`null`, non-string types) and edge cases (e.g., cities with no connections). A self-review process was also conducted to enhance the clarity and maintainability of the test suite, with findings documented in `sprint-2-javascript/technical_learnings.md`.

---

### 🔜 What's Next

*   **Sprint 3:** Finalization of project documentation, including comprehensive Javadoc/JSDoc comments in the code and the creation of system architecture diagrams.