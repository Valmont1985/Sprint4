package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WebTestUtils;

public class HomePage extends CommonHeader {
    // Сообщение на разрешение хранения печенек
    private final By messageCooke = By.className("App_CookieText__1sbqp");
    // Кнопка запроса на хранение печенек
    private final By btnCooke = By.id("rcc-confirm-button");
    // Кнопка "Заказать" вверху страницы
    private final By btnRentScooterTop = By.className("Button_Button__ra12g");
    // Кнопка "Заказать" внизу страницы
    private final By btnRentScooterButton = By.xpath(".//button[(@class='Button_Button__ra12g Button_Middle__1CSJM')]");
    // Кнопка "Статус заказа"
    private final By btnSwitchToCheckRentStatus = By.className("Header_Link__1TAG7");
    // Кнопка "GO" для проверки заказа по введенному номеру
    private final By btnCheckRentStatus = By.cssSelector(".Button_Button__ra12g.Header_Button__28dPO");
    // Поле для ввода номера заказа
    private final By inputOrderNum = By.cssSelector(".Input_Input__1iN_Z.Header_Input__xIoUq");

    // Блок с вопросами
    // Локатор поля с вопросом. Вместо %s в методе подставляется искомое значение
    private final By faqQuestion = By.xpath(".//div[(@class='accordion__button') and (text()='%s')]");
    // Локатор ответа на вопрос. Вместо %s в методе подставляется искомое значение
    private final By faqAnswer = By.xpath(".//p[text()='%s']");
    // Текст на главной странице. Для проверки возврата на главную страницу
    private final By scooterHomePageWelcomeText = By.xpath(".//div[@class='Home_Header__iJKdX']");
    public HomePage(WebDriver driver) {
        super(driver);
    }
    // Проверка на окно с запросом разрешения на хранение печенек
    public boolean isCookieRequest() {
        return driver.findElement(messageCooke).isDisplayed();
    }
    public HomePage btnCookeClick() {
        driver.findElement(btnCooke).click();
        return this;
    }
    // Клик по кнопке "Заказать" в верху страницы
    public NewRentClientInfoPage btnRentScooterTopClick() {
        WebTestUtils.scrollTo(driver, btnRentScooterTop);
        driver.findElement(btnRentScooterTop).click();
        return new NewRentClientInfoPage(driver);
    }
    // Клик по кнопке "Заказать" внизу страницы
    public NewRentClientInfoPage btnRentScooterButtonClick() {
        WebTestUtils.scrollTo(driver, btnRentScooterButton);
        driver.findElement(btnRentScooterButton).click();
        return new NewRentClientInfoPage(driver);
    }
    // Клик по "Статус заказа"
    public HomePage btnSwitchToCheckRentStatusClick() {
        driver.findElement(btnSwitchToCheckRentStatus).click();
        return this;
    }
    // Ввод номера заказа
    public HomePage setOrderNum(String orderNum) {
        driver.findElement(inputOrderNum).sendKeys(orderNum);
        return this;
    }
    // Клик по кнопе "GO" для проверки статуса заказа
    public CheckRentStatusPage btnCheckRentStatus() {
        WebTestUtils.waitElement(driver, btnCheckRentStatus);
        driver.findElement(btnCheckRentStatus).click();
        return new CheckRentStatusPage(driver);
    }
    // Поиск вопроса и ответа.
    public void faqQuestionAnswerCheck(String questionText, String answerText) {
        // Подставляем вопрос
        By questionLocator = WebTestUtils.xPathFormater(faqQuestion, questionText);
        WebTestUtils.scrollTo(driver, questionLocator);
        driver.findElement(questionLocator).click();
        // Формируем локатор ответа
        By answerLocator = WebTestUtils.xPathFormater(faqAnswer, answerText);
        WebTestUtils.scrollTo(driver, answerLocator);
        driver.findElement(answerLocator);
    }
    public boolean getScooterHomePageWelcomeText() {
        WebTestUtils.scrollTo(driver, scooterHomePageWelcomeText);
        return driver.findElement(scooterHomePageWelcomeText).isDisplayed();
    }
}
