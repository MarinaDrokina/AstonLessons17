import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.OnlinePaymentPage;

public class ChromeBrowserTest {

    public static WebDriver driver;
    public static OnlinePaymentPage onlinePaymentPage;

    @BeforeAll
    public static void setupAll() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(ConfigProperties.getProperty("onlinepaymentpage"));
    }

    @BeforeEach
    public void setupForEach() {
        WebDriverManager.chromedriver().setup();
        onlinePaymentPage = new OnlinePaymentPage(driver);
        onlinePaymentPage.clickCancelCookieIfVisible();
    }

    @Test
    public void verifySubtitle() {
        onlinePaymentPage.checkText();
    }

    @Test
    public void verifyLogo() {
        onlinePaymentPage.checkLogo();
    }

    @Test
    public void onlinePay() {
        onlinePaymentPage.clickEntryMenu();
        onlinePaymentPage.selectValue();
        onlinePaymentPage.inputPhoneNum(ConfigProperties.getProperty("phoneNum"));
        onlinePaymentPage.inputSum(ConfigProperties.getProperty("sum"));
        onlinePaymentPage.inputEmail(ConfigProperties.getProperty("email"));
        onlinePaymentPage.clickContinueBtn();
    }

    @Test
    public void verifyLink() {
        onlinePaymentPage.checkLink();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
