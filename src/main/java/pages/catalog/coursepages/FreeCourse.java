package pages.catalog.coursepages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FreeCourse extends AbsCoursePage {

    public FreeCourse(WebDriver driver) {
        super(driver);
    }

    //locators
    By titleSelector = By.cssSelector("main div:first-child div:first-child h3");
    By descriptionLocator = By.xpath("//h3[text()=\"Программа обучения\"]");


    //methods
    @Override
    public void titleShouldPresent() {
        waiter.waitForCondition(ExpectedConditions.visibilityOfElementLocated(titleSelector));
        assertThat(driver.findElement(titleSelector).isDisplayed()).isTrue();
        logger.info("{} course has title", getTitle());
    }

    @Override
    public void descriptionShouldPresent() {
        waiter.waitForCondition(ExpectedConditions.visibilityOfElementLocated(descriptionLocator));
        assertThat(driver.findElement(descriptionLocator).isDisplayed()).isTrue();
        logger.info("{} course has description", getTitle());
    }

    @Override
    public void durationShouldPresent() {
        logger.info("{} ---is--- online course (shouldn't have duration).", getTitle());
    }

    @Override
    public String getTitle() {
        waiter.waitForCondition(ExpectedConditions.visibilityOfElementLocated(titleSelector));
        return driver.findElement(titleSelector).getText();
    }


}
