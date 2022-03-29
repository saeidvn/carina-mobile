package com.solvd.carinamobile;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.report.testrail.TestRailCases;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.carinamobile.page.common.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AdidasTest implements IAbstractTest {

    private static final String ACCESSORIES_LINK = "https://www.adidas.co.uk/y_3-accessories";

    @TestRailCases(testCasesId = "1")
    @Test(description = "Check help button.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "android")
    public void checkHelpButtons() {
        AdidasHomePageBase adidasHomePage = initPage(getDriver(), AdidasHomePageBase.class);
        adidasHomePage.open();
        Assert.assertTrue(adidasHomePage.isPageOpened(), "Adidas home page isn't open.");
        HelpPageBase helpPage = adidasHomePage.clickOnHelpButton();
        Assert.assertTrue(helpPage.isHelpContentTitleVisible(), "Help Content is missing.");
    }

    @TestRailCases(testCasesId = "2")
    @Test(description = "Open the Adidas home page and login to account.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "android")
    public void checkLoginToAccount() {
        SoftAssert softAssert = new SoftAssert();
        AdidasHomePageBase adidasHomePage = initPage(getDriver(), AdidasHomePageBase.class);
        adidasHomePage.open();
        softAssert.assertTrue(adidasHomePage.isPageOpened(5), "Adidas home page isn't opened.");
        softAssert.assertTrue(adidasHomePage.isProfileButtonVisible(), "Profile button isn't visible.");
        adidasHomePage.clickOnProfileButton();
        softAssert.assertTrue(adidasHomePage.isEmailFieldVisible(), "Email field isn't visible.");
        adidasHomePage.typeEmail(R.CONFIG.get("email"));
        softAssert.assertTrue(adidasHomePage.isContinueButtonVisible(), "Continue button isn't visible.");
        adidasHomePage.clickOnContinueButton();
        softAssert.assertTrue(adidasHomePage.isPasswordFieldVisible(), "Password field isn't visible.");
        adidasHomePage.typePassword(R.CONFIG.get("password"));
        softAssert.assertTrue(adidasHomePage.isLoginButtonVisible(), "Login button isn't visible.");
        adidasHomePage.clickOnLoginButton();
        softAssert.assertTrue(adidasHomePage.isVisitYourAccountVisible(), "Visit Your Account button is missing.");
        MyAccountPageBase myAccountPage = adidasHomePage.clickOnVisitYourAccountButton();
        softAssert.assertTrue(myAccountPage.isHomeUserStatusVisible(), "User status is missing.");
        softAssert.assertAll();
    }

    @TestRailCases(testCasesId = "3")
    @Test(description = "Open the Adidas home page and search special character in search box.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "android")
    public void checkSearchSpecialCharacter() {
        SoftAssert softAssert = new SoftAssert();
        AdidasHomePageBase adidasHomePage = initPage(getDriver(), AdidasHomePageBase.class);
        adidasHomePage.open();
        softAssert.assertTrue(adidasHomePage.isPageOpened(), "Adidas home page isn't opened.");
        adidasHomePage.clickOnSearchButton();
        softAssert.assertTrue(adidasHomePage.isSearchFieldVisible(), "Search field not visible.");
        SearchBlockPageBase searchBlock = adidasHomePage.typeSpecialCharacter("#$%^&*");
        SearchResultPageBase resultPage = searchBlock.noResultForSearch();
        softAssert.assertTrue(resultPage.isSearchNoContentTitleVisible(), "Search Title is missing.");
        softAssert.assertTrue(resultPage.isSearchNoContentDescriptionVisible(), "Search description is missing.");
        softAssert.assertAll();
    }

    @TestRailCases(testCasesId = "4")
    @Test(description = "Open Adidas home page and click on wishlist button to open the wishlist page.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "android")
    public void checkWishListButton() {
        AccessoriesPageBase accessoriesPage = initPage(getDriver(), AccessoriesPageBase.class);
        accessoriesPage.openURL(ACCESSORIES_LINK);
        Assert.assertTrue(accessoriesPage.isPageOpened(), "Accessories page isn't opened.");
        WishlistPageBase wishlistPage = accessoriesPage.clickOnWishlistButton();
        Assert.assertTrue(wishlistPage.isProductListEmpty(), "Result page isn't opened.");
    }

    @TestRailCases(testCasesId = "5")
    @Test(description = "Open the Adidas Home page and search product.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "android")
    public void checkSearchSomeProduct() {
        SoftAssert softAssert = new SoftAssert();
        AdidasHomePageBase adidasHomePage = initPage(getDriver(), AdidasHomePageBase.class);
        adidasHomePage.open();
        softAssert.assertTrue(adidasHomePage.isPageOpened(), "Adidas home page isn't opened.");
        softAssert.assertTrue(adidasHomePage.isSearchButtonVisible(), "Search button isn't visible.");
        adidasHomePage.clickOnSearchButton();
        softAssert.assertTrue(adidasHomePage.isSearchFieldVisible(), "Search box isn't visible.");
        SearchBlockPageBase searchBlock = adidasHomePage.searchProduct("cap");
        softAssert.assertTrue(searchBlock.isNewFrameVisible(), "Result page isn't opened.");
        ProductListResultPageBase searchResultPage = searchBlock.clickOnCapButton();
        softAssert.assertTrue(searchResultPage.isProductListNotEmpty(), "Search result page is empty.");
        softAssert.assertAll();
    }

    @TestRailCases(testCasesId = "6")
    @Test(description = "Using LowPrice to HighPrice filter on AccessoriesPage.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "android")
    public void verifyLowPriceToHighPriceFilter() {
        SoftAssert softAssert = new SoftAssert();
        AccessoriesPageBase accessoriesPage = initPage(getDriver(), AccessoriesPageBase.class);
        accessoriesPage.openURL(ACCESSORIES_LINK);
        softAssert.assertTrue(accessoriesPage.isPageOpened(5), "Accessories page isn't opened.");
        softAssert.assertTrue(accessoriesPage.isFooterContainerVisible(), "Footer container is missing.");
        accessoriesPage.scrollDownPage();
        int firstUnSortProduct = accessoriesPage.getResultPricesAsNumbers().get(0);
        int secondUnSortProduct = accessoriesPage.getResultPricesAsNumbers().get(2);
        int thirdUnSortProduct = accessoriesPage.getResultPricesAsNumbers().get(3);
        int fourthUnSortProduct = accessoriesPage.getResultPricesAsNumbers().get(5);
        softAssert.assertTrue(accessoriesPage.isFilterButtonVisible(), "Filter button isn't visible.");
        accessoriesPage.clickFilterButton();
        softAssert.assertTrue(accessoriesPage.isSortByButtonVisible(), "'SORT BY' button isn't visible.");
        FilterBlockPageBase filterBlockPage = accessoriesPage.clickOnSortByButton();
        softAssert.assertTrue(filterBlockPage.isLowPriceToHighPriceButtonVisible(),
                "LowPrice to HighPrice filter button is not visible.");
        ProductListResultPageBase lowPriceToHighPricePage = filterBlockPage.clickOnLowPriceToHighButton();
        softAssert.assertTrue(lowPriceToHighPricePage.isPopupVisible(), "Popup button isn't visible.");
        lowPriceToHighPricePage.clickOnClosePopUp();
        lowPriceToHighPricePage.scrollDownPage();
        int firstSortProduct = lowPriceToHighPricePage.getResultPricesAsNumbers().get(0);
        softAssert.assertNotEquals(firstUnSortProduct, firstSortProduct, "First products are equals.");
        int secondSortProduct = lowPriceToHighPricePage.getResultPricesAsNumbers().get(2);
        softAssert.assertNotEquals(secondUnSortProduct, secondSortProduct, "Second products are equals.");
        int thirdSortProduct = lowPriceToHighPricePage.getResultPricesAsNumbers().get(3);
        softAssert.assertNotEquals(thirdUnSortProduct, thirdSortProduct, "Third products are equals.");
        int fourthSortProduct = lowPriceToHighPricePage.getResultPricesAsNumbers().get(5);
        softAssert.assertNotEquals(fourthUnSortProduct, fourthSortProduct, "Fourth products are equals.");
        softAssert.assertAll();
    }

    @TestRailCases(testCasesId = "7")
    @Test(description = "Using HighPrice to LowPrice filter on AccessoriesPage.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "android")
    public void verifyHighPriceToLowPriceFilter() {
        SoftAssert softAssert = new SoftAssert();
        AccessoriesPageBase accessoriesPage = initPage(getDriver(), AccessoriesPageBase.class);
        accessoriesPage.openURL(ACCESSORIES_LINK);
        softAssert.assertTrue(accessoriesPage.isPageOpened(5), "Accessories page isn't opened.");
        softAssert.assertTrue(accessoriesPage.isFooterContainerVisible(), "Footer container is missing.");
        accessoriesPage.scrollDownPage();
        int firstUnSortProduct = accessoriesPage.getResultPricesAsNumbers().get(0);
        int secondUnSortProduct = accessoriesPage.getResultPricesAsNumbers().get(1);
        int thirdUnSortProduct = accessoriesPage.getResultPricesAsNumbers().get(2);
        int fourthUnSortProduct = accessoriesPage.getResultPricesAsNumbers().get(5);
        softAssert.assertTrue(accessoriesPage.isFilterButtonVisible(), "Filter button isn't visible.");
        accessoriesPage.clickFilterButton();
        softAssert.assertTrue(accessoriesPage.isSortByButtonVisible(), "'SORT BY' button isn't visible.");
        FilterBlockPageBase filterBlockPage = accessoriesPage.clickOnSortByButton();
        softAssert.assertTrue(filterBlockPage.isHighPriceToLowPriceButtonVisible(),
                "HighPrice to LowPrice  filter button is not visible.");
        ProductListResultPageBase highPriceToLowPricePage = filterBlockPage.clickOnHighPriceToLowButton();
        softAssert.assertTrue(highPriceToLowPricePage.isPopupVisible(), "Popup button isn't visible.");
        highPriceToLowPricePage.clickOnClosePopUp();
        highPriceToLowPricePage.scrollDownPage();
        int firstSortProduct = highPriceToLowPricePage.getResultPricesAsNumbers().get(0);
        softAssert.assertNotEquals(firstUnSortProduct, firstSortProduct, "First products are equals.");
        int secondSortProduct = highPriceToLowPricePage.getResultPricesAsNumbers().get(1);
        softAssert.assertNotEquals(secondUnSortProduct, secondSortProduct, "Second products are equals.");
        int thirdSortProduct = highPriceToLowPricePage.getResultPricesAsNumbers().get(2);
        softAssert.assertNotEquals(thirdUnSortProduct, thirdSortProduct, "Third products are equals.");
        int fourthSortProduct = highPriceToLowPricePage.getResultPricesAsNumbers().get(5);
        softAssert.assertNotEquals(fourthUnSortProduct, fourthSortProduct, "Fourth products are equals.");
        softAssert.assertAll();
    }

    @TestRailCases(testCasesId = "8")
    @Test(description = "Using TOP SELLERS filter on AccessoriesPage.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "android")
    public void verifyTopSellersFilter() {
        SoftAssert softAssert = new SoftAssert();
        AccessoriesPageBase accessoriesPage = initPage(getDriver(), AccessoriesPageBase.class);
        accessoriesPage.openURL(ACCESSORIES_LINK);
        softAssert.assertTrue(accessoriesPage.isPageOpened(5), "Accessories page isn't opened.");
        softAssert.assertTrue(accessoriesPage.isFooterContainerVisible(), "Footer container is missing.");
        accessoriesPage.scrollDownPage();
        int firstUnSortProduct = accessoriesPage.getResultPricesAsNumbers().get(0);
        int secondUnSortProduct = accessoriesPage.getResultPricesAsNumbers().get(2);
        int thirdUnSortProduct = accessoriesPage.getResultPricesAsNumbers().get(3);
        int fourthUnSortProduct = accessoriesPage.getResultPricesAsNumbers().get(5);
        softAssert.assertTrue(accessoriesPage.isFilterButtonVisible(), "Filter button isn't visible.");
        accessoriesPage.clickFilterButton();
        softAssert.assertTrue(accessoriesPage.isSortByButtonVisible(), "'SORT BY' button isn't visible.");
        FilterBlockPageBase filterBlockPage = accessoriesPage.clickOnSortByButton();
        softAssert.assertTrue(filterBlockPage.isTopSellersButtonVisible(),
                "TOP SELLERS filter button is not visible.");
        ProductListResultPageBase topSellersPage = filterBlockPage.clickOnTopSellersButton();
        softAssert.assertTrue(topSellersPage.isPopupVisible(), "Popup button isn't visible.");
        topSellersPage.clickOnClosePopUp();
        topSellersPage.scrollDownPage();
        int firstSortProduct = topSellersPage.getResultPricesAsNumbers().get(0);
        softAssert.assertNotEquals(firstUnSortProduct, firstSortProduct, "First products are equals.");
        int secondSortProduct = topSellersPage.getResultPricesAsNumbers().get(2);
        softAssert.assertNotEquals(secondUnSortProduct, secondSortProduct, "Second products are equals.");
        int thirdSortProduct = topSellersPage.getResultPricesAsNumbers().get(3);
        softAssert.assertNotEquals(thirdUnSortProduct, thirdSortProduct, "Third products are equals.");
        int fourthSortProduct = topSellersPage.getResultPricesAsNumbers().get(5);
        softAssert.assertNotEquals(fourthUnSortProduct, fourthSortProduct, "Fourth products are equals.");
        softAssert.assertAll();
    }

    @TestRailCases(testCasesId = "9")
    @Test(description = "Adding product to wishlist from Accessories page.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "android")
    public void checkAddProductToWishlist() {
        SoftAssert softAssert = new SoftAssert();
        AccessoriesPageBase accessoriesPage = initPage(getDriver(), AccessoriesPageBase.class);
        accessoriesPage.openURL(ACCESSORIES_LINK);
        softAssert.assertTrue(accessoriesPage.isPageOpened(5), "Accessories page isn't opened.");
        accessoriesPage.addProductToWishList(1);
        accessoriesPage.addProductToWishList(2);
        softAssert.assertTrue(accessoriesPage.isPopupVisible(), "Popup button isn't visible.");
        accessoriesPage.clickOnClosePopUp();
        accessoriesPage.addProductToWishList(3);
        ProductListResultPageBase wishlistResult = accessoriesPage.clickOnWishListButton();
        accessoriesPage.clickOnClosePopUp();
        softAssert.assertFalse(accessoriesPage.isWishlistListEmpty(), "Wishlist page is empty.");
        softAssert.assertEquals(wishlistResult.getWishlistText(), "MY WISHLIST",
                "Incorrect wishlist text.");
        softAssert.assertAll();
    }
}