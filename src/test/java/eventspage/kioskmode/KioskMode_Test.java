package eventspage.kioskmode;

import factory.WebDriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.EventsPage;


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
    3) Валидация дат предстоящих мероприятий:
        3.1) Пользователь переходит в раздел «События» -> «Календарь мероприятий»
        3.2) На странице отображаются карточки предстоящих мероприятий.
        3.3) Даты проведения мероприятий больше или равны текущей дате
     */
    @Test
    public void futureEventsTest() {
        EventsPage page = new EventsPage(driver);
        page.open();

        for(WebElement event : page.getListOfEvents()) {
            page.eventShouldBeInFuture(event);
        }
    }


    /*
    4) Просмотр мероприятий по типу:
        4.1) Пользователь переходит в раздел «События» -> «Календарь мероприятий»
        4.2) Пользователь сортирует мероприятия по типу «Открытые вебинары»
        4.3) На странице отображаются карточки предстоящих мероприятий. На каждой карточке в типе указано «Открытые вебинары»
     */
    @Test
    public void eventsFilterTest() {
        EventsPage page = new EventsPage(driver);
        page.open();

        page.closePolicyNotification();
        String typeName = "Открытый вебинар";
        page.setEventFilter(typeName);
        for (WebElement event : page.getListOfEvents())
            page.eventTypeNameShouldBe(event, typeName);
    }



    @AfterEach
    public void driverClose(){
        if (driver != null) {
            driver.quit();
        }
    }



}

