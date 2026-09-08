# Spring Boot Practice — Banking Domain Model

> 📚 Part of a **Spring Boot practice series**, building toward a Kotlin + Spring Boot project. See also: [SPRINGBOOT1 — Student Management API](https://github.com/devrimsavas/SPRINGBOOT1) for the completed REST/CRUD layer this project will adopt.

A domain-modeling exercise in Spring Boot, focused on writing a correct, defensive banking domain (accounts, clients, transactions) using proper object-oriented practices — before wiring it up to a full REST API.

⚠️ **Status: domain layer only.** The `Account`, `Client`, and `Transaction` models are complete and validated, but are not yet exposed through REST controllers. This is the current focus of active development.

## 🚀 What's implemented

- **`Account`** — validated 8-digit account number (regex-enforced), opening date, running balance, and an unmodifiable view of its transaction history
  - `deposit()` / `withdraw()` enforce business rules directly on the domain object (e.g. withdrawal blocked if it would overdraw the account)
  - `equals()` / `hashCode()` based on the business key (account number), not object identity
- **`Client`** — validated name (alphanumeric only, via regex), positive client number enforced in the constructor
- **`Transaction`** — fully **immutable** record of a deposit or withdrawal: `final` fields, no setters, a generated UUID, and a timestamp — created only as a side effect of a valid `Account` operation
- **Correct money handling**: `BigDecimal` used throughout for balances and amounts, not `float`/`double` — avoiding a common floating-point rounding mistake in financial code
- A small `HelloWorldController` with basic warm-up endpoints (unrelated to the banking domain, kept from initial setup)

## 🛠 Tech Stack

- Java, Spring Boot 3.5 (Spring Web)
- Maven

## 📂 Project Structure

```
demo/
├── src/main/java/com/example/demo/
│   ├── model/
│   │   ├── Account.java       — validated account, deposit/withdraw, transaction history
│   │   ├── Client.java         — validated client
│   │   └── Transaction.java    — immutable transaction record
│   ├── HelloWorldController.java
│   ├── ReverseText.java
│   └── DemoApplication.java
└── src/main/resources/
    └── application.properties
```

## 🗺️ Roadmap

- [ ] Add `AccountController` / `AccountService` exposing REST endpoints for opening accounts, deposits, withdrawals, and transaction history — following the same Controller → Service pattern already proven in [SPRINGBOOT1](https://github.com/devrimsavas/SPRINGBOOT1)
- [ ] Add persistence (JPA/Hibernate) in place of in-memory storage
- [ ] Combine the lessons from both practice projects into a single **Kotlin + Spring Boot** project — a REST API with proper domain modeling, validation, and persistence, ported from these two Java exercises

## ▶️ Getting Started

```bash
cd demo
./mvnw spring-boot:run
```
The API runs on the default Spring Boot port (`8080`). Note: the banking domain classes are not yet reachable via HTTP — only `HelloWorldController`'s endpoints are currently live.

## 📝 Notes

This project is intentionally domain-first: before exposing a banking API over HTTP, the goal was to get the underlying business rules and validation right — immutable transactions, defensive constructors, and correct use of `BigDecimal` for money. The REST layer and persistence are the next steps, feeding into a combined Kotlin/Spring Boot project.
