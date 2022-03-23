package com.solvd.carinamobile;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.report.testrail.TestRailCases;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.carinamobile.page.common.AmazonPageBase;
import com.solvd.carinamobile.page.common.ProductListResultPageBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonTest implements IAbstractTest {

    private static final String AMAZON_LINK = "https://www.amazon.com/";

    @TestRailCases(testCasesId = "10")
    @Test(description = "Open the Amazon Home page and search product.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "android")
    public void checkSearchProduct() {
        AmazonPageBase amazonPage = initPage(getDriver(), AmazonPageBase.class);
        amazonPage.openURL(AMAZON_LINK);
        Assert.assertTrue(amazonPage.isPageOpened(), "Amazon home page isn't opened.");

        Assert.assertTrue(amazonPage.isSearchFieldVisible(), "Search field is missing.");
        amazonPage.clickOnSearchField();

        ProductListResultPageBase amazonResultPage = amazonPage.typeProductName("ps5");
        Assert.assertTrue(amazonResultPage.isAmazonResultVisible(), "Amazon result page is missing.");
    }

    @TestRailCases(testCasesId = "11")
    @Test(description = "Open the Amazon home page, search 'saw' and use movie's filter.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "android")
    public void checkFilterButton() {
        AmazonPageBase amazonPage = initPage(getDriver(), AmazonPageBase.class);
        amazonPage.openURL(AMAZON_LINK);
        Assert.assertTrue(amazonPage.isPageOpened(), "Amazon home page isn't opened.");

        Assert.assertTrue(amazonPage.isSearchFieldVisible(), "Search field is missing.");
        amazonPage.clickOnSearchField();

        ProductListResultPageBase sawResultPage = amazonPage.typeProductName("saw");
        Assert.assertTrue(sawResultPage.isAmazonResultVisible(), "Amazon result page is missing.");

        Assert.assertTrue(sawResultPage.isFilterButtonVisible(), "Filter button is missing.");
        sawResultPage.clickOnFilterButton();

        Assert.assertTrue(sawResultPage.isMovieButtonVisible(), "Movie button is missing.");
        sawResultPage.clickOnMovieButton();

        Assert.assertTrue(sawResultPage.isCloseFilterButtonVisible(), "Close Filter button is missing.");
        sawResultPage.clickOnCloseFilterButton();

        sawResultPage.getResultMoviesAsStrings();
        Assert.assertFalse(sawResultPage.isMoviesResultEmpty(), "Movies are not found.");
    }

    @TestRailCases(testCasesId = "12")
    @Test(description = "Open the Amazon home page and click on the Best Sellers and choose Books.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "android")
    public void checkBestSellers() {
        AmazonPageBase amazonPage = initPage(getDriver(), AmazonPageBase.class);
        amazonPage.openURL(AMAZON_LINK);
        Assert.assertTrue(amazonPage.isPageOpened(), "Amazon home page isn't opened.");

        Assert.assertTrue(amazonPage.isBestSellersButtonVisible(), "Best sellers button is missing.");
        amazonPage.clickOnBestSellersButton();

        Assert.assertTrue(amazonPage.isBooksButtonVisible(), "Books button is missing.");
        ProductListResultPageBase amazonBooksResultPage = amazonPage.clickOnBooksButton();
        Assert.assertTrue(amazonBooksResultPage.isBooksResultVisible(), "Books result is missing.");

    }

    @TestRailCases(testCasesId = "13")
    @Test(description = "Open the Amazon home page, click on the menu, choose Health & Household.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "android")
    public void checkHealthAndHousehold() {
        AmazonPageBase amazonPage = initPage(getDriver(), AmazonPageBase.class);
        amazonPage.openURL(AMAZON_LINK);
        Assert.assertTrue(amazonPage.isPageOpened(), "Amazon home page isn't opened.");

        Assert.assertTrue(amazonPage.isMenuButtonVisible(), "Hamburger Menu button is missing.");
        amazonPage.clickOnMenuButton();

        ProductListResultPageBase healthAndHouseholdResult = amazonPage.clickOnHealthAndHouseholdButton();
        Assert.assertTrue(healthAndHouseholdResult.isHealthAndHouseholdResultVisible()
                , "Health & Household result is missing.");

    }

    @TestRailCases(testCasesId = "14")
    @Test(description = "Open the Amazon home page, click on the Customer Service.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "android")
    public void checkCustomerService() {
        AmazonPageBase amazonPage = initPage(getDriver(), AmazonPageBase.class);
        amazonPage.openURL(AMAZON_LINK);
        Assert.assertTrue(amazonPage.isPageOpened(), "Amazon home page isn't opened.");

        Assert.assertTrue(amazonPage.isCustomerServiceButtonVisible(), "Customer Service button is missing.");
        ProductListResultPageBase customerServiceResultPage = amazonPage.clickOnCustomerServiceButton();
        Assert.assertEquals(customerServiceResultPage.getHelpText(), "Help", "Help text not equals.");
    }

    @TestRailCases(testCasesId = "15")
    @Test(description = "Open the Amazon home page and type invalid email.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "android")
    public void checkInvalidEmail() {
        AmazonPageBase amazonPage = initPage(getDriver(), AmazonPageBase.class);
        amazonPage.openURL(AMAZON_LINK);
        Assert.assertTrue(amazonPage.isPageOpened(), "Amazon home page isn't opened.");

        Assert.assertTrue(amazonPage.isSignInButtonVisible(), "Sign-in button is missing.");
        amazonPage.clickOnSignInButton();

        Assert.assertTrue(amazonPage.isEmailFieldVisible(), "Email field is missing.");
        amazonPage.typeEmail("saeidasa@gmail");
        Assert.assertEquals(amazonPage.getErrorText(), "No account found with email address"
                , "Error text not equals.");
    }

}
