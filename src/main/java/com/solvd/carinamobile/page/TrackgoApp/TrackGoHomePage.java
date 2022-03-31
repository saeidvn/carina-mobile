package com.solvd.carinamobile.page.TrackgoApp;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carinamobile.page.common.TrackGoHomePageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = TrackGoHomePageBase.class)
public class TrackGoHomePage extends TrackGoHomePageBase implements IMobileUtils {

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]")
    private ExtendedWebElement hamburgerMenuButton;

    @FindBy(xpath = "//android.view.View[@content-desc='Log in with email']")
    private ExtendedWebElement loginButton;

//    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.EditText[1]")
    @FindBy(className = "android.widget.EditText")
    private ExtendedWebElement emailField;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.EditText[2]")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "")
    private ExtendedWebElement goButton;

    @FindBy(xpath = "//android.widget.Button[@content-desc='Sign in']")
    private ExtendedWebElement signInButton;

    @FindBy(xpath = "//android.view.View[@content-desc='Settings']")
    private ExtendedWebElement settingsButton;

    @FindBy(xpath = "//android.view.View[@content-desc='Dark theme']")
    private ExtendedWebElement darkThemeButton;

    @FindBy(xpath = "(//android.view.View[@content-desc='Dark theme'])[2]/android.widget.Switch")
    private ExtendedWebElement changeThemeButton;

    @FindBy(xpath = "//android.view.View[@content-desc='Currency Choose currency for added products']")
    private ExtendedWebElement currencyButton;

    @FindBy(xpath = "//android.view.View[@content-desc='Euro']/android.widget.RadioButton")
    private ExtendedWebElement euroRadioButton;

    public TrackGoHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickOnMenuButton() {
        hamburgerMenuButton.click();
    }

    @Override
    public void clickOnLoginWithEmailButton() {
        loginButton.click();
    }

    @Override
    public boolean isEmailFieldVisible() {
        return emailField.isVisible();
    }

    @Override
    public void typeValidEmail(String email) {
        emailField.type(email);
    }

    @Override
    public void typeValidPassword(String password) {
        passwordField.type(password);
        hideKeyboard();
    }

    @Override
    public void clickOnSignInButton() {
        signInButton.click();
    }

    @Override
    public void clickOnSettingsButton() {
        settingsButton.click();
    }

    @Override
    public void clickOnDarkThemeButton() {
        darkThemeButton.click();
    }

    @Override
    public void clickOnChangeThemeButton() {
        changeThemeButton.click();
    }

    @Override
    public void clickOnEuroRadioButton() {
        euroRadioButton.click();
    }



}
