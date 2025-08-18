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
        jobListPage.waitJobListPageLoaded();
        jobListPage.filterQaJobs();
        jobListPage.verifyLocationSelected("Istanbul, Turkiye");
        jobListPage.verifyDepartmentSelected("Quality Assurance");
        Thread.sleep(5000);

        jobListPage.verifyJobDetailPositionDepartmentLocation("Quality Assurance", "Quality Assurance", "Istanbul, Turkiye");

        JobApplicationPage jobApplicationPage = jobListPage.goToJobApplicationPage("Software Quality Assurance Engineer");
        jobApplicationPage.waitJobApplicationPageLoaded();

        jobApplicationPage.verifyRedirectionToLeverUrl();
        jobApplicationPage.checkJobTitleMatch("Software Quality Assurance Engineer");
    }

}

