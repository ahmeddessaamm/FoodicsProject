# Automated Testing Task: Amazon Checkout

This document provides a detailed explanation of the testing task, covering all requirements, steps, tools, and instructions.

## Project Overview
This project automates the testing of a user journey on Amazon.eg, focusing on searching for video games, applying filters, adding products to the cart, and validating the order total. The project ensures efficient test execution and generates reports using **Allure** for detailed insights.


## Technical Details

### Tools and Technologies
- **Programming Language**: Java
- **Build Tool**: Maven
- **Testing Framework**: TestNG
- **Automation Framework**: Selenium
- **Reporting Tool**: Allure

### Directory Structure
```
project-root/
|-- src/
|   |-- main/
|   |   |-- java/
|   |       |-- pages/
|   |       |   |-- BasePage.java
|   |       |   |-- CheckOutPage.java
|   |       |   |-- LoginPage.java
|   |       |   |-- CartPage.java
|   |       |   |-- Homepage.java
|   |       |   |-- AddressModalPage.java
|   |       |   |-- FilterPage.java
|   |       |   |-- VideoGamesPage.java
 |-- utils/
            |   |-- AddressDataHelper.java
            |   |-- JsonDataReader.java
|-- resources/
|     |-- config.properties/
|       |-- addressData.json
|   |-- test/
|       |-- java/
|           |-- tests/
|           |   |-- AmazonTest.java
|           |-- utils/
|               |-- Helper.java
|-- resources/
|   |-- test-data/
|       |-- addressData.json
|-- allure-results/
|-- pom.xml

## Setting Up the Project

### Prerequisites
1. Install **Java JDK 21+**.
2. Install **Maven**.
3. Install **Allure** for report generation.
4. Set up **Selenium WebDriver**.

### Installation
1. Clone the repository:
   ```bash
   git clone <repository-url>
   ```
2. Navigate to the project directory:
   ```bash
   cd project-root
   ```
3. Install dependencies:
   ```bash
   mvn clean install
   ```
Amazon Credentials:

Add your Amazon account email and password to the 
config.properties file in the following format:
email=your_email@example.com
password=your_password

### Running the Tests
1. Execute the test suite:
   ```bash
   mvn test
   ```

2. Generate and view Allure reports:
   ```bash
   allure serve allure-results
   ```

## Summary
This project provides a comprehensive solution for automating the specified Amazon checkout workflow. The use of modular design and dynamic data handling ensures maintainability and scalability. The inclusion of Allure reporting enhances the debugging and analysis process.

