import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import org.junit.jupiter.api.*;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.OnlinePaymentPage;
import utils.ConfigProperties;

@Feature("Тесты для проверки элементов блока 'Онлайн пополнение без комиссии'")
public class ChromeBrowserTest {

    public static WebDriver driver;
    public static OnlinePaymentPage onlinePaymentPage;

    @BeforeEach
    public void setupForEach() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        WebDriverManager.chromedriver().setup();
        driver.get(ConfigProperties.getProperty("onlinepaymentpage"));
        onlinePaymentPage = new OnlinePaymentPage(driver);
        onlinePaymentPage.clickCancelCookieIfVisible();
    }

    @Link(name = "МТС.Беларусь", url = "https://www.mts.by/")
    @Test
    @DisplayName("Проверка названия блока")
    @Description("Перейти на страницу,взять атрибуты элемента заголовка блока, сравнить с ожидаемым результатом")
    public void verifySubtitle() {
        onlinePaymentPage.checkText();
    }

    @Test
    @DisplayName("Проверка наличия логотипов платежных систем")
    @Description("Перейти на страницу,поочередно проверить атрибуты элементов логотипов блока, сравнить с ожидаемым результатом")
    public void verifyLogo() {
        onlinePaymentPage.checkLogo();
    }

    @Test
    @DisplayName("Проверки возможности заполнения полей блока и работы кнопки 'Продолжить'")
    @Description("Перейти на страницу, выбрать в выпадающем списке 'Услуги свзяи', запонить поля, нажать кнопку 'Продолжить', проверить работу кнопки, дождавшись появления нового окна")
    public void onlinePay() {
        onlinePaymentPage.clickEntryMenu();
        onlinePaymentPage.selectValue();
        onlinePaymentPage.inputPhoneNum(ConfigProperties.getProperty("phoneNum"));
        onlinePaymentPage.inputSum(ConfigProperties.getProperty("sum"));
        onlinePaymentPage.inputEmail(ConfigProperties.getProperty("email"));
        onlinePaymentPage.clickContinueBtn();
        onlinePaymentPage.switchToIFraimPayment();
        onlinePaymentPage.checkClickBtn();
    }

    @Test
    @DisplayName("Проверка корректности отображения введенной ранее суммы в заголовке формы")
    @Description("После заполнения полей в блоке 'Онлайн пополнение без комиссии' и перехода в новое окно, проверить отображемой суммы в заголовке")
    public void verifyPayDescriptionText() {
        onlinePaymentPage.oneClick();
        onlinePaymentPage.checkPayDescriptionText();
    }

    @Test
    @DisplayName("Проверка корректности отображения введенной ранее суммы на кнопке формы")
    @Description("После заполнения полей в блоке 'Онлайн пополнение без комиссии' и перехода в новое окно, проверить отображемой суммы на кнопке")
    public void verifyPayDescriptionButton() {
        onlinePaymentPage.oneClick();
        onlinePaymentPage.checkPayDescriptionButton();
    }

    @Test
    @DisplayName("Проверка корректности отображения введенного номера телефона формы")
    @Description("После заполнения полей в блоке 'Онлайн пополнение без комиссии' и перехода в новое окно, проверить совпадение отображемого номера телефона")
    public void verifyPayDescriptionPhoneNum() {
        onlinePaymentPage.oneClick();
        onlinePaymentPage.checkPayDescriptionPhoneNum();
    }

    @Test
    @DisplayName("Проверка наличия иконок платежных систем")
    @Description("После заполнения полей в блоке 'Онлайн пополнение без комиссии' и перехода в новое окно, проверить отображение иконок в окне")
    public void verifyPayDescriptionIcons() {
        onlinePaymentPage.oneClick();
        onlinePaymentPage.checkPayDescriptionIcons();
    }

    @Test
    @DisplayName("Проверка надписей в незаполненых полях в блоке ввода реквизитов карты")
    @Description("После заполнения полей в блоке 'Онлайн пополнение без комиссии' и перехода в новое окно, проверить надписи полей в форме ввода данных карты")
    public void verifyPayDescriptionCardFieldText() {
        onlinePaymentPage.oneClick();
        onlinePaymentPage.checkPayDescriptionCardFieldText();
    }

    @Test
    @DisplayName("Проверка работы ссылки 'Подробнее о сервисе'")
    @Description("Проерить переход на новую страницу по ссылке")
    public void checkLinkPage() {
        onlinePaymentPage.checkLink();
        Assertions.assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Проверка надписей в незаполненых полях блока для каждого варианта оплаты услуг")
    @Description("В блоке 'Онлайн пополнение без комиссии' поочередно проверять надписи в незаполненых полях для всех элементов выпадающего списка (а именно: Услуги связи, Домашний интернет, Рассрочка, Задолженность")
    public void checkPlaceholderText() {
        onlinePaymentPage.checkPlholderUslgSvz();
        onlinePaymentPage.checkPlholderHomeInternet();
        onlinePaymentPage.checkPlaceholderInstalmentPay();
        onlinePaymentPage.checkPlaceholderAppear();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}