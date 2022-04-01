package com.solvd.carinamobile.page.TrackgoApp;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carinamobile.page.common.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = TrackGoHomePageBase.class)
public class TrackGoHomePage extends TrackGoHomePageBase implements IMobileUtils {

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]")
    private ExtendedWebElement hamburgerMenuButton;

    @FindBy(xpath = "//android.view.View[@content-desc='Log in with email']")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//android.view.View[@content-desc='Exit']")
    private ExtendedWebElement exitButton;

    @FindBy(xpath = "//android.view.View[@content-desc='Settings']")
    private ExtendedWebElement settingsButton;

    @FindBy(xpath = "//android.view.View")
    private List<ExtendedWebElement> menuBarFields;

    @FindBy(xpath = "//android.view.View[@content-desc='ver: 1.2.87']")
    private ExtendedWebElement trackgoVersion;

    @FindBy(xpath = "//android.widget.Button[@content-desc='Goods']")
    private ExtendedWebElement goodsButton;

    @FindBy(xpath = "//android.widget.Button[@content-desc='Prices']")
    private ExtendedWebElement pricesButton;

    public TrackGoHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isHamburgerMenuButtonPresent() {
        return hamburgerMenuButton.isPresent();
    }

    @Override
    public void clickOnMenuButton() {
        hamburgerMenuButton.click();
    }

    @Override
    public boolean isLoginWithEmailButtonPresent() {
        return loginButton.isPresent();
    }

    @Override
    public LoginPageBase clickOnLoginWithEmailButton() {
        loginButton.click();
        return initPage(getDriver(), LoginPageBase.class);
    }

    @Override
    public boolean isExitButtonPresent() {
        return exitButton.isPresent();
    }

    @Override
    public void clickOnExitButton() {
        exitButton.click();
    }

    @Override
    public boolean isSettingsButtonPresent() {
        return settingsButton.isPresent();
    }

    @Override
    public SettingsBlockPageBase clickOnSettingsButton() {
        settingsButton.click();
        return initPage(getDriver(), SettingsBlockPageBase.class);
    }

    @Override
    public List<String> getFieldsOnMenuBar() {
        return menuBarFields.stream()
                .map(ExtendedWebElement::getText)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isMenuBarFieldsEmpty() {
        return menuBarFields.isEmpty();
    }

    @Override
    public String getTrackgoVersion() {
        return trackgoVersion.getText();
    }

    @Override
    public boolean isGoodsButtonPresent() {
        return goodsButton.isPresent();
    }

    @Override
    public GoodsPageBase clickOnGoodsButton() {
        goodsButton.click();
        return initPage(getDriver(), GoodsPageBase.class);
    }

    @Override
    public boolean isPricesButtonPresent() {
        return pricesButton.isPresent();
    }

    @Override
    public PricesPageBase clickOnPricesButton() {
        pricesButton.click();
        return initPage(getDriver(), PricesPageBase.class);
    }
}
