package pages.catalog.coursepages;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class LessonCourse extends AbsCoursePage {
    private final Document doc;

    public LessonCourse(WebDriver driver) throws IOException {
        super(driver);
        this.doc = Jsoup.connect(driver.getCurrentUrl()).get();
    }


    //
    String titleSelectorJsoup = "section h1";
    String durationLocatorJsoup = "//section/div[3]//p[contains(text(),'месяц')]";
    String descriptionLocatorJsoup = "//main/div/div[1]";


    //methods
    public void titleShouldPresent(){
        assertThat(doc.select(titleSelectorJsoup).text().length()).isNotZero();
        logger.info("{} course has title", getTitle());
    }

    public void descriptionShouldPresent(){
        assertThat(doc.selectXpath(descriptionLocatorJsoup).text().length()).isNotZero();
        logger.info("{} course has description", getTitle());
    }

    public void durationShouldPresent(){
        assertThat(doc.selectXpath(durationLocatorJsoup).text().length()).isNotZero();
        logger.info("{} course has duration", getTitle());
    }

    public String getTitle(){
        return doc.select(titleSelectorJsoup).text();
    }

}
