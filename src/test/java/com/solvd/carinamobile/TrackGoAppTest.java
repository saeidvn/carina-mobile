package com.solvd.carinamobile;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.report.testrail.TestRailCases;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.carinamobile.page.common.TrackGoHomePageBase;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TrackGoAppTest implements IAbstractTest {

    private static final String EMAIL = "x7en0mx@yahoo.com";
    private static final String PASSWORD = "12345Test";

    @TestRailCases(testCasesId = "1")
    @Test(description = "Open the Trackgo app and Login.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "android")
    public void checkSearchProduct() {
        SoftAssert softAssert = new SoftAssert();
        TrackGoHomePageBase trackGoHomePage = initPage(getDriver(), TrackGoHomePageBase.class);
        trackGoHomePage.clickOnMenuButton();
        trackGoHomePage.clickOnLoginWithEmailButton();
        softAssert.assertTrue(trackGoHomePage.isEmailFieldVisible(), "Email field is not visible");
//        trackGoHomePage.typeValidEmail(EMAIL);
        trackGoHomePage.typeValidPassword(PASSWORD);
//        trackGoHomePage.clickOnSignInButton();
        softAssert.assertAll();
    }

    @TestRailCases(testCasesId = "3")
    @Test(description = "Open the Trackgo app and change Theme.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "android")
    public void checkChangeTheme() {
        SoftAssert softAssert = new SoftAssert();
        TrackGoHomePageBase trackGoHomePage = initPage(getDriver(), TrackGoHomePageBase.class);
        trackGoHomePage.clickOnMenuButton();
        trackGoHomePage.clickOnSettingsButton();
        trackGoHomePage.clickOnDarkThemeButton();
        trackGoHomePage.clickOnChangeThemeButton();
        softAssert.assertAll();
    }

}
