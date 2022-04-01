package com.solvd.carinamobile.page.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class PricesPageBase extends AbstractPage {

    public PricesPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getResultText();
}
