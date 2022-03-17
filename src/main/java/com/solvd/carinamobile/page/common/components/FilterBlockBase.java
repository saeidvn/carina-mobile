package com.solvd.carinamobile.page.common.components;

import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class FilterBlockBase extends AbstractUIObject {

    public FilterBlockBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract void clickOnLowPriceToHighBtn();

    public abstract void clickOnHighPriceToLowBtn();

    public abstract void clickOnTopSellersBtn();

    public abstract boolean isLowPriceToHighPriceBtnPresent();

    public abstract boolean isHighPriceToLowPriceBtnPresent();

    public abstract boolean isTopSellersBtnPresent();

    public abstract boolean isApplyBtnPresent();

}
