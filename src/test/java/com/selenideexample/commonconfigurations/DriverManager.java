package com.selenideexample.commonconfigurations;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class DriverManager {
    private static DriverManager instance;
    private WebDriver driver;

    private DriverManager() {
        String browser = System.getProperty("browser", "chrome");

        switch (browser.toLowerCase()) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "chrome":
            default:
                //WebDriverManager.chromedriver().browserVersion("126.0.6478.127").setup();
                WebDriverManager.chromedriver().clearResolutionCache().setup();
                //WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
        }

        WebDriverRunner.setWebDriver(driver);
    }

    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
