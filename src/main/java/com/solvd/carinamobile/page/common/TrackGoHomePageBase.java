package com.solvd.carinamobile.page.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class TrackGoHomePageBase extends AbstractPage {

    public TrackGoHomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isHamburgerMenuButtonPresent();

    public abstract void clickOnMenuButton();

    public abstract boolean isLoginWithEmailButtonPresent();

    public abstract LoginPageBase clickOnLoginWithEmailButton();

    public abstract boolean isExitButtonPresent();

    public abstract void clickOnExitButton();

    public abstract boolean isSettingsButtonPresent();

    public abstract SettingsBlockPageBase clickOnSettingsButton();

    public abstract List<String> getFieldsOnMenuBar();

    public abstract boolean isMenuBarFieldsEmpty();

    public abstract String getTrackgoVersion();

    public abstract boolean isGoodsButtonPresent();

    public abstract GoodsPageBase clickOnGoodsButton();

    public abstract boolean isPricesButtonPresent();

    public abstract PricesPageBase clickOnPricesButton();
}
