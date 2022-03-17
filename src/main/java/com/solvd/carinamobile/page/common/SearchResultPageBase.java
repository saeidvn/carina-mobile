package com.solvd.carinamobile.page.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SearchResultPageBase extends AbstractPage {

    public SearchResultPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isSearchNoContentTitleVisible();

    public abstract boolean isSearchNoContentDescriptionVisible();

}
