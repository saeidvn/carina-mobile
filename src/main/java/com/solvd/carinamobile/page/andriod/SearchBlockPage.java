package com.solvd.carinamobile.page.andriod;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carinamobile.page.common.ProductListResultPageBase;
import com.solvd.carinamobile.page.common.SearchResultPageBase;
import com.solvd.carinamobile.page.common.SearchBlockPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SearchBlockPageBase.class)
public class SearchBlockPage extends SearchBlockPageBase {

    @FindBy(xpath = "//a[contains(@class,'search-suggestion') and contains(@href, '/search?q=cap')]")
    private ExtendedWebElement capBtn;

    public SearchBlockPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ProductListResultPageBase clickOnCapBtn() {
        capBtn.clickIfPresent(10);
        return initPage(getDriver(), ProductListResultPageBase.class);
    }

    @Override
    public SearchResultPageBase noResultForSearch() {
        return initPage(getDriver(), SearchResultPageBase.class);
    }

    @Override
    public boolean isNewFrameVisible() {
        return capBtn.isPresent();
    }
}