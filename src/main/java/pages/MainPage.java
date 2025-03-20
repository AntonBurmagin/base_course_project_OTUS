package pages;

import annotations.Path;
import data.CourseCategoryData;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Path("")
public class MainPage extends AbsBasePage{

    public MainPage(WebDriver driver) {
        super(driver);
    }


    public CatalogCoursesPage clickCourseCategory(CourseCategoryData courseCategory) {
        By categoryLocator = By.xpath(String.format("//main//a[text()=\"%s\"]", courseCategory.getName()));

        waiter.waitForCondition(ExpectedConditions.visibilityOfElementLocated(categoryLocator));
        driver.findElement(categoryLocator).click();
        return new CatalogCoursesPage(driver);
    }
}
