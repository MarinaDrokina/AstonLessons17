import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeBrowserTest {

    public static WebDriver driver;
    public static OnlinePaymentPage onlinePaymentPage;

    @BeforeAll
    public static void setupAll() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(ConfigProperties.getProperty("onlinepaymentpage"));
    }

    @BeforeEach
    public void setupForEach() {
        onlinePaymentPage = new OnlinePaymentPage(driver);
        onlinePaymentPage.clickCancelCookieIfVisible();
    }

    @Test
    public void OnlinePay() {
        onlinePaymentPage.checkText();
        onlinePaymentPage.checkLogo();
        onlinePaymentPage.clickEntryMenu();
        onlinePaymentPage.selectValue();
        onlinePaymentPage.inputPhoneNum(ConfigProperties.getProperty("phoneNum"));
        onlinePaymentPage.inputSum(ConfigProperties.getProperty("sum"));
        onlinePaymentPage.inputEmail(ConfigProperties.getProperty("email"));
        onlinePaymentPage.clickContinueBtn();
        onlinePaymentPage.checkLink();
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
