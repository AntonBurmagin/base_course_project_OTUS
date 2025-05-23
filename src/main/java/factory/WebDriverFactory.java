package factory;

import exceptions.BrowserNotSupportedException;
import factory.settings.ChromeSettings;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;


public class WebDriverFactory {
    private String browser = System.getProperty("browser").toLowerCase().trim();

    public WebDriver create(String...optionsArguments) {
        return switch (browser) {
            case "chrome" -> new ChromeDriver((ChromeOptions) new ChromeSettings().settings(optionsArguments));
            case "edge" -> new EdgeDriver();
            default -> throw new BrowserNotSupportedException(browser);
        };
    }

    public void webDriverSetup(){
        switch (browser){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                break;
            default:
                throw new BrowserNotSupportedException(browser);
        }
    }

}
