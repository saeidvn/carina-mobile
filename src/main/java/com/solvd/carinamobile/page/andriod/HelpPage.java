package com.solvd.carinamobile.page.andriod;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carinamobile.page.common.AdidasHomePageBase;
import com.solvd.carinamobile.page.common.HelpPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HelpPageBase.class)
public class HelpPage extends HelpPageBase {

    @FindBy(xpath = "//a[@class='logo___2tFVp logo-icon___3zV2W logo-black___h4PfO']")
    private ExtendedWebElement adidasHomePageBtn;

    public HelpPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return adidasHomePageBtn.isElementPresent();
    }

    public AdidasHomePageBase clickOnAdidasHomePageBtn() {
        adidasHomePageBtn.click();
        return initPage(getDriver(), AdidasHomePageBase.class);
    }

}
