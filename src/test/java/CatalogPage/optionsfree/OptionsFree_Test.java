package CatalogPage.optionsfree;

import factory.WebDriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;


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
