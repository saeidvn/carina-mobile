package com.solvd.carinamobile.page.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class TrackGoHomePageBase extends AbstractPage {

    public TrackGoHomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickOnMenuButton();

    public abstract void clickOnLoginWithEmailButton();

    public abstract boolean isEmailFieldVisible();

    public abstract void typeValidEmail(String email);

    public abstract void typeValidPassword(String password);

    public abstract void clickOnSignInButton();

    public abstract void clickOnSettingsButton();

    public abstract void clickOnDarkThemeButton();

    public abstract void clickOnChangeThemeButton();

    public abstract void clickOnEuroRadioButton();
}
