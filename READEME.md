# Cab Invoice Generator (TDD)

A simple **subscription-based cab billing system** built using **Test Driven Development (TDD)** in Java.  
The customer books rides during the month and receives an **invoice summary** at the end of the month.

This project follows the **Red → Green → Refactor** cycle and demonstrates clean, testable design with unit tests.

---

## Tech Stack
- Java
- Maven
- JUnit 5 (JUnit Jupiter)

---

## Problem Statement
Build an invoice generator that calculates cab fare based on:
- **Normal Ride:** ₹10 per km + ₹1 per minute, **minimum fare ₹5**
- **Premium Ride (Bonus):** ₹15 per km + ₹2 per minute, **minimum fare ₹20**
- Support **multiple rides**, **invoice summary**, and **invoice service by userId**.

---

## Features / Use Cases

### UC1 — Calculate Fare (Single Ride)
Given distance (km) and time (minutes), calculates total fare:
- Fare = `distance * 10 + time * 1`
- Minimum fare = ₹5  
  Includes basic validation for negative inputs.

### UC2 — Multiple Rides (Aggregate Fare)
Accepts multiple rides and returns total fare for all rides combined.

### UC3 — Enhanced Invoice
Returns an `InvoiceSummary` containing:
- Total number of rides
- Total fare
- Average fare per ride

### UC4 — Invoice Service (UserId Based Invoice)
Adds an `InvoiceService` that:
- Takes a `userId`
- Fetches rides from a `RideRepository`
- Returns the invoice (`InvoiceSummary`) for that user  
  Repository is stubbed/mocked in tests to keep unit tests fast and deterministic.

### UC5 — Premium Rides (Bonus)
Supports two ride categories:
- **NORMAL** (₹10/km, ₹1/min, min ₹5)
- **PREMIUM** (₹15/km, ₹2/min, min ₹20)

Allows mixed rides (normal + premium) in the same invoice calculation.

---

## Project Structure
src
├─ main
│ └─ java
│ └─ com/bridgelabz
│ ├─ InvoiceGenerator.java
│ ├─ Ride.java
│ ├─ RideCategory.java
│ ├─ InvoiceSummary.java
│ ├─ RideRepository.java
│ └─ InvoiceService.java
└─ test
└─ java
└─ com/bridgelabz
├─ InvoiceGeneratorTest.java
└─ InvoiceServiceTest.java

---

## How to Run Tests

### In IntelliJ
1. Open the project
2. Right-click `src/test/java` → **Run All Tests**

### Using Maven (Terminal)
```bash
mvn test
TDD Workflow Followed
For each use case, development is done using:
RED: Write a test and watch it fail
GREEN: Write minimum code to pass the test
REFACTOR: Improve code quality while keeping tests green
Notes / Good Practices Used
Tests are quick and deterministic
External interactions (repository) are stubbed in unit tests
Only public behavior is tested
Code is kept clean with constants and small responsibilities
Author
Devraj