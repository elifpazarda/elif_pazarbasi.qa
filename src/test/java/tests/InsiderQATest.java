package tests;

import base.BaseTest;
import pages.CareersPage;
import pages.JobApplicationPage;
import pages.JobListPage;
import pages.QualityAssurancePage;
import org.testng.annotations.Test;


public class InsiderQATest extends BaseTest{

    @Test(description = "Verify homepage navigation, QA job filters, and application page redirection")
    public void qaJobApplyToInsiderTest() throws InterruptedException {


        CareersPage careersPage = homePage.goToCareersPage();
        careersPage
                .waitForCareersPageLoad()
                .checkLocationsTeamsLifeAtInsiderSectionsVisible();

        QualityAssurancePage qaTeamPage = careersPage.goToQaTeamPage();

        JobListPage jobListPage = qaTeamPage.goToJobListPage();
        Thread.sleep(5000);
        jobListPage
                .waitJobListPageLoaded()
                .filterQaJobs()
                .verifyLocationSelected("Istanbul, Turkiye")
                .verifyDepartmentSelected("Quality Assurance");
        Thread.sleep(5000);
        jobListPage.verifyJobDetailPositionDepartmentLocation("Quality Assurance", "Quality Assurance", "Istanbul, Turkiye");

        jobListPage.goToJobApplicationPage("Software Quality Assurance Engineer")
                .waitJobApplicationPageLoaded()
                .verifyRedirectionToLeverUrl()
                .checkJobTitleMatch("Software Quality Assurance Engineer");
    }
}

