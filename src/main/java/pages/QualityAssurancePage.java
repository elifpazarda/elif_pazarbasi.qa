package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QualityAssurancePage extends BasePage {

    public QualityAssurancePage(WebDriver driver){
        super(driver);
    }

    @FindBy(css = "a[href*='qualityassurance']")
    WebElement seeAllQaJobsBtn;

    @Step("Go to the job list Page")
    public JobListPage goToJobListPage(){
        waitForElementToBeVisible(seeAllQaJobsBtn);
        waitForElementToBeClickable(seeAllQaJobsBtn);
        clickElementWithJs(seeAllQaJobsBtn);
        try { Thread.sleep(20_000); } catch (InterruptedException ignored) {}
        return new JobListPage(driver);
    }

}