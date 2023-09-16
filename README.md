CucumberFramework
Welcome to the CucumberFramework repository! This framework provides a structured approach to automate and test your software applications using Cucumber and Selenium WebDriver.

Features
BDD Support: Leverage the power of Behavior-Driven Development (BDD) to write your tests in a human-readable format using Gherkin syntax.
Modular Architecture: The framework follows a modular design, allowing you to organize and manage your test suites, step definitions, and page objects effectively.
Cross-Browser Testing: Run your tests across multiple browsers such as Chrome, Firefox, and Safari, ensuring compatibility and consistent behavior.
Parallel Execution: Execute your test scenarios in parallel, significantly reducing the overall test execution time.
Reporting: Generate comprehensive HTML reports with detailed test results, including passed and failed scenarios, step definitions, and screenshots.
Getting Started
To get started with the CucumberFramework, follow these steps:

Prerequisites: Make sure you have the following software installed on your system:

Java Development Kit (JDK) 8 or higher
Apache Maven
Web browsers you want to test (e.g., Chrome, Firefox)
ChromeDriver and GeckoDriver for WebDriver configuration
Clone the Repository: Clone this repository to your local machine using the following command:
git clone https://github.com/Mohamed-Abou-Daif/CucumberFramework.git
```
Configuration: Update the necessary configuration files to match your testing environment:

Update src/test/resources/config.properties with your application's URL and other relevant settings.
Configure the WebDriver settings in src/test/resources/driver.properties.

Install Dependencies: Navigate to the project root directory and install the required dependencies using Maven:
cd CucumberFramework
mvn clean install
```
Run Tests: Execute the test suite using Maven:
mvn test
```
View Reports: After the test execution is complete, you can find the HTML reports in the target/cucumber-reports directory. Open index.html in a web browser to view the reports.

Contributing
Contributions are welcome! If you encounter any issues or have suggestions for improvements, please submit them as GitHub issues in this repository. You can also fork the repository, make your changes, and submit a pull request.

When contributing, please adhere to the existing coding style and guidelines in the project.
