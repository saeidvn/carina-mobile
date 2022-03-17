package com.solvd.carinamobile;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.report.testrail.TestRailCases;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.carinamobile.page.common.AdidasHomePageBase;
import com.solvd.carinamobile.page.common.HelpPageBase;
import org.testng.annotations.Test;

public class AdidasTest implements IAbstractTest, IMobileUtils {

    @TestRailCases(testCasesId = "1")
    @Test(description = "Check 2 help button.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "android")
    public void checkHelpButtons() {
        AdidasHomePageBase adidasHomePage = initPage(getDriver(), AdidasHomePageBase.class);
        adidasHomePage.open();
//        Assert.assertTrue(adidasHomePage.isPageOpened(), "Adidas home page isn't open.");

//        adidasHomePage.clickOnHelpBtn();

//        HelpPageBase helpPage = adidasHomePage.clickOnHelpBtn();

    }

}