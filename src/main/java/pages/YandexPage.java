package pages;
//POM для главной страницы Яндекс Дзен

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class YandexPage extends BasePage {

    // Локатор страницы Яндекс Дзена
    private final By yandexPageLocator = By.cssSelector(".zen-page");
    public YandexPage(WebDriver driver) {
        super(driver);
    }
    // Проверяем, что окно Яндекса Дзена открыто
    public boolean isYandexPageOpen() {
        return driver.findElement(yandexPageLocator).isDisplayed();
    }
}
