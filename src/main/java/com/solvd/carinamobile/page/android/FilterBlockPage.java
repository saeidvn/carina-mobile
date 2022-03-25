package com.solvd.carinamobile.page.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carinamobile.page.common.FilterBlockPageBase;
import com.solvd.carinamobile.page.common.ProductListResultPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = FilterBlockPageBase.class)
public class FilterBlockPage extends FilterBlockPageBase {

    @FindBy(xpath = "//li[contains(@class,'sorting_option___3bTnn') and text()='Price (low - high)']")
    private ExtendedWebElement lowPriceToHighPriceButton;

    @FindBy(xpath = "//li[contains(@class,'sorting_option___3bTnn') and text()='Price (high - low)']")
    private ExtendedWebElement highPriceToLowPriceButton;

    @FindBy(xpath = "//li[contains(@class,'sorting_option___3bTnn') and text()='Top Sellers']")
    private ExtendedWebElement topSellersButton;

    public FilterBlockPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ProductListResultPageBase clickOnLowPriceToHighButton() {
        lowPriceToHighPriceButton.clickIfPresent();
        return initPage(getDriver(), ProductListResultPageBase.class);
    }

    @Override
    public ProductListResultPageBase clickOnHighPriceToLowButton() {
        highPriceToLowPriceButton.clickIfPresent();
        return initPage(getDriver(), ProductListResultPageBase.class);
    }

    @Override
    public ProductListResultPageBase clickOnTopSellersButton() {
        topSellersButton.clickIfPresent();
        return initPage(getDriver(), ProductListResultPageBase.class);
    }

    @Override
    public boolean isLowPriceToHighPriceButtonPresent() {
        return lowPriceToHighPriceButton.isPresent();
    }

    @Override
    public boolean isHighPriceToLowPriceButtonPresent() {
        return highPriceToLowPriceButton.isPresent();
    }

    @Override
    public boolean isTopSellersButtonPresent() {
        return topSellersButton.isPresent();
    }

}