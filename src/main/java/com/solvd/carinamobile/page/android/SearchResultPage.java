package com.solvd.carinamobile.page.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carinamobile.page.common.SearchResultPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SearchResultPageBase.class)
public class SearchResultPage extends SearchResultPageBase {

    @FindBy(xpath = "//h4[@class='nohits_title___2jjLy']")
    private ExtendedWebElement searchNoContentTitle;

    @FindBy(xpath = "//p[@class='gl-body--s']")
    private ExtendedWebElement searchNoContentDescription;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isSearchNoContentTitleVisible() {
        return searchNoContentTitle.isVisible();
    }

    @Override
    public boolean isSearchNoContentDescriptionVisible() {
        return searchNoContentDescription.isVisible();
    }
}