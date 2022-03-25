package com.solvd.carinamobile.page.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carinamobile.page.common.MyAccountPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MyAccountPageBase.class)
public class MyAccountPage extends MyAccountPageBase {

    @FindBy(xpath = "//div[@class='gl-flex-display col-l-24']")
    private ExtendedWebElement myAccountStatus;

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isHomeUserStatusVisible() {
        return myAccountStatus.isVisible();
    }
}
