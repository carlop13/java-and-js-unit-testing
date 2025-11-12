# Challenge: Java & JavaScript Programming Procedures

![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-3.9-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![JavaScript](https://img.shields.io/badge/JavaScript-ES6-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black)
![Node.js](https://img.shields.io/badge/Node.js-18.x-339933?style=for-the-badge&logo=node.js&logoColor=white)
![JUnit5](https://img.shields.io/badge/JUnit-5-25A162?style=for-the-badge&logo=junit5&logoColor=white)
![Jest](https://img.shields.io/badge/Jest-29-C21325?style=for-the-badge&logo=jest&logoColor=white)

## 1. Project Overview

This repository contains the complete solution for the **"Java and JavaScript. Programming Procedures"** challenge. The project demonstrates professional software quality assurance practices by implementing robust unit testing suites and comprehensive documentation for both a Java backend module and a JavaScript utility module.

The project is structured into three sprints, covering:
- **Sprint 1:** Unit testing a Java reservations module with JUnit 5.
- **Sprint 2:** Unit testing a JavaScript city graph module with Jest.
- **Sprint 3:** Finalizing all project documentation, including in-code comments and architectural diagrams.

---

## 2. 🚀 Getting Started

Follow these instructions to set up the project, run all tests, and view the coverage reports.

#### Prerequisites
*   JDK 17 or higher
*   Apache Maven
*   Node.js and npm (v18 or higher recommended)

#### Installation

1.  **Clone the Repository**
    ```bash
    git clone https://github.com/carlop13/java-unit-testing-challenge.git
    cd java-unit-testing-challenge
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

## 3. 🧪 Test Suite Description and Execution

This project includes two separate test suites designed to validate the correctness and robustness of each module.

### 3.1. Java Module (JUnit)

This test suite, located in `src/test/java`, validates the `ReservationService` class. It covers all core functionalities (create, edit, cancel) and includes tests for negative scenarios and exception handling.

*   **How to Execute:**
    From the project's **root directory**, run the following Maven command:
    ```bash
    mvn clean verify
    ```
*   **Expected Result (Snippet):**
    The command will compile, run tests, and generate a coverage report, ending with a `BUILD SUCCESS` message.
    ```
    [INFO] Tests run: 9, Failures: 0, Errors: 0, Skipped: 0
    ...
    [INFO] BUILD SUCCESS
    ```
    The full JaCoCo coverage report is generated at `target/site/jacoco/index.html`.

### 3.2. JavaScript Module (Jest)

This test suite, located in `sprint-2-javascript/`, validates the `getNearbyCities` function. It focuses on correct data transformation, edge cases, and handling of invalid inputs.

*   **How to Execute:**
    1.  Navigate to the Sprint 2 directory: `cd sprint-2-javascript`
    2.  Run the tests and generate the coverage report: `npm run test:coverage`

*   **Expected Result (Snippet):**
    Jest will display a passing status and a coverage summary in the terminal.
    ```
     PASS  ./graph.test.js
    ...
    Test Suites: 1 passed, 1 total
    Tests:       5 passed, 5 total
    ```
    The full HTML coverage report is generated at `sprint-2-javascript/coverage/lcov-report/index.html`.

---

## 4. 📄 Project Documentation

As part of Sprint 3, comprehensive documentation was created to ensure the project is maintainable and easy to understand.

### 4.1. Code Documentation

*   **Java Module:** All public classes and methods in the `com.bookingmx.reservations` package are documented using **Javadoc** comments. This explains the purpose, parameters, and return values of each component.
*   **JavaScript Module:** The `getNearbyCities` function in `graph.js` is documented using **JSDoc** comments, clarifying its functionality, parameters, and expected behavior.

### 4.2. System Architecture Diagrams

Diagrams illustrating the system architecture and development workflow have been created and are available in the following file:
- **[`System_Architecture_Diagrams.pdf`](./System_Architecture_Diagrams.pdf)**

This PDF includes a class diagram for the Java module and a flowchart of the testing and development process.

### 4.3. Technical Learnings and Peer Review

In response to project feedback, a self-review process was conducted during Sprint 2. The findings and strategies for improving test robustness are documented in:
- **[`sprint-2-javascript/technical_learnings.md`](./sprint-2-javascript/technical_learnings.md)**

---

## 5. 🏆 Sprint Achievements Summary

| Sprint | Focus | Key Achievement | Final Coverage |
|:---    |:---   |:---             |:---            |
| **1**  | Java Unit Testing (JUnit) | Implemented a TDD cycle to find and fix a bug. | **93%** |
| **2**  | JavaScript Unit Testing (Jest) | Focused on deep exception and edge case testing. | **100%** |
| **3**  | Documentation & Finalization | Created comprehensive project and code documentation. | N/A |