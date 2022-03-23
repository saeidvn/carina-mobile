package com.solvd.carinamobile.page.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class ProductListResultPageBase extends AbstractPage {

    public ProductListResultPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isProductListNotEmpty();

    public abstract boolean isPopupVisible();

    public abstract List<String> getResultPricesAsStrings();

    public abstract List<Integer> getResultPricesAsNumbers();

    public abstract void clickOnClosePopUp();

    public abstract void scrollDownPage();

    public abstract boolean isAmazonResultVisible();

    public abstract boolean isFilterButtonVisible();

    public abstract void clickOnFilterButton();

    public abstract boolean isBooksResultVisible();

    public abstract boolean isHealthAndHouseholdResultVisible();

    public abstract String getHelpText();

    public abstract boolean isMovieButtonVisible();

    public abstract void clickOnMovieButton();

    public abstract boolean isCloseFilterButtonVisible();

    public abstract void clickOnCloseFilterButton();

    public abstract List<String> getResultMoviesAsStrings();

    public abstract boolean isMoviesResultEmpty();

}
