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

}
