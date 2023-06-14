package pages;
//POM страницы "Про аренду"

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WebTestUtils;

public class NewRentParamPage extends CommonHeader {
    // Локатор заголовка страницы
    private final By pageHeader = By.xpath(".//div[@class='Order_Header__BZXOb']");
    // Локатор для поля для ввода времени доставки
    private final By inputDeliveryTime = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    // Срок аренды
    private final By inputRentalPeriod = By.xpath(".//div[@class='Dropdown-placeholder']");
    // Меню со сроком аренды
    private final By inputRentalPeriodMenu = By.xpath(".//div[(@class='Dropdown-option') and (text()='%s')]");

    // Цвет самоката
    // В методе подставляется необходимое значение вместо %s
    // Путь передается в By для сохранения  в перечислении локаторов
    private final By inputScooterColor = By.xpath(".//label[(text()='%s')]");

    // Комментарий для курьера
    private final By inputComment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    // Кнопка "Назад"
    private final By btnBack = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM.Button_Inverted__3IF-i");
    // Кнопка "Заказать"
    private final By btnCreateOrder = By.xpath("//button[(@class='Button_Button__ra12g Button_Middle__1CSJM')" +
            " and (text()='Заказать')]");
    public NewRentParamPage(WebDriver driver) {
        super(driver);
    }
    // Проверка наличия заголовка страницы
    public boolean isPageHeader() {
        return driver.findElement(pageHeader).isDisplayed();
    }
    // Клик по полю даты доставки самоката
    public NewRentParamPage inputDeliveryTimeClick() {
        driver.findElement(inputDeliveryTime).click();
        return this;
    }
    // Ввод даты в поле "Дата доставки"
    public void inputDeliveryTime(String deliveryTime) {
        driver.findElement(inputDeliveryTime).sendKeys(deliveryTime);
        //Кликаем по заголовку что бы закрыть календарь
        driver.findElement(pageHeader).click();
    }
    // Клик по полю "Выбор периода аренды"
    public void inputRentalPeriod(String rentalPeriod) {
        driver.findElement(inputRentalPeriod).click();
        By targetElement = WebTestUtils.xPathFormater(inputRentalPeriodMenu, rentalPeriod);
        WebTestUtils.waitElement(driver, targetElement);
        driver.findElement(targetElement).click();
    }
    // Выбор цвета "Черный жемчуг"
    public void selectColor(String color) {
        driver.findElement(WebTestUtils.xPathFormater(inputScooterColor, color)).click();
    }
    // Ввод комментрия для курьера
    public void inputComment(String comment) {
        driver.findElement(inputComment).sendKeys(comment);
    }
    // Клик по кнопке "Назад"
    public NewRentParamPage btnBackClick() {
        driver.findElement(btnBack).click();
        return this;
    }
    // Клик по кнопке "Заказать"
    public NewRentConfirmPage btnCreateOrderClick() {
        driver.findElement(btnCreateOrder).click();
        return new NewRentConfirmPage(driver);
    }
    // Метод заполняющий все поля про аренду
    public NewRentConfirmPage addRentInfo(String timeDelivery, String rentPeriod, String scooterColor, String comment) {
        inputDeliveryTime(timeDelivery);
        inputRentalPeriod(rentPeriod);
        selectColor(scooterColor);
        inputComment(comment);
        return btnCreateOrderClick();
    }
}
