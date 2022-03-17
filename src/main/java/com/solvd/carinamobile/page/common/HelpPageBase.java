package com.solvd.carinamobile.page.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HelpPageBase extends AbstractPage {

    public HelpPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract AdidasHomePageBase clickOnAdidasHomePageBtn();

}
