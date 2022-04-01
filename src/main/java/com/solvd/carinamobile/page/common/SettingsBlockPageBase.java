package com.solvd.carinamobile.page.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SettingsBlockPageBase extends AbstractPage {

    public SettingsBlockPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isDarkThemeButtonPresent();

    public abstract void clickOnDarkThemeButton();

    public abstract boolean isChangeThemeButtonPresent();

    public abstract void clickOnChangeThemeButton();

    public abstract boolean isCurrencyButtonPresent();

    public abstract void clickOnCurrencyButton();

    public abstract boolean isEuroRadioButtonPresent();

    public abstract void clickOnEuroRadioButton();

    public abstract boolean isRegionButtonPresent();

    public abstract void clickOnRegionButton();

    public abstract void clickOnRussianRadioButton();

    public abstract void clickOnTimeZonesButton();

    public abstract void clickOnMinskRadioButton();

    public abstract boolean isNotificationsButtonPresent();

    public abstract void clickOnNotificationsButton();

    public abstract boolean isNotificationCheckBoxPresent();

    public abstract void clickOnNotificationCheckBox();
}
