package com.solvd.carinamobile.page.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class AccessoriesPageBase extends AbstractPage {

    public AccessoriesPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickFilterButton();

    public abstract boolean isFilterButtonVisible();

    public abstract boolean isSortByButtonVisible();

    public abstract WishlistPageBase clickOnWishlistButton();

    public abstract List<Integer> getResultPricesAsNumbers();

    public abstract ProductListResultPageBase clickOnWishListButton();

    public abstract void addProductToWishList (int indexOfProduct);

    public abstract boolean isWishlistListEmpty();

    public abstract FilterBlockPageBase clickOnSortByButton();

    public abstract void scrollDownPage();

    public abstract boolean isFooterContainerVisible();

    public abstract void clickOnClosePopUp();

    public abstract boolean isPopupVisible();
}
