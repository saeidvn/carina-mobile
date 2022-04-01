package com.solvd.carinamobile.page.TrackgoApp;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carinamobile.page.common.SettingsBlockPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SettingsBlockPageBase.class)
public class SettingsBlockPage extends SettingsBlockPageBase {

    @FindBy(xpath = "//android.view.View[@content-desc='Dark theme']")
    private ExtendedWebElement darkThemeButton;

    @FindBy(xpath = "(//android.view.View[@content-desc='Dark theme'])[2]/android.widget.Switch")
    private ExtendedWebElement changeThemeButton;

    @FindBy(xpath = "//android.view.View[@content-desc='Currency Choose currency for added products']")
    private ExtendedWebElement currencyButton;

    @FindBy(xpath = "//android.view.View[@content-desc='Euro']/android.widget.RadioButton")
    private ExtendedWebElement euroRadioButton;

    @FindBy(xpath = "//android.view.View[@content-desc='Time zones Time zone for Push notifications']")
    private ExtendedWebElement regionButton;

    @FindBy(xpath = "//android.view.View[@content-desc='Russian Federation']/android.widget.RadioButton")
    private ExtendedWebElement russianRadioButton;

    @FindBy(xpath = "//android.view.View[@content-desc='Time zones Time zone for Push notifications']")
    private ExtendedWebElement timeZonesButton;

    @FindBy(xpath = "//android.view.View[@content-desc='Europe/Minsk']/android.widget.RadioButton")
    private ExtendedWebElement europeMinskRadioButton;

    @FindBy(xpath = "//android.view.View[@content-desc='Notifications Push, copying']")
    private ExtendedWebElement notificationsButton;

    @FindBy(xpath = "//android.view.View[@content-desc='Push notifications Push notifications enabled']/android.widget.CheckBox")
    private ExtendedWebElement notificationCheckBox;

    public SettingsBlockPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDarkThemeButtonPresent() {
        return darkThemeButton.isPresent();
    }

    @Override
    public void clickOnDarkThemeButton() {
        darkThemeButton.click();
    }

    @Override
    public boolean isChangeThemeButtonPresent() {
        return changeThemeButton.isPresent();
    }

    @Override
    public void clickOnChangeThemeButton() {
        changeThemeButton.click();
    }

    @Override
    public boolean isCurrencyButtonPresent() {
        return currencyButton.isPresent();
    }

    @Override
    public void clickOnCurrencyButton() {
        currencyButton.click();
    }

    @Override
    public boolean isEuroRadioButtonPresent() {
        return euroRadioButton.isPresent();
    }

    @Override
    public void clickOnEuroRadioButton() {
        euroRadioButton.click();
    }

    @Override
    public boolean isRegionButtonPresent() {
        return regionButton.isPresent();
    }

    @Override
    public void clickOnRegionButton() {
        regionButton.click();
    }

    @Override
    public boolean isRussianRadioButtonPresent() {
        return russianRadioButton.isPresent();
    }

    @Override
    public void clickOnRussianRadioButton() {
        russianRadioButton.click();
    }

    @Override
    public boolean isTimeZonesButtonPresent() {
        return timeZonesButton.isPresent();
    }

    @Override
    public void clickOnTimeZonesButton() {
        timeZonesButton.click();
    }

    @Override
    public boolean isMinskRadioButtonPresent() {
        return europeMinskRadioButton.isPresent();
    }

    @Override
    public void clickOnMinskRadioButton() {
        europeMinskRadioButton.click();
    }

    @Override
    public boolean isNotificationsButtonPresent() {
        return notificationsButton.isPresent();
    }

    @Override
    public void clickOnNotificationsButton() {
        notificationsButton.click();
    }

    @Override
    public boolean isNotificationCheckBoxPresent() {
        return notificationCheckBox.isPresent();
    }

    @Override
    public void clickOnNotificationCheckBox() {
        notificationCheckBox.click();
    }
}
