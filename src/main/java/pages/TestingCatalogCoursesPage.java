package pages;

import annotations.Path;
import org.openqa.selenium.WebDriver;
import pages.catalog.CatalogCoursesPage;


@Path("/categories/testing")
public class TestingCatalogCoursesPage extends CatalogCoursesPage {

    public TestingCatalogCoursesPage(WebDriver driver) {
        super(driver);
    }
}
