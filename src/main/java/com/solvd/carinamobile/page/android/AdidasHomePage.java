package com.solvd.carinamobile.page.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carinamobile.page.common.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AdidasHomePageBase.class)
public class AdidasHomePage extends AdidasHomePageBase implements IMobileUtils {

    @FindBy(xpath = "//div[@class='footer-bottom___1H5NH']")
    private ExtendedWebElement footerContainer;

    @FindBy(xpath = "//span[text()='Help']")
    private ExtendedWebElement helpButton;

    @FindBy(xpath = "//*[@class='gl-icon profile_icon_image___zzdFx']")
    private ExtendedWebElement profileButton;

    @FindBy(xpath = "//input[@class='gl-input__field']")
    private ExtendedWebElement emailField;

    @FindBy(xpath = "//button[@aria-label='Continue']")
    private ExtendedWebElement continueButton;

    @FindBy(xpath = "//input[@class='gl-input__field']")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//button[@class='gl-cta gl-cta--primary gl-cta--full-width']")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//a[@class='gl-link gl-label--bold  link___1kK4C '][1]")
    private ExtendedWebElement visitYourAccountButton;

    @FindBy(xpath = "//input[@name='q']")
    private ExtendedWebElement searchField;

    @FindBy(xpath = "//button[@data-auto-id='mobile-search-icon']")
    private ExtendedWebElement searchButton;

    public AdidasHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HelpPageBase clickOnHelpButton() {
        helpButton.click();
        return initPage(getDriver(), HelpPageBase.class);
    }

    @Override
    public void clickOnProfileButton() {
        profileButton.click();
    }

    @Override
    public void typeEmail(String email) {
        emailField.type(email);
        hideKeyboard();
    }

    @Override
    public void clickOnContinueButton() {
        continueButton.click();
    }

    @Override
    public void typePassword(String password) {
        passwordField.type(password);
        hideKeyboard();
    }

    @Override
    public void clickOnLoginButton() {
        loginButton.click();
    }

    @Override
    public MyAccountPageBase clickOnVisitYourAccountButton() {
        visitYourAccountButton.click();
        return initPage(getDriver(), MyAccountPageBase.class);
    }

    @Override
    public void clickOnSearchButton() {
        searchButton.click();
    }

    @Override
    public SearchBlockPageBase typeSpecialCharacter(String specialCharacter) {
        searchField.type(specialCharacter + Keys.ENTER);
        return initPage(getDriver(), SearchBlockPageBase.class);
    }

    @Override
    public SearchBlockPageBase searchProduct(String productName) {
        searchField.type(productName);
        return initPage(getDriver(), SearchBlockPageBase.class);
    }

    @Override
    public boolean isProfileButtonVisible() {
        return profileButton.isVisible();
    }

    @Override
    public boolean isVisitYourAccountVisible() {
        return visitYourAccountButton.isVisible();
    }

    @Override
    public boolean isEmailFieldVisible() {
        return emailField.isVisible();
    }

    @Override
    public boolean isContinueButtonVisible() {
        return continueButton.isVisible();
    }

    @Override
    public boolean isPasswordFieldVisible() {
        return passwordField.isVisible();
    }

    @Override
    public boolean isLoginButtonVisible() {
        return loginButton.isVisible();
    }

    @Override
    public boolean isSearchButtonVisible() {
        return searchButton.isVisible();
    }

    @Override
    public boolean isSearchFieldVisible() {
        return searchField.isVisible();
    }

    @Override
    public void scrollDownPage() {
        swipe(footerContainer);
    }
}
