package com.solvd.carinamobile.page.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class AccessoriesPageBase extends AbstractPage {

    public AccessoriesPageBase(WebDriver driver) {
        super(driver);
    }

//    public abstract void openLink(String link);

//    public abstract FilterBlockPageBase clickFilterButton();
    public abstract void clickFilterButton();

    public abstract boolean isFilterButtonPresent();

    public abstract boolean isSortByButtonPresent();

    public abstract List<String> getProductPricesAsStrings();

    public abstract List<Integer> getProductPricesAsNumbers();

    public abstract ProductListResultPageBase clickOnWishListButton();

    public abstract void addProductToWishList (int indexOfProduct);

    public abstract boolean isWishlistListEmpty();

    public abstract FilterBlockPageBase clickOnSortByButton();

    public abstract void scrollDownPage();

    public abstract boolean isFooterContainerPresent();

    public abstract void clickOnClosePopUp();

    public abstract boolean isPopupVisible();
}
