package pages.catalog;

import annotations.Path;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.AbsBasePage;
import pages.catalog.coursepages.FreeCourse;
import pages.catalog.coursepages.LessonCourse;
import pages.catalog.coursepages.TestingCatalogCoursesPage;
import pages.catalog.coursepages.AbsCoursePage;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@Path("/catalog/courses")
public class CatalogCoursesPage extends AbsBasePage {

    public CatalogCoursesPage(WebDriver driver) {
        super(driver);
    }


    //locators
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

    public void catalogSectionNumberOfCoursesShouldBeEqual(Integer expected){
        assertThat(getCatalogSectionCourses().size()).isEqualTo(expected);
        logger.info("Number of courses of page {} is correct. Expected {}, actual {}.", driver.getCurrentUrl(), expected, getCatalogSectionCourses().size());
    }

    public void scrollCatalogCourses(){
        while(waiter.waitForConditionNoLogger(ExpectedConditions.visibilityOfElementLocated(showMoreButtonLocator)))
            driver.findElement(showMoreButtonLocator).click();
    }

    public AbsCoursePage clickCourse(WebElement course) throws IOException {
        waiter.waitForCondition(ExpectedConditions.elementToBeClickable(course));
        course.click();
        if (driver.getCurrentUrl().contains("lessons"))
            return new LessonCourse(driver);

        return new FreeCourse(driver);
    }

    public void coursePageAssertInfo(AbsCoursePage coursePage) {
        coursePage.titleShouldPresent();
        coursePage.descriptionShouldPresent();
        coursePage.durationShouldPresent();
    }

    public void cycleAssertCoursesPagesInfo(CatalogCoursesPage pageTesting) throws IOException {
        scrollCatalogCourses();
        int numberOfCourses = getCatalogSectionCourses().size();
        for (int i = 0; i < numberOfCourses; i++) {
            if (i >= getCatalogSectionCourses().size())
                scrollCatalogCourses();

            By chatCloseSelector= By.cssSelector("#jivo_close_button");
            if (waiter.waitForConditionNoLogger(ExpectedConditions.visibilityOfElementLocated(chatCloseSelector)))
                driver.findElement(chatCloseSelector).click();

            AbsCoursePage coursePage = clickCourse(getCatalogSectionCourses().get(i));
            coursePageAssertInfo(coursePage);

            driver.navigate().back();
            pageTesting = new TestingCatalogCoursesPage(driver);
        }
    }


}
