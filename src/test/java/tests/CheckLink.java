package tests;
// Возможность перехода на главную страницу Яндекс Дзена и Яндекс Самоката

import org.junit.Assert;
import org.junit.Test;
import pages.HomePage;
import utils.BaseTest;

public class CheckLink extends BaseTest {
    // Тестируем переход на страницу Яндекс Дзен
    @Test
    public void testGoToYandex() {
        Assert.assertTrue(new HomePage(driver)
                .goToYandexHomePageClick()
                .isYandexPageOpen());
    }
    // Тестируем переход на главную страницу Яндекс Самоката.
    @Test
    public void testGoToScooterServiceHomePage() {
        Assert.assertTrue(new HomePage(driver)
                .btnRentScooterTopClick() // Переходим на страницу с заказом
                .goToScooterHomePage()
                .getScooterHomePageWelcomeText()); // Проверяем, текст на главной странице появился.
    }
}
