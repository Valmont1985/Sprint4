package tests;

import config.TestData;
import org.junit.Assert;
import org.junit.Test;
import pages.HomePage;
import pages.NewRentClientInfoPage;
import utils.BaseTest;

// Тест неверного заполнения полей заказа.
// БАГ - При вводе неверной станции метро браузер падает на пустую страницу
public class CheckErrorMessagesFieldsTest extends BaseTest {
    @Test
    public void testErrorInFields() {
        // Вбиваем в поля неверные данные
        NewRentClientInfoPage clientInfoPage = new HomePage(driver)
                .btnRentScooterButtonClick()
                .inputName(TestData.INCORRECT_NAME)
                .inputSurname(TestData.INCORRECT_SURNAME)
                .inputAddress(TestData.INCORRECT_ADDRESS)
                .inputPhoneNumber(TestData.INCORRECT_PHONE_NUMBER)
                .inputSubwayStationClick("йцукен")
                .inputSubwayStationClick("фывапр");
        // Проверяем, что все ошибки отобразились
        Assert.assertTrue(clientInfoPage.isInputNameErrorMessage());
        Assert.assertTrue(clientInfoPage.isInputSurnameErrorMessage());
        Assert.assertTrue(clientInfoPage.isInputAddressErrorMessage());
        Assert.assertTrue(clientInfoPage.isInputPhoneNumberError());
    }
}
