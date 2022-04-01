package com.solvd.carinamobile.page.TrackgoApp;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carinamobile.page.common.LoginPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPageBase.class)

public class LoginPage extends LoginPageBase implements IMobileUtils {

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.EditText[1]")
    private ExtendedWebElement emailField;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.EditText[2]")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//android.widget.Button[@content-desc='Sign in']")
    private ExtendedWebElement signInButton;

    @FindBy(xpath = "//android.view.View[@content-desc='Неверный email или пароль.']")
    private ExtendedWebElement loginErrorText;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isEmailFieldPresent() {
        return emailField.isPresent();
    }

    @Override
    public boolean isPasswordFieldPresent() {
        return passwordField.isPresent();
    }

    @Override
    public void logIn(String email, String password) {
        typeEmail(email);
        typePassword(password);
    }

    @Override
    public void typeEmail(String email) {
        emailField.type(email);
    }

    @Override
    public void typePassword(String password) {
        passwordField.type(password);
        hideKeyboard();
    }

    @Override
    public boolean isSignInButtonPresent() {
        return signInButton.isPresent();
    }

    @Override
    public void clickOnSignInButton() {
        signInButton.click();
    }

    @Override
    public boolean isLoginErrorVisible() {
        return loginErrorText.isVisible();
    }

    @Override
    public String getLoginErrorText() {
        return loginErrorText.getText();
    }
}
