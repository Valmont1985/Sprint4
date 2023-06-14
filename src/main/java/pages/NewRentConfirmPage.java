package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewRentConfirmPage extends BasePage {
    // Заголовок формы
    private final By pageHeader = By.className("Order_ModalHeader__3FDaJ");
    // Кнопка "Нет"
    private final By btnNo = By.xpath(".//button[(@class='Button_Button__ra12g Button_Middle__1CSJM Button_Inverted__3IF-i') and " +
            "(text()='Нет')]");
    // Кнопка "Да"
    private final By btnYes = By.xpath(".//button[(@class='Button_Button__ra12g Button_Middle__1CSJM') and " +
            "(text()='Да')]");
    public NewRentConfirmPage(WebDriver driver) {
        super(driver);
    }
    // Клик по кнопке "Нет"
    public NewRentParamPage bntNoClick() {
        driver.findElement(btnNo).click();
        return new NewRentParamPage(driver);
    }
    // Клик по кнопке "Да"
    public NewRentConfirmedPage btnConfirmNewRentClick() {
        driver.findElement(btnYes).click();
        return new NewRentConfirmedPage(driver);
    }
}
