package com.solvd.carinamobile.page.andriod;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carinamobile.page.common.AdidasHomePageBase;
import com.solvd.carinamobile.page.common.HelpPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AdidasHomePageBase.class)
public class AdidasHomePage extends AdidasHomePageBase implements IMobileUtils {

    @FindBy(xpath = "//span[text()='Help']")
    private ExtendedWebElement helpBtn;

    public AdidasHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HelpPageBase clickOnHelpBtn() {
        helpBtn.click();
        return initPage(getDriver(), HelpPageBase.class);
    }
}
