package com.solvd.carinamobile;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.report.testrail.TestRailCases;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.carinamobile.page.common.AmazonPageBase;
import com.solvd.carinamobile.page.common.ProductListResultPageBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AmazonTest implements IAbstractTest {

    private static final String AMAZON_LINK = "https://www.amazon.com/";

    @TestRailCases(testCasesId = "10")
    @Test(description = "Open the Amazon Home page and search product.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "android")
    public void checkSearchProduct() {
        AmazonPageBase amazonPage = initPage(getDriver(), AmazonPageBase.class);
        amazonPage.openURL(AMAZON_LINK);
        Assert.assertTrue(amazonPage.isPageOpened(), "Amazon home page isn't opened.");

//        Assert.assertTrue(amazonPage.isSearchFieldVisible(), "Search field is missing.");
        amazonPage.clickOnSearchField();

        ProductListResultPageBase amazonResultPage = amazonPage.typeProductName("ps5");
//        Assert.assertTrue(amazonResultPage.isAmazonResultVisible(), "Amazon result page is missing.");
    }

    @TestRailCases(testCasesId = "11")
    @Test(description = "Open the Amazon home page, search 'saw' and use movie's filter.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "android")
    public void checkFilterButton() {
        SoftAssert softAssert = new SoftAssert();
        AmazonPageBase amazonPage = initPage(getDriver(), AmazonPageBase.class);
        amazonPage.openURL(AMAZON_LINK);
        softAssert.assertTrue(amazonPage.isPageOpened(), "Amazon home page isn't opened.");
        softAssert.assertTrue(amazonPage.isSearchFieldVisible(), "Search field is missing.");
        amazonPage.clickOnSearchField();
        ProductListResultPageBase sawResultPage = amazonPage.typeProductName("saw");
        softAssert.assertTrue(sawResultPage.isAmazonResultVisible(), "Amazon result page is missing.");
        softAssert.assertTrue(sawResultPage.isFilterButtonVisible(), "Filter button is missing.");
        sawResultPage.clickOnFilterButton();
        softAssert.assertTrue(sawResultPage.isMovieButtonVisible(), "Movie button is missing.");
        sawResultPage.clickOnMovieButton();
        softAssert.assertTrue(sawResultPage.isCloseFilterButtonVisible(), "Close Filter button is missing.");
        sawResultPage.clickOnCloseFilterButton();
        sawResultPage.getResultMoviesAsStrings();
        softAssert.assertFalse(sawResultPage.isMoviesResultEmpty(), "Movies are not found.");
        softAssert.assertAll();
    }

    @TestRailCases(testCasesId = "12")
    @Test(description = "Open the Amazon home page and click on the Best Sellers and choose Books.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "android")
    public void checkBestSellers() {
        SoftAssert softAssert = new SoftAssert();
        AmazonPageBase amazonPage = initPage(getDriver(), AmazonPageBase.class);
        amazonPage.openURL(AMAZON_LINK);
        softAssert.assertTrue(amazonPage.isPageOpened(), "Amazon home page isn't opened.");
        softAssert.assertTrue(amazonPage.isBestSellersButtonVisible(), "Best sellers button is missing.");
        amazonPage.clickOnBestSellersButton();
        softAssert.assertTrue(amazonPage.isBooksButtonVisible(), "Books button is missing.");
        ProductListResultPageBase amazonBooksResultPage = amazonPage.clickOnBooksButton();
        softAssert.assertTrue(amazonBooksResultPage.isBooksResultVisible(), "Books result is missing.");
        softAssert.assertAll();
    }

    @TestRailCases(testCasesId = "13")
    @Test(description = "Open the Amazon home page, click on the menu, choose Health & Household.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "android")
    public void checkHealthAndHousehold() {
        SoftAssert softAssert = new SoftAssert();
        AmazonPageBase amazonPage = initPage(getDriver(), AmazonPageBase.class);
        amazonPage.openURL(AMAZON_LINK);
        softAssert.assertTrue(amazonPage.isPageOpened(), "Amazon home page isn't opened.");
        softAssert.assertTrue(amazonPage.isMenuButtonVisible(), "Hamburger Menu button is missing.");
        amazonPage.clickOnMenuButton();
        ProductListResultPageBase healthAndHouseholdResult = amazonPage.clickOnHealthAndHouseholdButton();
        softAssert.assertEquals(healthAndHouseholdResult.getHealthAndHouseholdResultText()
                , "Health, Household and Baby Care", "Health and household text not equals.");
        softAssert.assertAll();
    }

    @TestRailCases(testCasesId = "14")
    @Test(description = "Open the Amazon home page, click on the Customer Service.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "android")
    public void checkCustomerService() {
        SoftAssert softAssert = new SoftAssert();
        AmazonPageBase amazonPage = initPage(getDriver(), AmazonPageBase.class);
        amazonPage.openURL(AMAZON_LINK);
        softAssert.assertTrue(amazonPage.isPageOpened(), "Amazon home page isn't opened.");
        softAssert.assertTrue(amazonPage.isCustomerServiceButtonVisible(), "Customer Service button is missing.");
        ProductListResultPageBase customerServiceResultPage = amazonPage.clickOnCustomerServiceButton();
        softAssert.assertEquals(customerServiceResultPage.getHelpText(), "Help", "Help text not equals.");
        softAssert.assertAll();
    }

    @TestRailCases(testCasesId = "15")
    @Test(description = "Open the Amazon home page and type invalid email.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "android")
    public void checkInvalidEmail() {
        SoftAssert softAssert = new SoftAssert();
        AmazonPageBase amazonPage = initPage(getDriver(), AmazonPageBase.class);
        amazonPage.openURL(AMAZON_LINK);
        softAssert.assertTrue(amazonPage.isPageOpened(), "Amazon home page isn't opened.");
        softAssert.assertTrue(amazonPage.isSignInButtonVisible(), "Sign-in button is missing.");
        amazonPage.clickOnSignInButton();
        softAssert.assertTrue(amazonPage.isEmailFieldVisible(), "Email field is missing.");
        amazonPage.typeEmail("saeidasa@gmail");
        softAssert.assertEquals(amazonPage.getIncorrectEmailText(), "No account found with email address"
                , "Incorrect email text not equals.");
        softAssert.assertAll();
    }

    @TestRailCases(testCasesId = "16")
    @Test(description = "Open the Amazon home page and type invalid password.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "android")
    public void checkInvalidPassword() {
        SoftAssert softAssert = new SoftAssert();
        AmazonPageBase amazonPage = initPage(getDriver(), AmazonPageBase.class);
        amazonPage.openURL(AMAZON_LINK);
        softAssert.assertTrue(amazonPage.isPageOpened(), "Amazon home page isn't opened.");
        softAssert.assertTrue(amazonPage.isSignInButtonVisible(), "Sign-in button is missing.");
        amazonPage.clickOnSignInButton();
        softAssert.assertTrue(amazonPage.isEmailFieldVisible(), "Email field is missing.");
        amazonPage.typeEmail("saeidvn@gmail.com");
        softAssert.assertTrue(amazonPage.isPasswordFieldVisible(), "Password field is missing.");
        amazonPage.typePassword("12345");
        softAssert.assertEquals(amazonPage.getIncorrectPasswordText(), "Your password is incorrect"
                , "Incorrect password texts not equals.");
        softAssert.assertAll();
    }

}
