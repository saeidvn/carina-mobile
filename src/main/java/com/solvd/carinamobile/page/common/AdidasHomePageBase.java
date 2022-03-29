package com.solvd.carinamobile.page.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class AdidasHomePageBase extends AbstractPage {

    public AdidasHomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract HelpPageBase clickOnHelpButton();

    public abstract void clickOnProfileButton();

    public abstract void typeEmail(String email);

    public abstract void clickOnContinueButton();

    public abstract void typePassword(String password);

    public abstract void clickOnLoginButton();

    public abstract MyAccountPageBase clickOnVisitYourAccountButton();

    public abstract boolean isSearchButtonVisible();

    public abstract void clickOnSearchButton();

    public abstract SearchBlockPageBase typeSpecialCharacter(String specialCharacter);

    public abstract SearchBlockPageBase searchProduct(String productName);

    public abstract boolean isProfileButtonVisible();

    public abstract boolean isVisitYourAccountVisible();

    public abstract boolean isEmailFieldVisible();

    public abstract boolean isContinueButtonVisible();

    public abstract boolean isPasswordFieldVisible();

    public abstract boolean isLoginButtonVisible();

    public abstract boolean isSearchFieldVisible();

    public abstract void scrollDownPage();

}