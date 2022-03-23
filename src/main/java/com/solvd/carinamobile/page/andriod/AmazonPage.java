package com.solvd.carinamobile.page.andriod;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carinamobile.page.common.AmazonPageBase;
import com.solvd.carinamobile.page.common.ProductListResultPageBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AmazonPageBase.class)
public class AmazonPage extends AmazonPageBase {

    @FindBy(xpath = "//input[@class='nav-input nav-progressive-attribute']")
    private ExtendedWebElement searchField;

    @FindBy(xpath = "//div[@id='nav-gwbar']/a[text()='Best Sellers']")
    private ExtendedWebElement bestSellersButton;

    @FindBy(xpath = "//div[@class='_p13n-zg-nav-tree-all_style_zg-browse-item__1rdKf _p13n-zg-nav-tree-all_style_zg-browse-height-large__1z5B8']/a[text()='Books']")
    private ExtendedWebElement booksButton;

    @FindBy(xpath = "//a[@id='nav-hamburger-menu']")
    private ExtendedWebElement menuButton;

    @FindBy(xpath = "//li/a[text()='Health & Household']")
    private ExtendedWebElement healthAndHouseholdButton;

    @FindBy(xpath = "(//a[@class='nav-a '])[11]")
    private ExtendedWebElement customerServiceButton;

    @FindBy(xpath = "//a[@class='nav-a nav-progressive-attribute']")
    private ExtendedWebElement signInButton;

    @FindBy(xpath = "//input[@id='ap_email_login']")
    private ExtendedWebElement emailField;

    @FindBy(xpath = "//h4[text()='No account found with email address']")
    private ExtendedWebElement incorrectEmailText;

    @FindBy(xpath = "//input[@id='ap_password']")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//*[@id='auth-error-message-box']//span")
    private ExtendedWebElement incorrectPasswordText;

    public AmazonPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isSearchFieldVisible() {
        return searchField.isVisible();
    }

    @Override
    public void clickOnSearchField() {
        searchField.click(10);
    }

    @Override
    public ProductListResultPageBase typeProductName(String productName) {
        searchField.type(productName);
        searchField.sendKeys(Keys.ENTER);
        return initPage(getDriver(), ProductListResultPageBase.class);
    }

    @Override
    public boolean isBestSellersButtonVisible() {
        return bestSellersButton.isVisible();
    }

    @Override
    public void clickOnBestSellersButton() {
        bestSellersButton.click(10);
    }

    @Override
    public boolean isBooksButtonVisible() {
        return booksButton.isVisible();
    }

    @Override
    public ProductListResultPageBase clickOnBooksButton() {
        booksButton.click(5);
        return initPage(getDriver(), ProductListResultPageBase.class);
    }

    @Override
    public boolean isMenuButtonVisible() {
        return menuButton.isVisible();
    }

    @Override
    public void clickOnMenuButton() {
        menuButton.click(5);
    }

    @Override
    public boolean isHealthAndHouseholdButtonVisible() {
        return healthAndHouseholdButton.isVisible();
    }

    @Override
    public ProductListResultPageBase clickOnHealthAndHouseholdButton() {
        healthAndHouseholdButton.click(5);
        return initPage(getDriver(), ProductListResultPageBase.class);
    }

    @Override
    public boolean isCustomerServiceButtonVisible() {
        return customerServiceButton.isVisible();
    }

    @Override
    public ProductListResultPageBase clickOnCustomerServiceButton() {
        customerServiceButton.click(10);
        return initPage(getDriver(), ProductListResultPageBase.class);
    }

    @Override
    public boolean isSignInButtonVisible() {
        return signInButton.isVisible();
    }

    @Override
    public void clickOnSignInButton() {
        signInButton.click(10);
    }

    @Override
    public boolean isEmailFieldVisible() {
        return emailField.isVisible();
    }

    @Override
    public void typeEmail(String email) {
        emailField.type(email + Keys.ENTER);
    }

    @Override
    public String getIncorrectEmailText() {
        return incorrectEmailText.getText();
    }

    @Override
    public boolean isPasswordFieldVisible() {
        return passwordField.isVisible(10);
    }

    @Override
    public void typePassword(String password) {
        passwordField.type(password + Keys.ENTER);
    }

    @Override
    public String getIncorrectPasswordText() {
        return incorrectPasswordText.getText();
    }

}
