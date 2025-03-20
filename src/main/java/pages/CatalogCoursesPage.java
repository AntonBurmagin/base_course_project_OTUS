package pages;

import annotations.Path;
import components.CatalogCoursesFilterSection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//@Path("/catalog/courses?categories=testing")
@Path("/catalog/courses")
public class CatalogCoursesPage extends AbsBasePage {

    public CatalogCoursesPage(WebDriver driver) {
        super(driver);
    }


    //selectors
//    private final By catalogSectionLocator = By.xpath("//div/text()[. =\"Каталог\"]/ancestor::section");
    private final By catalogCoursesSectionSelector = By.cssSelector("main section + section");
    By showMoreButtonLocator = By.xpath("//button[contains(text(),'Показать еще')]");


    //methods
    public WebElement getCatalogSection() {
        return driver.findElement(catalogCoursesSectionSelector);
    }

    public List<WebElement> getCatalogSectionCourses() {
        waiter.waitForCondition(ExpectedConditions.visibilityOfElementLocated(catalogCoursesSectionSelector));
        return getCatalogSection().findElements(By.cssSelector("a"));
    }


    public void catalogSectionNumberOfCoursesShouldBe(Integer expected){
        assertThat(getCatalogSectionCourses().size()).isEqualTo(expected);
        logger.info("Number of courses of page {} is correct. Expected {}, actual {}.", driver.getCurrentUrl(), expected, getCatalogSectionCourses().size());
    }

    public CatalogCoursesFilterSection getFilterSection() {
        return new CatalogCoursesFilterSection(driver);
    }

    public void scrollCatalogCourses(){
        while(waiter.waitForConditionNoLogger(ExpectedConditions.visibilityOfElementLocated(showMoreButtonLocator)))
            driver.findElement(showMoreButtonLocator).click();
    }


}
