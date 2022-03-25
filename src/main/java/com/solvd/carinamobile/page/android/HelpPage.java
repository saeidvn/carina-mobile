package com.solvd.carinamobile.page.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carinamobile.page.common.HelpPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HelpPageBase.class)
public class HelpPage extends HelpPageBase {

    @FindBy(xpath = "//h2[@class='gl-heading title___2eQQb withhtml___3ITcI gl-heading--m']")
    private ExtendedWebElement helpContentTitle;

    public HelpPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isHelpContentTitleVisible() {
        return helpContentTitle.isVisible(20);
    }

}
