package pages;

import annotations.Path;
import data.MonthData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Path("/events")
public class EventsPage extends AbsBasePage {

    public EventsPage(WebDriver driver) {
        super(driver);
    }

    //locators
    By eventClass = By.cssSelector(".dod_new-event");
    By eventDateClass = By.cssSelector(".dod_new-event__date-text");
    By eventTitle = By.cssSelector(".dod_new-event__title");
    By eventTypeFilter = By.cssSelector(".dod_new-events-dropdown__input");
    By eventType = By.cssSelector(".dod_new-event__type");


    //methods
    public List<WebElement> getListOfEvents() {
        return driver.findElements(eventClass);
    }

    public void eventShouldBeInFuture(WebElement event){
        waiter.waitForCondition(ExpectedConditions.visibilityOf(event));

        String []dateStore = driver.findElement(eventDateClass).getText().split(" ");
        Integer day = Integer.parseInt(dateStore[0]);
        Integer month =MonthData.customValueOf(dateStore[1]).getValue();

        LocalDate localDate = LocalDate.now();
        LocalDate eventDate = LocalDate.of(localDate.getYear(), month, day);

        assertThat(eventDate).isAfterOrEqualTo(localDate);
        logger.info("{} is in future.", event.findElement(eventTitle).getText());
    }

    public WebElement getTypeFilter() {
        return driver.findElement(eventTypeFilter);
    }

    public void setEventFilter(String typeName){
        By filterArrowSelector = By.cssSelector(".dod_new-events-dropdown__input");
        By typeFilterSelector = By.cssSelector(String.format(".dod_new-events__header-left [title=\"%s\"]", typeName));

        waiter.waitForCondition(ExpectedConditions.visibilityOfElementLocated(filterArrowSelector));
        driver.findElement(filterArrowSelector).click();

        waiter.waitForCondition(ExpectedConditions.visibilityOfElementLocated(typeFilterSelector));
        driver.findElement(typeFilterSelector).click();
    }

    public void eventTypeNameShouldBe(WebElement event, String typeName){
        assertThat(event.findElement(eventType).getText()).isEqualTo(typeName);
        logger.info("{} ---is--- {}", event.findElement(eventTitle).getText(), typeName);
    }


}
