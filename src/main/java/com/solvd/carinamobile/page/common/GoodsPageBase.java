package com.solvd.carinamobile.page.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class GoodsPageBase extends AbstractPage {

    public GoodsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isRecommendedTabPresent();

    public abstract void clickOnRecommendedTab();

    public abstract boolean isInterestingTabPresent();

    public abstract void clickOnInterestingTab();

    public abstract List<String> getGoodsResultProducts();

    public abstract boolean isGoodsResultProductsEmpty();
}
