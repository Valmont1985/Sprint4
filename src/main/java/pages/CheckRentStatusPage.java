package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckRentStatusPage extends CommonHeader {
    // Локатор сообщения "Такого заказа нет"
    private final By trackNotFoundLabel = By.xpath(".//div[@class='Track_NotFound__6oaoY']");

    public CheckRentStatusPage(WebDriver driver) {
        super(driver);
    }

    // Проверяем вывод сообщения "Заказ не найден"
    public boolean isTrackNoFound() {
        return driver.findElement(trackNotFoundLabel).isDisplayed();
    }
}
