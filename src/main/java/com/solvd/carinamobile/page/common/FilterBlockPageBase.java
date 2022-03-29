package com.solvd.carinamobile.page.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class FilterBlockPageBase extends AbstractPage {

    public FilterBlockPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ProductListResultPageBase clickOnLowPriceToHighButton();

    public abstract ProductListResultPageBase clickOnHighPriceToLowButton();

    public abstract ProductListResultPageBase clickOnTopSellersButton();

    public abstract boolean isLowPriceToHighPriceButtonVisible();

    public abstract boolean isHighPriceToLowPriceButtonVisible();

    public abstract boolean isTopSellersButtonVisible();

}
