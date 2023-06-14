package pages;
// Класс с общими элементами для разных страниц

import config.TestConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class CommonHeader extends BasePage {

    // Ссылка для перехода на страницу Яндекс Дзен
    private final By linkToYandex = By.className("Header_LogoYandex__3TSOI");
    // Ссылка для перехода на главную страницу Яндекс Самокат
    private final By linkToScooterHomePage = By.cssSelector(".Header_LogoScooter__3lsAR");

    public CommonHeader(WebDriver driver) {
        super(driver);
    }
    // Клик по ссылке на страницу Яндекс Дзен
    public YandexPage goToYandexHomePageClick() {
        // Запоминаем хэндл окна сервиса самокатоы
        String originalScooterWindow = driver.getWindowHandle();
        driver.findElement(linkToYandex).click();
        // Ждем появления второго окна
        new WebDriverWait(driver, TestConfig.IMPLICIT_WAIT_SECONDS).until(numberOfWindowsToBe(2));
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalScooterWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        return new YandexPage(driver);
    }

    // Клик по ссылке на главную страницу Яндекс Самокат
    public HomePage goToScooterHomePage() {
        driver.findElement(linkToScooterHomePage).click();
        return new HomePage(driver);
    }
}
