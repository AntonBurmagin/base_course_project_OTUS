package CatalogPage.optionsfree;

import components.CatalogCoursesFilterSection;
import factory.WebDriverFactory;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CatalogCoursesPage;
import waiter.CustomWaiter;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class OptionsFree_Test {
    private static final WebDriverFactory webDriverFactory = new WebDriverFactory();
    private WebDriver driver = null;

    @BeforeAll
    public static void settings(){
        webDriverFactory.webDriverSetup();
    }

    @BeforeEach
    public void createDriver() {
        driver = webDriverFactory.create();
    }




    @AfterEach
    public void driverClose(){
        if (driver != null) {
            driver.quit();
        }
    }
}
