package com.solvd.carinamobile.page.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class AdidasHomePageBase extends AbstractPage {

    public AdidasHomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract HelpPageBase clickOnHelpBtn();

}