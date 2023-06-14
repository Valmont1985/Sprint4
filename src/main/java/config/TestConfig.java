package config;


public class TestConfig {
    // Переменная для браузера в котором будет происходить тестирование
    public static final TargetBrowserEnum TARGET_BROWSER = TargetBrowserEnum.CHROME;
    //public static final TargetBrowserEnum TARGET_BROWSER = TargetBrowserEnum.FIREFOX;
    // Таймаут WEB драйвера
    public static final Integer IMPLICIT_WAIT_SECONDS = 10;
    // Номер не существующего заказа
    public static final Integer INCORRECT_ORDER_NUMBER = 42;
}
