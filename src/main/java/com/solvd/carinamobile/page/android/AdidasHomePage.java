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

    @FindBy(xpath = "//a[@class='src-components-___header__wishlistLinkMobile___1FDKv']")
    private ExtendedWebElement wishListButton;

    @FindBy(xpath = "//div[@class='row keywords___3OtDK']/a[@class='gl-filter keyword___1pfOO uppercased___1YiBt'][1]")
    private ExtendedWebElement popularRightNow;

    @FindBy(xpath = "(//div[@class='plp-product-card__wishlist-button___qAqKB toggle_wishlist_button___my-ER  '])[%s]")
    private ExtendedWebElement addToWishlistButton;

    public AdidasHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HelpPageBase clickOnHelpButton() {
        helpButton.click(20);
        return initPage(getDriver(), HelpPageBase.class);
    }

    @Override
    public boolean isPageOpened() {
        return helpButton.isElementPresent();
    }

    @Override
    public void clickOnProfileButton() {
        profileButton.clickIfPresent(20);
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
        loginButton.click(20);
    }

    @Override
    public MyAccountPageBase clickOnVisitYourAccountButton() {
        visitYourAccountButton.click();
        return initPage(getDriver(), MyAccountPageBase.class);
    }

    @Override
    public void clickOnSearchButton() {
        searchButton.click(20);
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
    public boolean isProfileButtonPresent() {
        return profileButton.isPresent();
    }

    @Override
    public boolean isVisitYourAccountPresent() {
        return visitYourAccountButton.isPresent();
    }

    @Override
    public boolean isEmailFieldPresent() {
        return emailField.isPresent();
    }

    @Override
    public boolean isContinueButtonVisible() {
        return continueButton.isVisible(20);
    }

    @Override
    public boolean isPasswordFieldPresent() {
        return passwordField.isPresent(20);
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
    public boolean isSearchFieldPresent() {
        return searchField.isPresent();
    }

    @Override
    public boolean isPopularProductPresent() {
        return popularRightNow.isPresent();
    }

    @Override
    public WishlistPageBase clickOnWishListButton() {
        wishListButton.click(20);
        return initPage(getDriver(), WishlistPageBase.class);
    }

    @Override
    public void clickOnFirstPopularProduct() {
        popularRightNow.click();
    }

    @Override
    public void scrollDownPage() {
        swipe(footerContainer);
    }

    @Override
    public void addProductToWishList (int indexOfProduct) {
        addToWishlistButton.format(indexOfProduct).click();
    }

}
