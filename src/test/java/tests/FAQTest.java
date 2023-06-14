package tests;
// Тест проверяет наличие верных вопросов с FAQ и ответы на них.

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.NoSuchElementException;
import pages.HomePage;
import utils.BaseTest;
import java.util.logging.Logger;
import io.github.bonigarcia.wdm.WebDriverManager;

@RunWith(Parameterized.class)
public class FAQTest extends BaseTest {
    private static final Logger LOGGER = Logger.getLogger(FAQTest.class.getName());
    private final String question;
    private final String answer;
    public FAQTest(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }
    @Parameterized.Parameters(name = "Проверка ответа на вопрос. Тестовые данные: {0} {1}")
    public static Object[][] getTestParam() {
        return new Object[][]{
                {"Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {"Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {"Как рассчитывается время аренды?", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {"Можно ли заказать самокат прямо на сегодня?", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {"Можно ли продлить заказ или вернуть самокат раньше?", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {"Вы привозите зарядку вместе с самокатом?", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {"Можно ли отменить заказ?", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {"Я живу за МКАДом, привезёте?", "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }
    //В последней паре опечатка на сайте, вероятно это баг
    @Test()
    public void faqTest() {
        try {
            new HomePage(driver)
                    .faqQuestionAnswerCheck(question, answer);
        } catch (NoSuchElementException e) {
            LOGGER.severe("Не найден искомый вопрос- " + question);
            LOGGER.severe("Или корректный ответ на него- " + answer);
            Assert.fail();
        }
    }
}
