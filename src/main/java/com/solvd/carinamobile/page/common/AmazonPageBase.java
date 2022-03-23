package com.solvd.carinamobile.page.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class AmazonPageBase extends AbstractPage {

    public AmazonPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isSearchFieldVisible();

    public abstract void clickOnSearchField();

    public abstract ProductListResultPageBase typeProductName(String productName);

    public abstract boolean isSignInButtonVisible();

    public abstract void clickOnSignInButton();

    public abstract boolean isBestSellersButtonVisible();

    public abstract void clickOnBestSellersButton();

    public abstract boolean isBooksButtonVisible();

    public abstract ProductListResultPageBase clickOnBooksButton();

    public abstract boolean isMenuButtonVisible();

    public abstract void clickOnMenuButton();

    public abstract boolean isHealthAndHouseholdButtonVisible();

    public abstract ProductListResultPageBase clickOnHealthAndHouseholdButton();

}
