package com.solvd.carinamobile.page.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class MyAccountPageBase extends AbstractPage {

    public MyAccountPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isHomeUserStatusVisible();
}
