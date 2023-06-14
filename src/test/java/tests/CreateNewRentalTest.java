package tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.HomePage;
import utils.BaseTest;
import utils.WebTestUtils;

@RunWith(Parameterized.class)
public class CreateNewRentalTest extends BaseTest {

    private final String name;
    private final String surname;
    private final String address;
    private final String subwayStation;
    private final String phoneNumber;
    private final String dateStartRent;
    private final String rentPeriod;
    private final String colorScooter;
    private final String comment;

    public CreateNewRentalTest(String name, String surname, String address, String subwayStation, String phoneNumber,
                               String dateStartRent, String rentPeriod, String colorScooter, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.subwayStation = subwayStation;
        this.phoneNumber = phoneNumber;
        this.dateStartRent = dateStartRent;
        this.rentPeriod = rentPeriod;
        this.colorScooter = colorScooter;
        this.comment = comment;
    }

    @Parameterized.Parameters()
    public static Object[][] getTestDate() {
        return new Object[][]{
                {"Илья", "Ильин", "Тверская ул., дом 1", "Тверская", "+79263173171", WebTestUtils.getDateForTest(0), "сутки", "чёрный жемчуг", "Оставьте себе)))"},
                {"Илюха", "Ильин", "Тверская ул., дом 2", "Театральная", "+79263173171", WebTestUtils.getDateForTest(10), "3 суток", "серая безысходность", "Оставить у двери и убежать"}
        };
    }

    // Проверяем позитивный сценарий заказа.
    // При проверке через Chrome возникнет ошибка, так как не появляется окно с подтверждением заказа
    @Test
    public void createNewRental() {
        // Проверяем возможность перехода к форме заказа через нижнюю кнопку "Заказать"
        Assert.assertTrue(new HomePage(driver)
                .btnRentScooterButtonClick()
                .isPageHeader());

        // Возвращаемся на главную страницу и заполняем заказ через верхнюю кнопку
        Assert.assertTrue(new HomePage(driver)
                .goToScooterHomePage()
                .btnRentScooterTopClick()
                .addCustomerInfo(name, surname, address, subwayStation, phoneNumber)
                .addRentInfo(dateStartRent, rentPeriod, colorScooter, comment)
                .btnConfirmNewRentClick()
                .isPageRentConfirmed());
    }
}