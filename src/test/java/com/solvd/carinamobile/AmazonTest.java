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
    @Test(description = "Open the Amazon home page and login to account.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "android")
    public void checkLoginToAccount() {
        AmazonPageBase amazonPage = initPage(getDriver(), AmazonPageBase.class);
        amazonPage.openURL(AMAZON_LINK);
        Assert.assertTrue(amazonPage.isPageOpened(), "Amazon home page isn't opened.");

        Assert.assertTrue(amazonPage.isSignInButtonVisible(), "Sign-in button is missing.");
        amazonPage.clickOnSignInButton();

        Assert.assertTrue(amazonPage.isBestSellersButtonVisible(), "Best sellers button is missing.");
        amazonPage.clickOnBestSellersButton();

        Assert.assertTrue(amazonPage.isBooksButtonVisible(), "Books button is missing.");
        amazonPage.clickOnBooksButton();
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

}
