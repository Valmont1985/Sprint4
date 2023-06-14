package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class WebTestUtils {
    public static void scrollTo(WebDriver driver, By component) {
        WebElement element = driver.findElement(component);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    public static void waitElement(WebDriver webDriver, By element) {
        new WebDriverWait(webDriver, 5).until(driver -> (driver.findElement(element).isDisplayed()));
    }
    // Получаем строку с датой которая смещена от текущей на заданное количество дней
    public static String getDateForTest(int offsetDays) {
        String ResDate;
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_YEAR, -offsetDays);
        Date before = cal.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        ResDate = formatter.format(before);
        return ResDate;
    }
    // Подставляет параметр в xpath
    public static By xPathFormater(By xPatch, String tag) {
        return By.xpath(String.format(xPatch.toString().replaceFirst("By.xpath: ", ""), tag));
    }
}
