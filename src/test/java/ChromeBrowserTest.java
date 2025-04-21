import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
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
    }

    @BeforeEach
    public void setupForEach() {
        driver.get(ConfigProperties.getProperty("onlinepaymentpage"));
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
        onlinePaymentPage.switchToIFraimPayment();
        onlinePaymentPage.checkPayDescriptionText();
        onlinePaymentPage.checkPayDescriptionButton();
        onlinePaymentPage.checkPayDescriptionPhoneNum();
        onlinePaymentPage.checkPayDescriptionIcons();
        onlinePaymentPage.checkPayDescriptionCardFieldText();
    }

    @Test
    public void checkLinkPage() {
        onlinePaymentPage.checkLink();
        driver.navigate().back();
    }

    @Test
    public void checkPlaceholderText() {
        onlinePaymentPage.checkPlholderUslgSvz();
        onlinePaymentPage.checkPlholderHomeInternet();
        onlinePaymentPage.checkPlholderInstalmentPay();
        onlinePaymentPage.checkPlaceholderAppear();
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}