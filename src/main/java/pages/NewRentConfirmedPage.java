package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewRentConfirmedPage extends BasePage {

    // Заголовок окна подтверждения заказа
    private final By pageHeader = By.xpath(".//div[text()='Заказ оформлен']");
    // Локатор кнопки "Посмотреть статус"
    private final By btnShowStatus = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    public NewRentConfirmedPage(WebDriver driver) {
        super(driver);
    }
    // Проверка, что окно "Заказ оформлен" появилось
    public boolean isPageRentConfirmed() {
        return driver.findElement(pageHeader).isDisplayed();
    }
    // Клик по кнопке "Просмотр заказа"
    public BasePage btnShowStatusClick() {
        driver.findElement(btnShowStatus).click();
        return null;
    }
}
