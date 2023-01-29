package framework.managers;

import framework.utils.PropsConst;
import org.junit.jupiter.api.condition.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverManager {

    private static DriverManager INSTANCE = null;
    private WebDriver driver;
    private TestPropManager propManager = TestPropManager.getInstance();

    private DriverManager() {

    }

    public static DriverManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DriverManager();
        }
        return INSTANCE;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    private void initDriver() {
        switch (propManager.getProperty("browser", "chrome")) {
            case "edge":
                if (OS.WINDOWS.isCurrentOs()) {
                    System.setProperty("webdriver.edge.driver",
                            propManager.getProperty(PropsConst.PATH_EDGE_DRIVER_WINDOWS));

                } else if (OS.LINUX.isCurrentOs()) {
                    System.setProperty("webdriver.edge.driver",
                            propManager.getProperty(PropsConst.PATH_EDGE_DRIVER_LINUX));

                } else if (OS.MAC.isCurrentOs()) {
                    System.setProperty("webdriver.edge.driver",
                            propManager.getProperty(PropsConst.PATH_EDGE_DRIVER_MAC));
                }
                DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities.setAcceptInsecureCerts(true);
                driver = new EdgeDriver(desiredCapabilities);
            case "firefox":
                if (OS.WINDOWS.isCurrentOs()) {
                    System.setProperty("webdriver.firefox.driver",
                            propManager.getProperty(PropsConst.PATH_GRECO_DRIVER_WINDOWS));

                } else if (OS.LINUX.isCurrentOs()) {
                    System.setProperty("webdriver.firefox.driver",
                            propManager.getProperty(PropsConst.PATH_GRECO_DRIVER_LINUX));

                } else if (OS.MAC.isCurrentOs()) {
                    System.setProperty("webdriver.firefox.driver",
                            propManager.getProperty(PropsConst.PATH_GRECO_DRIVER_MAC));
                }
                FirefoxOptions fireFoxOptions = new FirefoxOptions();
                fireFoxOptions.addArguments("--disable-notifications");
                driver = new FirefoxDriver(fireFoxOptions);
            default:
                if (OS.WINDOWS.isCurrentOs()) {
                    System.setProperty("webdriver.chrome.driver",
                            propManager.getProperty(PropsConst.PATH_CHROME_DRIVER_WINDOWS));

                } else if (OS.LINUX.isCurrentOs()) {
                    System.setProperty("webdriver.chrome.driver",
                            propManager.getProperty(PropsConst.PATH_CHROME_DRIVER_LINUX));

                } else if (OS.MAC.isCurrentOs()) {
                    System.setProperty("webdriver.chrome.driver",
                            propManager.getProperty(PropsConst.PATH_CHROME_DRIVER_MAC));
                }
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-notifications");
                driver = new ChromeDriver(chromeOptions);
        }
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }


}
