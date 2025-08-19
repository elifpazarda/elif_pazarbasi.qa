package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HomePage extends BasePage {

    public String homePageUrl   = "https://useinsider.com/";
    public String homePageTitle = "#1 Leader in Individualized, Cross-Channel CX — Insider";

    public HomePage(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "wt-cli-accept-all-btn")
    WebElement clickAcceptCookies;

    @FindBy(linkText = "Company")
    WebElement companyMenu;

    @FindBy(linkText = "Careers")
    WebElement careerMenuItem;

    @Step("Go to the Home page")
    public void goToHomePage(){
        driver.get(homePageUrl);
    }

    @Step("Click Accept-Cookies-Button")
    public void clickAcceptCookie() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(clickAcceptCookies)).click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.invisibilityOf(clickAcceptCookies));
    }

    @Step("Check Home Page loaded successfully")
    public void checkHomePageAccessible(){
        assertEqualsText(driver.getTitle(),homePageTitle,"The Home Page is not loading properly");
    }

    @Step("Go to the Careers page")
    public CareersPage goToCareersPage(){
        waitForElementToBeClickable(companyMenu);
        clickElementWithJs(companyMenu);
        waitForElementToBeClickable(careerMenuItem);
        clickElementWithJs(careerMenuItem);
        return new CareersPage(driver);
    }


}