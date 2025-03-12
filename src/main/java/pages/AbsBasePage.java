package pages;

import annotations.Path;
import common.AbsCommon;
import exceptions.PagePathAnnotationNotFoundException;
import org.openqa.selenium.WebDriver;

public abstract class AbsBasePage extends AbsCommon {
    private final String path;

    public AbsBasePage(WebDriver driver) {
        super(driver);
        this.path = System.getProperty("base.url");
    }

    private String getAddPath() {
        Class clazz = getClass();
        if (clazz.isAnnotationPresent(Path.class)) {
            Path path = (Path) clazz.getDeclaredAnnotation(Path.class);
            return path.value();
        }
        throw new PagePathAnnotationNotFoundException();
    }

    public void open() {
        driver.get(path + getAddPath());
    }
}
