package utils;
// Базовый класс для всех тестов. В него вынесены общие методы и переменные для всех классов.

import config.TestConfig;
import config.WebConfig;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;
import static config.TestConfig.IMPLICIT_WAIT_SECONDS;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    protected WebDriver driver;

    @Before
    public void initTest() {
        WebDriverManager.chromedriver().setup();
        switch (TestConfig.TARGET_BROWSER) {
            case CHROME:
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
        }
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_SECONDS, TimeUnit.SECONDS);
        driver.get(WebConfig.HOME_PAGE_URL);
    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }

}