import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.OnlinePaymentPage;
import utils.ConfigProperties;

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
    }

    @BeforeEach
    public void setupForEach() {
        WebDriverManager.chromedriver().setup();
        driver.get(ConfigProperties.getProperty("onlinepaymentpage"));
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
        onlinePaymentPage.switchToIFraimPayment();
        onlinePaymentPage.checkClickBtn();
    }

    @Test
    public void verifyPayDescriptionText() {
        onlinePaymentPage.oneClick();
        onlinePaymentPage.checkPayDescriptionText();
    }

    @Test
    public void verifyPayDescriptionButton() {
        onlinePaymentPage.oneClick();
        onlinePaymentPage.checkPayDescriptionButton();
    }

    @Test
    public void verifyPayDescriptionPhoneNum() {
        onlinePaymentPage.oneClick();
        onlinePaymentPage.checkPayDescriptionPhoneNum();
    }

    @Test
    public void verifyPayDescriptionIcons() {
        onlinePaymentPage.oneClick();
        onlinePaymentPage.checkPayDescriptionIcons();
    }

    @Test
    public void verifyPayDescriptionCardFieldText() {
        onlinePaymentPage.oneClick();
        onlinePaymentPage.checkPayDescriptionCardFieldText();
    }

    @Test
    public void checkLinkPage() {
        onlinePaymentPage.checkLink();
        Assertions.assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", driver.getCurrentUrl());
    }

    @Test
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