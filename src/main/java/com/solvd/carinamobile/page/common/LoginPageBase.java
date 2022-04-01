package com.solvd.carinamobile.page.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends AbstractPage {

    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isEmailFieldPresent();

    public abstract boolean isPasswordFieldPresent();

    public abstract void logIn(String email, String password);

    public abstract void typeEmail(String email);

    public abstract void typePassword(String password);

    public abstract boolean isSignInButtonPresent();

    public abstract void clickOnSignInButton();

    public abstract boolean isLoginErrorVisible();

    public abstract String getLoginErrorText();
}
