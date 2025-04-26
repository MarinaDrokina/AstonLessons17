package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OnlinePaymentPage {

    private static WebDriver driver;
    private static WebDriverWait wait;

    public OnlinePaymentPage(WebDriver browserDriver) {
        driver = browserDriver;
        PageFactory.initElements(browserDriver, this);
        wait = new WebDriverWait(browserDriver, Duration.ofSeconds(10));
    }

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
    private WebElement continueBtn;

    @FindBy(xpath = "//button[.='Отклонить']")
    private WebElement cancelCookie;

    @FindBy(xpath = "//*[@class='bepaid-iframe']")
    private WebElement bePaidIframe;

    @FindBy(xpath = "//*[contains(text(),'Оплата банковской картой')]")
    private WebElement payBankCard;

    @FindBy(xpath = "//app-input//*[contains(@src,'visa-system')]")
    private WebElement payDescriptionIconsVisa;

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
        Assertions.assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", driver.getCurrentUrl());
        wait.until(ExpectedConditions.visibilityOf(payBankCard));
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
        wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
        continueBtn.click();
        wait.until(ExpectedConditions.visibilityOf(bePaidIframe));
        driver.switchTo().frame(bePaidIframe);
        wait.until(ExpectedConditions.visibilityOf(payDescriptionIconsVisa));
    }
}