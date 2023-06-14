package tests;

import config.TestConfig;
import org.junit.Assert;
import org.junit.Test;
import pages.HomePage;
import utils.BaseTest;

public class CheckIncorrectOrderTest extends BaseTest {
    // Тест проверяет, что при вводе неверного номера заказа появится страница с сообщением "Такого заказа нет"
    @Test
    public void checkIncorrectOrder() {
        Assert.assertTrue(new HomePage(driver)
                .btnSwitchToCheckRentStatusClick()
                .setOrderNum(TestConfig.INCORRECT_ORDER_NUMBER.toString())
                .btnCheckRentStatus()
                .isTrackNoFound());
    }
}
