package components;

import annotations.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

@Component("css:::main section:first-child")
public class CatalogCoursesFilterSection extends AbsComponent{
    private WebElement catalogCoursesFilter = null;

    public CatalogCoursesFilterSection(WebDriver driver) {
        super(driver);
//        waiter.waitForCondition(ExpectedConditions.visibilityOf(driver.findElement(getComponentBy())));
        catalogCoursesFilter = driver.findElement(getComponentBy());
    }
    //
    public String getString(){
        return catalogCoursesFilter.getText();
    }

    public List<WebElement> getFilters(){
        return catalogCoursesFilter.findElements(By.cssSelector("section > div"));
    }

    public WebElement getCatalogCoursesDirectionFilter() {
        return getFilters().get(0);
    }

    public WebElement getCatalogCoursesLevelFilter() {
        return getFilters().get(1);
    }

    public WebElement getCatalogCoursesFormatFilter() {
        return getFilters().get(2);
    }

    public WebElement getCatalogCoursesDurationFilter() {
        return getFilters().get(3);
    }

    public List<WebElement> getSubFilterOptions(WebElement subFilter) {
        return subFilter.findElements(By.cssSelector("div:first-child > div > div > div > div "));
    }

    public void enableFilterOptions(WebElement subFilter, ArrayList<String> options){
        for (WebElement it : getSubFilterOptions(subFilter)) {
            if (options.contains(it.findElement(By.cssSelector("label")).getText().toLowerCase())) {
                if (!it.findElement(By.cssSelector("input")).isSelected()) {
                    it.findElement(By.cssSelector("input")).click();
                    waiter.waitForCondition(ExpectedConditions.elementSelectionStateToBe(it.findElement(By.cssSelector("input")), true));
                    System.out.println(it.findElement(By.cssSelector("input")).isSelected());
                    waiter.waitForCondition(ExpectedConditions.urlContains("testing"));
                    System.out.println(waiter.waitForCondition(ExpectedConditions.urlContains("testing")));
                }
            }
        }
    }




}
