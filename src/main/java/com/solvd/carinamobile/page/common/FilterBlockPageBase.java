package com.solvd.carinamobile.page.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class FilterBlockPageBase extends AbstractPage {

    public FilterBlockPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ProductListResultPageBase clickOnLowPriceToHighButton();
//    public abstract void clickOnLowPriceToHighButton();

    public abstract ProductListResultPageBase clickOnHighPriceToLowButton();

    public abstract void clickOnTopSellersButton();

    public abstract boolean isLowPriceToHighPriceButtonPresent();

    public abstract boolean isHighPriceToLowPriceButtonPresent();

    public abstract boolean isTopSellersButtonPresent();

    public abstract boolean isApplyButtonPresent();

    public abstract ProductListResultPageBase clickOnApplyButton();

}
