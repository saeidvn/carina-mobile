package com.solvd.carinamobile.page.TrackgoApp;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carinamobile.page.common.PricesPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = PricesPageBase.class)
public class PricesPage extends PricesPageBase {

    @FindBy(xpath = "//android.view.View[@content-desc='At the moment, we are making the service better, some features may not be available.☹ ️ Try again later.']")
    private ExtendedWebElement pricesResult;

    public PricesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getResultText() {
        return pricesResult.getText();
    }
}
