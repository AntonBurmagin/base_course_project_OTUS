package kioskmode;

import data.CourseCategoryData;
import factory.WebDriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.CatalogCoursesPage;
import pages.MainPage;

public class KioskMode_Test {
    private static final WebDriverFactory webDriverFactory = new WebDriverFactory();
    private WebDriver driver = null;

    @BeforeAll
    public static void settings(){
        webDriverFactory.webDriverSetup();
    }

    @BeforeEach
    public void createDriver() {
        driver = webDriverFactory.create("--kiosk");
    }

    /*
    1) Проверка количества курсов в разделе «Тестирование»:
        1.1) Пользователь переходит в раздел «Тестирование»
        1.2) На странице отображаются карточки курсов. Количество карточек равно 11
    */
    @Test
    public void catalogTestingNumberOfCourses() {
        MainPage page = new MainPage(driver);
        page.open();
//        page.closePolicyNotification();

        CatalogCoursesPage coursesPage = page.clickCourseCategory(CourseCategoryData.TESTING);
        coursesPage.closePolicyNotification();
        coursesPage.scrollCatalogCourses();

        Integer expectedNumberOfCourses = 11;
        coursesPage.catalogSectionNumberOfCoursesShouldBe(expectedNumberOfCourses);
    }

//    @Test
//    public void coursePageTest() {
//        MainPage page = new MainPage(driver);
//        page.open();
//
//        CatalogCoursesPage coursesPage = page.clickCourseCategory(CourseCategoryData.TESTING);
//        List<WebElement> list = coursesPage.getCatalogSectionCourses();
//        for (WebElement el : list) {
//            System.out.println(el.getText());
//            el.click();
//        }
//    }




    @AfterEach
    public void driverClose(){
        if (driver != null) {
            driver.quit();
        }
    }



}
