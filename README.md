## Insider QA Test Automation Project

This repository contains UI test automation scenarios developed using **Selenium WebDriver** and **TestNG**.  
It follows the **Page Object Model (POM)** design pattern and integrates with **Allure** for detailed reporting.

## Project Structure
```
elif_pazarbasi.qa/
├── src/
│   ├── main/
│   │   └── java/pages/                
│   │       ├── BasePage.java
│   │       ├── HomePage.java
│   │       ├── CareersPage.java
│   │       ├── QualityAssurancePage.java
│   │       ├── JobListPage.java
│   │       └── JobApplicationPage.java
│   └── test/
│       └── java/
│           ├── base/                  
│           │   └── BaseTest.java
│           └── tests/                 
│               └── InsiderQATest.java
├── target/                           
├── allure-results/                    
├── pom.xml                            
└── .gitignore
```


## Automated Test Scenarios

- **Verify Home Page**
    - Visit [https://useinsider.com/](https://useinsider.com/) and check that the Insider Home Page is accessible.

- **Verify Careers Page**
    - Navigate via the **Company → Careers** menu.
    - Validate that **Locations, Teams, and Life at Insider** sections are visible.

- **Quality Assurance Jobs Page**
    - Go to [QA Careers Page](https://useinsider.com/careers/quality-assurance/).
    - Click **See all QA jobs**.
    - Filter jobs by:
        - Location: *Istanbul, Turkey*
        - Department: *Quality Assurance*
    - Verify that the job list is displayed.

- **Validate Job Listings**
    - Each job must contain:
        - **Position:** Quality Assurance
        - **Department:** Quality Assurance
        - **Location:** Istanbul, Turkey

- **Job Application Redirect**
    - Click **View Role**.
    - Confirm redirection to the **Lever Application Form** page.

## Running the Project

1. Clone the repository:
   ```bash
   git clone https://github.com/elifpazarda/elif_pazarbasi.qa.git
   cd elif_pazarbasi.qa

2. Run tests locally:
   ```bash
   mvn clean test
   ```

## Technologies Used

- Java 23
- Selenium Webdriver
- TestNG
- Allure Reporting
   