package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CareersPage extends BasePage {

    public CareersPage(WebDriver driver){
        super(driver);
    }

    @FindBy(id="career-our-location")
    WebElement locationsSection;

    @FindBy(css = "section[data-id='a8e7b90']")
    WebElement lifeAtInsiderSection;

    @FindBy(id="career-find-our-calling")
    WebElement teamsSection;

    @FindBy(className = "loadmore")
    WebElement seeAllTeamsBtn;

    @FindBy(linkText = "Quality Assurance")
    WebElement qualityAssuranceLink;

    public CareersPage waitForCareersPageLoad(){
        waitForElementToBeVisible(locationsSection);
        waitForElementToBeVisible(lifeAtInsiderSection);
        waitForElementToBeVisible(teamsSection);
        return this;
    }

    public CareersPage checkLocationsTeamsLifeAtInsiderSectionsVisible(){
        verifyTeamsSectionVisible();
        verifyLifeAtInsiderSectionVisible();
        verifyLocationSectionVisible();
        return this;
    }

    void verifyLocationSectionVisible(){
        Assert.assertTrue(isElementVisible(locationsSection),"Locations section is not visible");
    }

    void verifyLifeAtInsiderSectionVisible(){
        Assert.assertTrue(isElementVisible(lifeAtInsiderSection),"Life at Insider section is not visible");
    }

    void verifyTeamsSectionVisible(){
        Assert.assertTrue(isElementVisible(teamsSection),"Teams section is not visible");
    }

    @Step("Go to the Quality Assurance Page")
    public QualityAssurancePage goToQaTeamPage(){
        clickElementWithJs(seeAllTeamsBtn);
        waitForElementToBeClickable(qualityAssuranceLink);
        clickElementWithJs(qualityAssuranceLink);
        screenshot();
        return new QualityAssurancePage(driver);
    }
}