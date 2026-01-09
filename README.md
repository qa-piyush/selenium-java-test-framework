# 🧪 Swag Labs Selenium Automation Framework

This project is a **Java-based Selenium automation framework** built to test the **Swag Labs** e-commerce application.  
It follows **industry-standard automation practices** with a focus on **maintainability, scalability, and parallel execution**.

---

## 🔧 Tech Stack

- **Language:** Java  
- **Automation Tool:** Selenium WebDriver (4.x)  
- **Test Framework:** TestNG  
- **Build Tool:** Maven  
- **Browser Management:** WebDriverManager  
- **Design Pattern:** Page Object Model (POM)  
- **Execution:** Parallel execution using TestNG  
- **Reporting:** TestNG + screenshots on failure  

---

## 📁 Project Structure


---

## 🧠 Framework Design Highlights

### ✅ Page Object Model (POM)
- Each page contains:
  - Private locators
  - Page-specific actions
  - Clear navigation to next pages

### ✅ Thread-Safe WebDriver
- Uses `ThreadLocal<WebDriver>`
- Ensures isolation during parallel execution
- Prevents session leakage between tests

### ✅ Parallel Execution
- Enabled using **TestNG**
- Test classes run in parallel
- Configurable via `testng.xml`

### ✅ Utility Abstraction
- `WaitUtil` → Explicit waits (visibility, clickable, presence)
- `ElementUtil` → Centralized element interactions
- `ConfigReader` → Environment configuration
- `ScreenshotUtil` → Captures screenshots on failure

### ✅ Business Flow Abstraction
- `CheckoutFlow` encapsulates reusable business logic
- Keeps test classes clean and readable

### ✅ Robust Exception Handling
- Custom `FrameworkException`
- Meaningful failure messages
- Easier debugging and maintenance

---

## ⚙️ Configuration

Update `config.properties`:

```properties
browser=chrome
url=https://www.saucedemo.com
username=standard_user
password=secret_sauce


Test Coverage

✅ Valid & invalid login

✅ Add/remove items from cart

✅ Logout & session guard validation

✅ Negative checkout validations

✅ End-to-end purchase flow

How to Run Tests

mvn clean test

Run via TestNG suite

mvn test -Dsurefire.suiteXmlFiles=src/test/resources/testng.xml


EcommAutomation
│
├── src/main/java
│   ├── driver
│   │   └── DriverFactory.java
│   │
│   ├── com.ecomm.framework.pages
│   │   ├── LoginPage.java
│   │   ├── InventoryPage.java
│   │   ├── CartPage.java
│   │   ├── CheckoutStepOnePage.java
│   │   ├── CheckoutStepTwoPage.java
│   │   └── CheckoutCompletePage.java
│   │
│   ├── com.ecomm.framework.utils
│   │   ├── ConfigReader.java
│   │   ├── WaitUtil.java
│   │   ├── ElementUtil.java
│   │   ├── ScreenshotUtil.java
│   │
│   ├── exceptions
│   │   └── FrameworkException.java
│
├── src/test/java
│   ├── tests
│   │   ├── BaseTest.java
│   │   ├── LoginTest.java
│   │   ├── CartTest.java
│   │   ├── LogoutTest.java
│   │   ├── PurchaseTest.java
│   │   └── CheckoutStepOnePageNegTest.java
│   │
│   ├── flows
│   │   └── CheckoutFlow.java
│   │
│   └── listeners
│       └── TestListener.java
│
├── src/main/resources
│   └── config.properties
│
├── src/test/resources
│   └── testng.xml
│
├── pom.xml
└── README.md
