package com.solvd.carinamobile;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.report.testrail.TestRailCases;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.carinamobile.page.common.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TrackGoAppTest implements IAbstractTest {

    private static final String EMAIL = "x7en0mx@yahoo.com";
    private static final String PASSWORD = "12345Test";

    @TestRailCases(testCasesId = "1")
    @Test(description = "Open the Trackgo app and Login.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "android")
    public void checkLogInWithEmail() {
        SoftAssert softAssert = new SoftAssert();
        TrackGoHomePageBase trackGoHomePage = initPage(getDriver(), TrackGoHomePageBase.class);
        softAssert.assertTrue(trackGoHomePage.isHamburgerMenuButtonPresent(), "Hamburger Menu button is missing");
        trackGoHomePage.clickOnMenuButton();
        softAssert.assertTrue(trackGoHomePage.isLoginWithEmailButtonPresent(), "Login With Email button is missing");
        LoginPageBase loginPage = trackGoHomePage.clickOnLoginWithEmailButton();
        softAssert.assertTrue(loginPage.isEmailFieldPresent(), "Email field is missing");
        softAssert.assertTrue(loginPage.isPasswordFieldPresent(), "Password field is missing");
        loginPage.logIn(EMAIL, PASSWORD);
        softAssert.assertTrue(loginPage.isSignInButtonPresent(), "Sign-in button is missing");
        loginPage.clickOnSignInButton();
        softAssert.assertAll();
    }

    @TestRailCases(testCasesId = "2")
    @Test(description = "Open the Trackgo app and after Login, do LogOut.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "android")
    public void checkLogOut() {
        SoftAssert softAssert = new SoftAssert();
        TrackGoHomePageBase trackGoHomePage = initPage(getDriver(), TrackGoHomePageBase.class);
        softAssert.assertTrue(trackGoHomePage.isHamburgerMenuButtonPresent(), "Hamburger Menu button is missing");
        trackGoHomePage.clickOnMenuButton();
        softAssert.assertTrue(trackGoHomePage.isLoginWithEmailButtonPresent(), "Login With Email button is missing");
        LoginPageBase loginPage = trackGoHomePage.clickOnLoginWithEmailButton();
        softAssert.assertTrue(loginPage.isEmailFieldPresent(), "Email field is not visible");
        softAssert.assertTrue(loginPage.isPasswordFieldPresent(), "Password field is missing");
        loginPage.logIn(EMAIL, PASSWORD);
        softAssert.assertTrue(loginPage.isSignInButtonPresent(), "Sign-in button is missing");
        loginPage.clickOnSignInButton();
        softAssert.assertTrue(trackGoHomePage.isHamburgerMenuButtonPresent(), "Hamburger Menu button is missing");
        trackGoHomePage.clickOnMenuButton();
        softAssert.assertTrue(trackGoHomePage.isExitButtonPresent(), "Exit button is missing");
        trackGoHomePage.clickOnExitButton();
        softAssert.assertAll();
    }

    @TestRailCases(testCasesId = "3")
    @Test(description = "Open the Trackgo app and change Theme.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "android")
    public void checkChangeTheme() {
        SoftAssert softAssert = new SoftAssert();
        TrackGoHomePageBase trackGoHomePage = initPage(getDriver(), TrackGoHomePageBase.class);
        softAssert.assertTrue(trackGoHomePage.isHamburgerMenuButtonPresent(), "Hamburger Menu button is missing");
        trackGoHomePage.clickOnMenuButton();
        softAssert.assertTrue(trackGoHomePage.isSettingsButtonPresent(), "Settings button is missing");
        SettingsBlockPageBase settingsBlockPage = trackGoHomePage.clickOnSettingsButton();
        softAssert.assertTrue(settingsBlockPage.isDarkThemeButtonPresent(), "Dark Theme button is missing");
        settingsBlockPage.clickOnDarkThemeButton();
        softAssert.assertTrue(settingsBlockPage.isChangeThemeButtonPresent(), "Change Theme button is missing");
        settingsBlockPage.clickOnChangeThemeButton();
        softAssert.assertAll();
    }

    @TestRailCases(testCasesId = "4")
    @Test(description = "Open the Trackgo app and change Currency.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "android")
    public void checkChangeCurrency() {
        SoftAssert softAssert = new SoftAssert();
        TrackGoHomePageBase trackGoHomePage = initPage(getDriver(), TrackGoHomePageBase.class);
        softAssert.assertTrue(trackGoHomePage.isHamburgerMenuButtonPresent(), "Hamburger Menu button is missing");
        trackGoHomePage.clickOnMenuButton();
        softAssert.assertTrue(trackGoHomePage.isSettingsButtonPresent(), "Settings button is missing");
        SettingsBlockPageBase settingsBlockPage = trackGoHomePage.clickOnSettingsButton();
        softAssert.assertTrue(settingsBlockPage.isCurrencyButtonPresent(), "Currency button is missing");
        settingsBlockPage.clickOnCurrencyButton();
        softAssert.assertTrue(settingsBlockPage.isEuroRadioButtonPresent(), "Euro Radio button is missing");
        settingsBlockPage.clickOnEuroRadioButton();
        softAssert.assertAll();
    }

    @TestRailCases(testCasesId = "5")
    @Test(description = "Open the Trackgo app and change Region.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "android")
    public void checkChangeRegion() {
        SoftAssert softAssert = new SoftAssert();
        TrackGoHomePageBase trackGoHomePage = initPage(getDriver(), TrackGoHomePageBase.class);
        softAssert.assertTrue(trackGoHomePage.isHamburgerMenuButtonPresent(), "Hamburger Menu button is missing");
        trackGoHomePage.clickOnMenuButton();
        softAssert.assertTrue(trackGoHomePage.isSettingsButtonPresent(), "Settings button is missing");
        SettingsBlockPageBase settingsBlockPage = trackGoHomePage.clickOnSettingsButton();
        softAssert.assertTrue(settingsBlockPage.isRegionButtonPresent(), "Region Button is missing");
        settingsBlockPage.clickOnRegionButton();
        softAssert.assertTrue(settingsBlockPage.isRussianRadioButtonPresent()
                , "Russian Radio button is missing");
        settingsBlockPage.clickOnRussianRadioButton();
        softAssert.assertAll();
    }

    @TestRailCases(testCasesId = "6")
    @Test(description = "Open the Trackgo app and change Time Zones.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "android")
    public void checkChangeTimeZones() {
        SoftAssert softAssert = new SoftAssert();
        TrackGoHomePageBase trackGoHomePage = initPage(getDriver(), TrackGoHomePageBase.class);
        softAssert.assertTrue(trackGoHomePage.isHamburgerMenuButtonPresent(), "Hamburger Menu button is missing");
        trackGoHomePage.clickOnMenuButton();
        softAssert.assertTrue(trackGoHomePage.isSettingsButtonPresent(), "Settings button is missing");
        SettingsBlockPageBase settingsBlockPage = trackGoHomePage.clickOnSettingsButton();
        softAssert.assertTrue(settingsBlockPage.isTimeZonesButtonPresent(), "Time Zones button is missing");
        settingsBlockPage.clickOnTimeZonesButton();
        softAssert.assertTrue(settingsBlockPage.isMinskRadioButtonPresent(), "Minsk Radio button is missing");
        settingsBlockPage.clickOnMinskRadioButton();
        softAssert.assertAll();
    }

    @TestRailCases(testCasesId = "7")
    @Test(description = "Open the Trackgo app and change Time Zones.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "android")
    public void CheckHamburgerMenuLists() {
        SoftAssert softAssert = new SoftAssert();
        TrackGoHomePageBase trackGoHomePage = initPage(getDriver(), TrackGoHomePageBase.class);
        softAssert.assertTrue(trackGoHomePage.isHamburgerMenuButtonPresent(), "Hamburger Menu button is missing");
        trackGoHomePage.clickOnMenuButton();
        trackGoHomePage.getFieldsOnMenuBar();
        softAssert.assertFalse(trackGoHomePage.isMenuBarFieldsEmpty(), "Menu's fields is missing");
        softAssert.assertAll();
    }

    @TestRailCases(testCasesId = "8")
    @Test(description = "Open the Trackgo app and turn on Notification.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "android")
    public void CheckTurnOnNotification() {
        SoftAssert softAssert = new SoftAssert();
        TrackGoHomePageBase trackGoHomePage = initPage(getDriver(), TrackGoHomePageBase.class);
        softAssert.assertTrue(trackGoHomePage.isHamburgerMenuButtonPresent(), "Hamburger Menu button is missing");
        trackGoHomePage.clickOnMenuButton();
        trackGoHomePage.getFieldsOnMenuBar();
        softAssert.assertFalse(trackGoHomePage.isMenuBarFieldsEmpty(), "Menu's fields is missing");
        softAssert.assertTrue(trackGoHomePage.isSettingsButtonPresent(), "Settings button is missing");
        SettingsBlockPageBase settingsBlockPage = trackGoHomePage.clickOnSettingsButton();
        softAssert.assertTrue(settingsBlockPage.isNotificationsButtonPresent()
                , "Notifications button is missing");
        settingsBlockPage.clickOnNotificationsButton();
        softAssert.assertTrue(settingsBlockPage.isNotificationCheckBoxPresent()
                , "Notification checkBox is missing");
        settingsBlockPage.clickOnNotificationCheckBox();
        softAssert.assertAll();
    }

    @TestRailCases(testCasesId = "9")
    @Test(description = "Open the Trackgo app and get Version.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "android")
    public void CheckGetVersion() {
        SoftAssert softAssert = new SoftAssert();
        TrackGoHomePageBase trackGoHomePage = initPage(getDriver(), TrackGoHomePageBase.class);
        softAssert.assertTrue(trackGoHomePage.isHamburgerMenuButtonPresent(), "Hamburger Menu button is missing");
        trackGoHomePage.clickOnMenuButton();
        trackGoHomePage.getTrackgoVersion();
        softAssert.assertEquals(trackGoHomePage.getTrackgoVersion(), "ver: 1.2.87",
                "Trackgo versions not equals");
        softAssert.assertAll();
    }

    @TestRailCases(testCasesId = "10")
    @Test(description = "Open the Trackgo app and change Tabs in Goods's field.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "android")
    public void CheckChangeTab() {
        SoftAssert softAssert = new SoftAssert();
        TrackGoHomePageBase trackGoHomePage = initPage(getDriver(), TrackGoHomePageBase.class);
        softAssert.assertTrue(trackGoHomePage.isGoodsButtonPresent(), "Goods button is missing");
        GoodsPageBase goodsBlockPage = trackGoHomePage.clickOnGoodsButton();
        softAssert.assertTrue(goodsBlockPage.isRecommendedTabPresent(), "Recommended tab is missing");
        goodsBlockPage.clickOnRecommendedTab();
        softAssert.assertTrue(goodsBlockPage.isInterestingTabPresent(), "Interestin tab is missing");
        goodsBlockPage.clickOnInterestingTab();
        softAssert.assertAll();
    }

    @TestRailCases(testCasesId = "11")
    @Test(description = "Open the Trackgo app and click on the Goods's button.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "android")
    public void CheckGoodsButton() {
        SoftAssert softAssert = new SoftAssert();
        TrackGoHomePageBase trackGoHomePage = initPage(getDriver(), TrackGoHomePageBase.class);
        softAssert.assertTrue(trackGoHomePage.isGoodsButtonPresent(), "Goods button is missing");
        GoodsPageBase goodsBlockPage = trackGoHomePage.clickOnGoodsButton();
        goodsBlockPage.getGoodsResultProducts();
        softAssert.assertFalse(goodsBlockPage.isGoodsResultProductsEmpty(), "Products is missing");
        softAssert.assertAll();
    }

    @TestRailCases(testCasesId = "12")
    @Test(description = "Open the Trackgo app and click on the Prices button.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "android")
    public void CheckPricesButton() {
        SoftAssert softAssert = new SoftAssert();
        TrackGoHomePageBase trackGoHomePage = initPage(getDriver(), TrackGoHomePageBase.class);
        softAssert.assertTrue(trackGoHomePage.isPricesButtonPresent(), "Prices button is missing");
        PricesPageBase pricesPage = trackGoHomePage.clickOnPricesButton();
        pricesPage.getResultText();
        softAssert.assertEquals(pricesPage.getResultText(),
                "At the moment, we are making the service better, some features may not be available.☹ ️ Try again later."
                , "Prices texts not equals");
        softAssert.assertAll();
    }

    @TestRailCases(testCasesId = "13")
    @Test(description = "Open the Trackgo app and use invalid Login.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "android")
    public void checkInvalidEmail() {
        SoftAssert softAssert = new SoftAssert();
        TrackGoHomePageBase trackGoHomePage = initPage(getDriver(), TrackGoHomePageBase.class);
        softAssert.assertTrue(trackGoHomePage.isHamburgerMenuButtonPresent(), "Hamburger Menu button is missing");
        trackGoHomePage.clickOnMenuButton();
        softAssert.assertTrue(trackGoHomePage.isLoginWithEmailButtonPresent(), "Login With Email button is missing");
        LoginPageBase loginPage = trackGoHomePage.clickOnLoginWithEmailButton();
        softAssert.assertTrue(loginPage.isEmailFieldPresent(), "Email field is not visible");
        softAssert.assertTrue(loginPage.isPasswordFieldPresent(), "Password field is missing");
        loginPage.logIn("qwds312", PASSWORD);
        softAssert.assertTrue(loginPage.isSignInButtonPresent(), "Sign-in button is missing");
        loginPage.clickOnSignInButton();
        loginPage.getLoginErrorText();
        softAssert.assertEquals(loginPage.getLoginErrorText(), "Неверный email или пароль."
                , "Error texts is not equals");
        softAssert.assertAll();
    }

    @TestRailCases(testCasesId = "14")
    @Test(description = "Open the Trackgo app and use invalid Password.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "android")
    public void checkInvalidPassword() {
        SoftAssert softAssert = new SoftAssert();
        TrackGoHomePageBase trackGoHomePage = initPage(getDriver(), TrackGoHomePageBase.class);
        softAssert.assertTrue(trackGoHomePage.isHamburgerMenuButtonPresent(), "Hamburger Menu button is missing");
        trackGoHomePage.clickOnMenuButton();
        softAssert.assertTrue(trackGoHomePage.isLoginWithEmailButtonPresent(), "Login With Email button is missing");
        LoginPageBase loginPage = trackGoHomePage.clickOnLoginWithEmailButton();
        softAssert.assertTrue(loginPage.isEmailFieldPresent(), "Email field is not visible");
        softAssert.assertTrue(loginPage.isPasswordFieldPresent(), "Password field is missing");
        loginPage.logIn(EMAIL, "a12edas");
        softAssert.assertTrue(loginPage.isSignInButtonPresent(), "Sign-in button is missing");
        loginPage.clickOnSignInButton();
        loginPage.getLoginErrorText();
        softAssert.assertEquals(loginPage.getLoginErrorText(), "Неверный email или пароль."
                , "Error texts is not equals");
        softAssert.assertAll();
    }
}
