package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.testng.Assert;

import java.util.List;

public class JobApplicationPage extends BasePage {

    public static String leverPageUrl  = "https://jobs.lever.co/";

    public JobApplicationPage(WebDriver driver){
        super(driver);
    }

    @FindBy(css = "a[href*='/apply']")
    List<WebElement> applyForThisJobBtns;

    @FindBy(className = "posting-headline")
    WebElement jobHeadline;

    @Step("Verify redirection to Lever application page")
    public JobApplicationPage verifyRedirectionToLeverUrl(){
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(
                actualUrl.startsWith(leverPageUrl), "Redirect URL mismatch. Expected: " + leverPageUrl + " but was: " + actualUrl);
        return this;
    }

    @Step("Check job title matches")
    public JobApplicationPage checkJobTitleMatch(String expectedTitle){
        String actualJobTitle = jobHeadline.findElement(By.tagName("h2")).getText().trim();
        assertEqualsText(actualJobTitle, expectedTitle, "Job Title does not match! Expected: '" + expectedTitle + "', but found: '" + actualJobTitle + "'");
        return this;
    }

    public JobApplicationPage waitJobApplicationPageLoaded(){
        waitForElementsToBeVisible(applyForThisJobBtns);
        waitForElementToBeVisible(jobHeadline);
        screenshot();
        return this;
    }


}