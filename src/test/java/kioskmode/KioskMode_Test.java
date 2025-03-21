package kioskmode;

import factory.WebDriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.catalog.CatalogCoursesPage;
import pages.TestingCatalogCoursesPage;

public class KioskMode_Test {
    private static final WebDriverFactory webDriverFactory = new WebDriverFactory();
    private WebDriver driver = null;

    @BeforeAll
    public static void settings(){
        webDriverFactory.webDriverSetup();
    }

    @BeforeEach
    public void createDriver() {
        driver = webDriverFactory.create("--headless");
    }

    /*
    1) Проверка количества курсов в разделе «Тестирование»:
        1.1) Пользователь переходит в раздел «Тестирование»
        1.2) На странице отображаются карточки курсов. Количество карточек равно 11
    */
    /*
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
    */



    /*
    2) Просмотр карточки курса:
        2.1) Пользователь переходит на карточку курса
        2.2) В карточке указана информация о курсе:
                Название
                Описание
                Длительность обучения
                Формат // Минимально достаточное — проверить одну карточку. В идеале все в разделе тестирования.
    */

    @Test
    public void coursesPageTest() throws InterruptedException {
        CatalogCoursesPage pageTesting = new TestingCatalogCoursesPage(driver);
        pageTesting.open();

        pageTesting.closePolicyNotification();
        pageTesting.cycleAssertCoursesPagesOfCategory(pageTesting);
    }




    @AfterEach
    public void driverClose(){
        if (driver != null) {
            driver.quit();
        }
    }



}
