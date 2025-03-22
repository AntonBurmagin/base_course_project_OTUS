package pages.catalog.coursepages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.AbsBasePage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AbsCoursePage extends AbsBasePage {

    public AbsCoursePage(WebDriver driver) {
        super(driver);
    }

    //locators
    By titleSelector = By.cssSelector("section h1");
//    By descriptionId = By.id("vdescription");  не у всех курсов есть
    By durationLocator = By.xpath("//section/div[3]//p[contains(text(),'месяц')]");
    By descriptionLocator = By.xpath("//main/div/div[1]");
    
    
    //methods
    public boolean isCoursePage(){
        return driver.getCurrentUrl().contains("lessons");
    }

    public void titleShouldPresent(){
        waiter.waitForCondition(ExpectedConditions.visibilityOfElementLocated(titleSelector));
        assertThat(driver.findElement(titleSelector).isDisplayed()).isTrue();
        logger.info("{} course has title", driver.findElement(titleSelector).getText());
    }

    public void descriptionShouldPresent(){
        waiter.waitForCondition(ExpectedConditions.visibilityOfElementLocated(descriptionLocator));
        assertThat(driver.findElement(descriptionLocator).isDisplayed()).isTrue();
        logger.info("{} course has description", driver.findElement(titleSelector).getText());
    }

    public void durationShouldPresent(){
        waiter.waitForCondition(ExpectedConditions.visibilityOfElementLocated(durationLocator));
        assertThat(driver.findElement(durationLocator).isDisplayed()).isTrue();
        logger.info("{} course has duration", driver.findElement(titleSelector).getText());
    }

    public String getTitle(){
        waiter.waitForCondition(ExpectedConditions.visibilityOfElementLocated(titleSelector));
        return driver.findElement(titleSelector).getText();
    }



}
