package MainPage.optionsfree;

import factory.WebDriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

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

    @Test
    public void check() throws InterruptedException {
        MainPage page = new MainPage(driver);
        page.open();

        Thread.sleep(3000);
    }



    @AfterEach
    public void driverClose(){
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }



}
