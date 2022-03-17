package com.solvd.carinamobile.page.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class WishlistPageBase extends AbstractPage {

    public WishlistPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isProductListEmpty();

}
