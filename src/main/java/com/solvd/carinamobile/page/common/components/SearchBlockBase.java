package com.solvd.carinamobile.page.common.components;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.carinamobile.page.andriod.SearchResultPage;
import com.solvd.carinamobile.page.common.ProductListResultPageBase;
import com.solvd.carinamobile.page.common.SearchResultPageBase;
import org.openqa.selenium.WebDriver;

public abstract class SearchBlockBase extends AbstractPage {

    public SearchBlockBase(WebDriver driver) {
        super(driver);
    }

    public abstract ProductListResultPageBase clickOnCapBtn();

    public abstract SearchResultPageBase noResultForSearch();

    public abstract boolean isNewFrameVisible();

}
