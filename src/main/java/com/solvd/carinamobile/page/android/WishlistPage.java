package com.solvd.carinamobile.page.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carinamobile.page.common.WishlistPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = WishlistPageBase.class)
public class WishlistPage extends WishlistPageBase {

    @FindBy(xpath = "//div[@class = 'badge-container___DVUWN']/div/div")
    private List<ExtendedWebElement> productPrices;

    public WishlistPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isProductListEmpty() {
        return productPrices.isEmpty();
    }
}
