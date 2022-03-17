package com.solvd.carinamobile.page.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ProductListResultPageBase extends AbstractPage {

    public ProductListResultPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isProductListEmpty();

    public abstract void scrollDownPage() throws InterruptedException;

}
