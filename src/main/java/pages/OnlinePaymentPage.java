package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigProperties;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.not;

public class OnlinePaymentPage {

    private static WebDriver driver;
    private static WebDriverWait wait;

    public OnlinePaymentPage(WebDriver browserDriver) {
        driver = browserDriver;
        PageFactory.initElements(browserDriver, this);
        wait = new WebDriverWait(browserDriver, Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//*[@class='pay__wrapper']")
    public WebElement element;

    @FindBy(xpath = "//section[@class='pay']//h2")
    private WebElement textOnlinePay;

    @FindBy(xpath = "//*[@alt='Visa']")
    private WebElement iconVisa;

    @FindBy(xpath = "//*[@alt='Verified By Visa']")
    private WebElement iconVerifiedVisa;

    @FindBy(xpath = "//section//*[@alt='MasterCard']")
    private WebElement iconMasterCard;

    @FindBy(xpath = "//section//*[@alt='MasterCard Secure Code']")
    private WebElement iconMasterCardSecure;

    @FindBy(xpath = "//section//*[@alt='Белкарт']")
    private WebElement iconBelcart;

    @FindBy(xpath = "//*[.='Подробнее о сервисе']")
    private WebElement linkDetailOfService;

    @FindBy(xpath = "//span[.='Услуги связи']")
    private WebElement uslugiSvzBtn;

    @FindBy(xpath = "//p[.='Услуги связи']")
    private WebElement uslugiSvzValue;

    @FindBy(id = "connection-phone")
    private WebElement phoneNumField;

    @FindBy(id = "connection-sum")
    private WebElement sumField;

    @FindBy(id = "connection-email")
    private WebElement emailField;

    @FindBy(xpath = "//*[@id='pay-connection']//button[@type='submit']")
    private WebElement continuePayConnection;

    @FindBy(xpath = "//button[.='Отклонить']")
    private WebElement cancelCookie;

    @FindBy(xpath = "//span[.='Домашний интернет']")
    private WebElement homeInternetBtn;

    @FindBy(xpath = "//p[.='Домашний интернет']")
    private WebElement homeInternetValue;

    @FindBy(id = "internet-phone")
    private WebElement subscriberNumField;

    @FindBy(id = "internet-sum")
    private WebElement internetSumField;

    @FindBy(id = "internet-email")
    private WebElement internetEmailField;

    @FindBy(xpath = "//p[.='Рассрочка']/..")
    private WebElement instalmentValue;

    @FindBy(id = "score-instalment")
    private WebElement accountNumOn44Field;

    @FindBy(id = "instalment-sum")
    private WebElement instalmentSumField;

    @FindBy(id = "instalment-email")
    private WebElement instalmentEmailField;

    @FindBy(xpath = "//p[.='Задолженность']")
    private WebElement arrearValue;

    @FindBy(xpath = "//span[.='Рассрочка']")
    private WebElement instalmentBtn;

    @FindBy(id = "score-arrears")
    private WebElement scoreArrearsField;

    @FindBy(id = "arrears-sum")
    private WebElement arrearsSumField;

    @FindBy(id = "arrears-email")
    private WebElement arrearEmailField;

    @FindBy(xpath = "//*[@class='bepaid-iframe']")
    private WebElement bepaidIframe;

    @FindBy(xpath = "//*[@class='pay-description__cost']/span")
    private WebElement payDescriptionText;

    @FindBy(xpath = "//*[@class='card-page__card']//button")
    private WebElement payDescriptionButton;

    @FindBy(xpath = "//*[@class='pay-description__text']/span")
    private WebElement payDescriptionPhoneNum;

    @FindBy(xpath = "//app-input//*[contains(@src,'visa-system')]")
    private WebElement payDescriptionIconsVisa;

    @FindBy(xpath = "//app-input//*[contains(@src,'mastercard-system')]")
    private WebElement payDescriptionIconsMastercard;

    @FindBy(xpath = "//app-input//*[contains(@src,'belkart-system')]")
    private WebElement payDescriptionIconsBelkart;

    @FindBy(xpath = "//app-input//*[contains(@src,'maestro-system')]")
    private WebElement payDescriptionIconsMaestro;

    @FindBy(xpath = "//app-input//*[contains(@src,'mir-system')]")
    private WebElement payDescriptionIconsMir;

    @FindBy(xpath = "//*[@id='cc-number']/following-sibling::label")
    private WebElement payDescriptionCardNum;

    @FindBy(xpath = "//*[@name='verification_value']/following-sibling::label")
    private WebElement payDescriptionCardVerificationValue;

    @FindBy(xpath = "//*[@formcontrolname='expirationDate']/following-sibling::label")
    private WebElement payDescriptionCardExpirationDate;

    @FindBy(xpath = "//*[@formcontrolname='holder']/following-sibling::label")
    private WebElement payDescriptionCardHolder;

    public void clickCancelCookieIfVisible() {
        WebDriverWait waitCookie = new WebDriverWait(driver, Duration.ofSeconds(3));
        try {
            waitCookie.until(ExpectedConditions.visibilityOf(cancelCookie));
            cancelCookie.click();
        } catch (TimeoutException ignored) {
        }
    }

    public void clickEntryMenu() {
        wait.until(ExpectedConditions.visibilityOf(uslugiSvzBtn));
        uslugiSvzBtn.click();
    }

    public void checkText() {
        wait.until(ExpectedConditions.textToBePresentInElement(textOnlinePay, "Онлайн пополнение\nбез комиссии"));
    }

    public void checkLogo() {
        wait.until(ExpectedConditions.visibilityOf(iconVisa));
        wait.until(ExpectedConditions.visibilityOf(iconVerifiedVisa));
        wait.until(ExpectedConditions.visibilityOf(iconMasterCard));
        wait.until(ExpectedConditions.visibilityOf(iconMasterCardSecure));
        wait.until(ExpectedConditions.visibilityOf(iconBelcart));
    }

    public void checkLink() {
        linkDetailOfService.click();
    }

    public void selectValue() {
        wait.until(ExpectedConditions.visibilityOf(uslugiSvzValue));
        uslugiSvzValue.click();
    }

    public void inputPhoneNum(String phoneNum) {
        wait.until(ExpectedConditions.visibilityOf(phoneNumField));
        phoneNumField.sendKeys(phoneNum);
    }

    public void inputSum(String sum) {
        sumField.sendKeys(sum);
    }

    public void inputEmail(String email) {
        emailField.sendKeys(email);
    }

    public void clickContinueBtn() {
        continuePayConnection.click();
    }

    public void checkClickBtn() {
        wait.until(ExpectedConditions.visibilityOf(payDescriptionIconsVisa));
    }

    public void checkPlholderUslgSvz() {
        wait.until(ExpectedConditions.visibilityOf(continuePayConnection));
        continuePayConnection.sendKeys("");
        wait.until(ExpectedConditions.elementToBeClickable(uslugiSvzBtn));
        uslugiSvzBtn.click();
        wait.until(ExpectedConditions.elementToBeClickable(uslugiSvzValue));
        uslugiSvzValue.click();
        wait.until(not(ExpectedConditions.visibilityOf(uslugiSvzValue)));
        wait.until(ExpectedConditions.attributeContains(phoneNumField, "placeholder", "Номер телефона"));
        wait.until(ExpectedConditions.attributeContains(sumField, "placeholder", "Сумма"));
        wait.until(ExpectedConditions.attributeContains(emailField, "placeholder", "E-mail для отправки чека"));
    }

    public void checkPlholderHomeInternet() {
        uslugiSvzBtn.click();
        wait.until(ExpectedConditions.elementToBeClickable(homeInternetValue));
        homeInternetValue.click();
        wait.until(not(ExpectedConditions.visibilityOf(homeInternetValue)));
        wait.until(ExpectedConditions.visibilityOf(subscriberNumField));
        wait.until(ExpectedConditions.attributeContains(subscriberNumField, "placeholder", "Номер абонента"));
        wait.until(ExpectedConditions.attributeContains(internetSumField, "placeholder", "Сумма"));
        wait.until(ExpectedConditions.attributeContains(internetEmailField, "placeholder", "E-mail для отправки чека"));
    }

    public void checkPlaceholderInstalmentPay() {
        homeInternetBtn.click();
        wait.until(ExpectedConditions.elementToBeClickable(instalmentValue));
        instalmentValue.click();
        wait.until(not(ExpectedConditions.visibilityOf(instalmentValue)));
        wait.until(ExpectedConditions.visibilityOf(accountNumOn44Field));
        wait.until(ExpectedConditions.attributeContains(accountNumOn44Field, "placeholder", "Номер счета на 44"));
        wait.until(ExpectedConditions.attributeContains(instalmentSumField, "placeholder", "Сумма"));
        wait.until(ExpectedConditions.attributeContains(instalmentEmailField, "placeholder", "E-mail для отправки чека"));
    }

    public void checkPlaceholderAppear() {
        instalmentBtn.click();
        wait.until(ExpectedConditions.elementToBeClickable(arrearValue));
        arrearValue.click();
        wait.until(ExpectedConditions.visibilityOf(scoreArrearsField));
        wait.until(ExpectedConditions.attributeContains(scoreArrearsField, "placeholder", "Номер счета на 2073"));
        wait.until(ExpectedConditions.attributeContains(arrearsSumField, "placeholder", "Сумма"));
        wait.until(ExpectedConditions.attributeContains(arrearEmailField, "placeholder", "E-mail для отправки чека"));
    }

    public void switchToIFraimPayment() {
        wait.until(ExpectedConditions.visibilityOf(bepaidIframe));
        driver.switchTo().frame(bepaidIframe);
    }

    public void checkPayDescriptionText() {
        wait.until(ExpectedConditions.textToBePresentInElement(payDescriptionText, ConfigProperties.getProperty("sum")));
    }

    public void checkPayDescriptionButton() {
        wait.until(ExpectedConditions.textToBePresentInElement(payDescriptionButton, ConfigProperties.getProperty("sum")));
    }

    public void checkPayDescriptionPhoneNum() {
        wait.until(ExpectedConditions.textToBePresentInElement(payDescriptionPhoneNum, ConfigProperties.getProperty("phoneNum")));
    }

    public void checkPayDescriptionIcons() {
        wait.until(ExpectedConditions.visibilityOf(payDescriptionIconsVisa));
        wait.until(ExpectedConditions.visibilityOf(payDescriptionIconsMastercard));
        wait.until(ExpectedConditions.visibilityOf(payDescriptionIconsBelkart));
        wait.until(ExpectedConditions.visibilityOf(payDescriptionIconsMaestro));
        wait.until(ExpectedConditions.visibilityOf(payDescriptionIconsMir));
    }

    public void checkPayDescriptionCardFieldText() {
        wait.until(ExpectedConditions.textToBePresentInElement(payDescriptionCardNum, "Номер карты"));
        wait.until(ExpectedConditions.textToBePresentInElement(payDescriptionCardVerificationValue, "CVC"));
        wait.until(ExpectedConditions.textToBePresentInElement(payDescriptionCardExpirationDate, "Срок действия"));
        wait.until(ExpectedConditions.textToBePresentInElement(payDescriptionCardHolder, "Имя держателя (как на карте)"));
    }

    public void oneClick() {
        clickEntryMenu();
        selectValue();
        inputPhoneNum(ConfigProperties.getProperty("phoneNum"));
        inputSum(ConfigProperties.getProperty("sum"));
        inputEmail(ConfigProperties.getProperty("email"));
        clickContinueBtn();
        switchToIFraimPayment();
    }
}