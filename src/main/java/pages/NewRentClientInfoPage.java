package pages;
//POM страницы "Для кого самокат"

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WebTestUtils;

public class NewRentClientInfoPage extends CommonHeader {

    // Заголовок
    private final By pageHeader = By.xpath(".//div[@class='Order_Header__BZXOb']");
    // Кнопка "Далее"
    private final By btnNext = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
    // Поле "Имя"
    private final By inputName = By.xpath(".//input[@placeholder='* Имя']");
    // Поле "Фамилия"
    private final By inputSurname = By.xpath(".//input[@placeholder='* Фамилия']");
    // Поле "Адрес"
    private final By inputAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    // Поле "Старция метро"
    private final By inputSubwayStation = By.xpath(".//input[@placeholder='* Станция метро']");

    // Локатор для элемента с перечислением станций
    // В методе вместо %s подставляется искомое значение
    // Путь передается в By для сохранения в перечислении локаторов
    By listSubwayStation = By.xpath(".//div[text()='%s']/parent::button");
    // Поле "Телефон"
    private final By inputPhoneNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    // Локаторы для сообщений о некорректном заполнении полей
    private final By inputNameErrorMessage = By.xpath(".//div[text()='Введите корректное имя']");
    private final By inputSurnameErrorMessage = By.xpath(".//div[text()='Введите корректную фамилию']");
    private final By inputAddressErrorMessage = By.xpath(".//div[text()='Введите корректный адрес']");
    private final By inputPhoneNumberError = By.xpath(".//div[text()='Введите корректный номер']");

    public NewRentClientInfoPage(WebDriver driver) {
        super(driver);
    }

    // Проверка наличия заголовка на странице
    public boolean isPageHeader() {
        return driver.findElement(pageHeader).isDisplayed();
    }

    // Ввод имени
    public NewRentClientInfoPage inputName(String name) {
        driver.findElement(inputName).sendKeys(name);
        return this;
    }

    // Ввод фамилии
    public NewRentClientInfoPage inputSurname(String surname) {
        driver.findElement(inputSurname).sendKeys(surname);
        return this;
    }

    // Ввод адреса
    public NewRentClientInfoPage inputAddress(String address) {
        driver.findElement(inputAddress).sendKeys(address);
        return this;
    }

    // Ввод станции метро, выбираем станцию из выпадающего списка
    public NewRentClientInfoPage inputSubwayStation(String subwayStation) {
        driver.findElement(inputSubwayStation).click();
        WebTestUtils.scrollTo(driver, WebTestUtils.xPathFormater(listSubwayStation, subwayStation));
        driver.findElement(WebTestUtils.xPathFormater(listSubwayStation, subwayStation)).click();
        return this;
    }

    // Клик по полю для ввода станции метро
    public NewRentClientInfoPage inputSubwayStationClick(String subwayStation) {
        driver.findElement(inputSubwayStation).click();
        return this;
    }

    // Ввод телефонного номера
    public NewRentClientInfoPage inputPhoneNumber(String phoneNumber) {
        driver.findElement(inputPhoneNumber).sendKeys(phoneNumber);
        return this;
    }

    // Клик по кнопке "Далее"
    public NewRentParamPage btnNextClick() {
        driver.findElement(btnNext).click();
        return new NewRentParamPage(driver);
    }

    // Метод заполняющий все поля "Для кого самокат"
    public NewRentParamPage addCustomerInfo(String name, String surname, String address, String subwayStation, String phoneNumber) {
        return this.inputName(name)
                .inputSurname(name)
                .inputAddress(address)
                .inputSubwayStation(subwayStation)
                .inputPhoneNumber(phoneNumber)
                .btnNextClick();
    }

    // Проверка сообщений с ошибками о неправильно заполненных полях
    public boolean isInputNameErrorMessage() {
        return driver.findElement(inputNameErrorMessage).isDisplayed();
    }

    public boolean isInputSurnameErrorMessage() {
        return driver.findElement(inputSurnameErrorMessage).isDisplayed();
    }

    public boolean isInputAddressErrorMessage() {
        return driver.findElement(inputAddressErrorMessage).isDisplayed();
    }

    public boolean isInputPhoneNumberError() {
        return driver.findElement(inputPhoneNumberError).isDisplayed();
    }

}