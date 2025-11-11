# Technical Difficulties and Strategies - Sprint 2

This document outlines the key technical learnings and strategies employed during the implementation of the Jest test suite for the JavaScript graph module.

## 1. Ensuring Robustness through Edge Case and Error Testing

*   **Challenge:** The initial feedback from Sprint 1 emphasized the need for deeper exception testing. Simply testing the "happy path" (e.g., finding cities for 'Querétaro') is not enough to build a robust application. The real challenge lies in how the function handles unexpected or invalid input.
*   **Strategy:** I designed specific test cases to address this:
    *   **Edge Case:** A test was created to check the behavior for a valid city that has no connections (`'Tulum'`). This ensures the function returns an empty array as expected, not `null` or an error.
    *   **Error Handling:** Two tests were implemented to validate that the function throws an `Error` when the input is `null` or a non-string type (e.g., a number). This is crucial for preventing downstream bugs and providing clear feedback if the function is used incorrectly.

## 2. Cross-Review and Peer Validation (Self-Review)

*   **Challenge:** The instructions recommended a cross-review. As I was working solo on this module, I performed a structured self-review.
*   **Strategy:** After writing the initial tests, I stepped back and asked: "If another developer were to look at this, would it be clear what is being tested?". This led me to:
    *   Use `describe` blocks to group related tests.
    *   Write clear test names (e.g., `'should throw an error for a null destination'`).
    *   Add comments to explain the purpose of more complex tests, like the one with custom data.
        This self-review process improved the clarity and maintainability of the test suite.