package pages.catalog.coursepages;

import org.openqa.selenium.WebDriver;
import pages.AbsBasePage;


public abstract class AbsCoursePage extends AbsBasePage {

    public AbsCoursePage(WebDriver driver) {
        super(driver);
    }

    //methods
    public boolean isLessonPage(){
        return driver.getCurrentUrl().contains("lessons");
    }

    public abstract void titleShouldPresent();
    public abstract void descriptionShouldPresent();
    public abstract void durationShouldPresent();
    public abstract String getTitle();



}
