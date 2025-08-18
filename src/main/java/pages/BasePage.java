package pages;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import java.time.Duration;
import java.util.List;

public class BasePage {


    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public void assertEqualsText(String actual, String expected, String message) {
        if (!String.valueOf(actual).equals(String.valueOf(expected))) {
            Allure.step("Assertion failed: " + message + " | expected: " + expected + " | actual: " + actual);
            screenshot();
        }
        Assert.assertEquals(actual, expected, message);
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] screenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public void waitForElementToBeClickable(WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(element));
    }


    public void waitForElementToBeVisible(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementsToBeVisible(List<WebElement> elements) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public boolean isElementVisible(WebElement element){
        try {
            return element.isDisplayed();
        }catch (Exception e){
            screenshot();
            return false;
        }
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void hoverOverElement(WebElement element) {
        new Actions(driver).moveToElement(element).perform();
    }

    @Step("Switch to the new browser tab")
    public void switchToNewTab() {
        String originalWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(d -> d.getWindowHandles().size() > 1);

        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public void clickElementWithJs(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        js.executeScript("arguments[0].click();", element);
    }


    @Step("Click on: {elementName}")
    public void clickElementActionShowStep(WebElement element,String elementName) {
        new Actions(driver).moveToElement(element).click().perform();
    }

}
