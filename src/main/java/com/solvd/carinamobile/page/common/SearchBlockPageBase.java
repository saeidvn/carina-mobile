package com.solvd.carinamobile.page.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SearchBlockPageBase extends AbstractPage {

    public SearchBlockPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ProductListResultPageBase clickOnCapBtn();

    public abstract SearchResultPageBase noResultForSearch();

    public abstract boolean isNewFrameVisible();

}
