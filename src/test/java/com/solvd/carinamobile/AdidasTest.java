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
        AdidasHomePageBase adidasHomePage = initPage(getDriver(), AdidasHomePageBase.class);
        adidasHomePage.open();
        Assert.assertTrue(adidasHomePage.isPageOpened(5), "Adidas home page isn't opened.");

        Assert.assertTrue(adidasHomePage.isProfileButtonPresent(), "Profile button isn't present.");
        adidasHomePage.clickOnProfileButton();

        Assert.assertTrue(adidasHomePage.isEmailFieldPresent(), "Email field isn't present.");
        adidasHomePage.typeEmail(R.CONFIG.get("email"));

        Assert.assertTrue(adidasHomePage.isContinueButtonVisible(), "Continue button isn't present.");
        adidasHomePage.clickOnContinueButton();

        Assert.assertTrue(adidasHomePage.isPasswordFieldPresent(), "Password field isn't present.");
        adidasHomePage.typePassword(R.CONFIG.get("password"));

        Assert.assertTrue(adidasHomePage.isLoginButtonVisible(), "Login button isn't present.");
        adidasHomePage.clickOnLoginButton();

        Assert.assertTrue(adidasHomePage.isVisitYourAccountPresent(), "Visit Your Account button is missing.");
        MyAccountPageBase myAccountPage = adidasHomePage.clickOnVisitYourAccountButton();
//        Assert.assertTrue(myAccountPage.isHomeUserStatusVisible(), "User status is missing.");
    }

    @TestRailCases(testCasesId = "3")
    @Test(description = "Open the Adidas home page and search special character in search box.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "android")
    public void checkSearchSpecialCharacter() {
        AdidasHomePageBase adidasHomePage = initPage(getDriver(), AdidasHomePageBase.class);
        adidasHomePage.open();
        Assert.assertTrue(adidasHomePage.isPageOpened(), "Adidas home page isn't opened.");
        adidasHomePage.clickOnSearchButton();
        Assert.assertTrue(adidasHomePage.isSearchFieldPresent(), "Search field not visible.");
        SearchBlockPageBase searchBlock = adidasHomePage.typeSpecialCharacter("#$%^&*");
        SearchResultPageBase resultPage = searchBlock.noResultForSearch();
        Assert.assertTrue(resultPage.isSearchNoContentTitleVisible(), "Search Title is missing.");
        Assert.assertTrue(resultPage.isSearchNoContentDescriptionVisible(), "Search description is missing.");
    }

    @TestRailCases(testCasesId = "4")
    @Test(description = "Open Adidas home page and click on wishlist button to open the wishlist page.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "android")
    public void checkWishListButton() {
        AdidasHomePageBase adidasHomePage = initPage(getDriver(), AdidasHomePageBase.class);
        adidasHomePage.open();
        Assert.assertTrue(adidasHomePage.isPageOpened(), "Adidas home page isn't opened.");
        Assert.assertTrue(adidasHomePage.isPopularProductPresent(), "Popular product isn't present.");
        adidasHomePage.clickOnFirstPopularProduct();
        WishlistPageBase wishlistPage = adidasHomePage.clickOnWishListButton();
//        Assert.assertTrue(wishlistPage.isProductListEmpty(), "Result page isn't opened.");
    }

    @TestRailCases(testCasesId = "5")
    @Test(description = "Open the Adidas Home page and search product.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "android")
    public void checkSearchSomeProduct() {
        AdidasHomePageBase adidasHomePage = initPage(getDriver(), AdidasHomePageBase.class);
        adidasHomePage.open();
        Assert.assertTrue(adidasHomePage.isPageOpened(), "Adidas home page isn't opened.");

        Assert.assertTrue(adidasHomePage.isSearchButtonVisible(), "Search button isn't visible.");
        adidasHomePage.clickOnSearchButton();

        Assert.assertTrue(adidasHomePage.isSearchFieldPresent(), "Search box isn't present.");
        SearchBlockPageBase searchBlock = adidasHomePage.searchProduct("cap");

        Assert.assertTrue(searchBlock.isNewFrameVisible(), "Result page isn't opened.");
        ProductListResultPageBase searchResultPage = searchBlock.clickOnCapButton();

        Assert.assertTrue(searchResultPage.isProductListNotEmpty(), "Search result page is empty.");
    }

    @TestRailCases(testCasesId = "6")
    @Test(description = "Using LowPrice to HighPrice filter on AccessoriesPage.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "android")
    public void verifyLowPriceToHighPriceFilter() {
        AccessoriesPageBase accessoriesPage = initPage(getDriver(), AccessoriesPageBase.class);
        accessoriesPage.openURL(ACCESSORIES_LINK);
        Assert.assertTrue(accessoriesPage.isPageOpened(5), "Accessories page isn't opened.");

        Assert.assertTrue(accessoriesPage.isFooterContainerPresent(), "Footer container is missing.");
        accessoriesPage.scrollDownPage();

        int firstUnSortProduct = accessoriesPage.getProductPricesAsNumbers().get(0);
        int secondUnSortProduct = accessoriesPage.getProductPricesAsNumbers().get(2);
        int thirdUnSortProduct = accessoriesPage.getProductPricesAsNumbers().get(3);
        int fourthUnSortProduct = accessoriesPage.getProductPricesAsNumbers().get(5);

        Assert.assertTrue(accessoriesPage.isFilterButtonPresent(), "Filter button isn't visible.");
        accessoriesPage.clickFilterButton();

        Assert.assertTrue(accessoriesPage.isSortByButtonPresent(), "'SORT BY' button isn't present.");
        FilterBlockPageBase filterBlockPage = accessoriesPage.clickOnSortByButton();

        Assert.assertTrue(filterBlockPage.isLowPriceToHighPriceButtonPresent(),
                "LowPrice to HighPrice filter button is not visible.");
        ProductListResultPageBase lowPriceToHighPricePage = filterBlockPage.clickOnLowPriceToHighButton();

        Assert.assertTrue(lowPriceToHighPricePage.isPopupVisible(), "Popup button isn't visible.");
        lowPriceToHighPricePage.clickOnClosePopUp();

        lowPriceToHighPricePage.scrollDownPage();

        int firstSortProduct = lowPriceToHighPricePage.getResultPricesAsNumbers().get(0);
        Assert.assertNotEquals(firstUnSortProduct, firstSortProduct, "First products are equals.");

        int secondSortProduct = lowPriceToHighPricePage.getResultPricesAsNumbers().get(2);
        Assert.assertNotEquals(secondUnSortProduct, secondSortProduct, "Second products are equals.");

        int thirdSortProduct = lowPriceToHighPricePage.getResultPricesAsNumbers().get(3);
        Assert.assertNotEquals(thirdUnSortProduct, thirdSortProduct, "Third products are equals.");

        int fourthSortProduct = lowPriceToHighPricePage.getResultPricesAsNumbers().get(5);
        Assert.assertNotEquals(fourthUnSortProduct, fourthSortProduct, "Fourth products are equals.");
    }

    @TestRailCases(testCasesId = "7")
    @Test(description = "Using HighPrice to LowPrice filter on AccessoriesPage.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "android")
    public void verifyHighPriceToLowPriceFilter() {
        AccessoriesPageBase accessoriesPage = initPage(getDriver(), AccessoriesPageBase.class);
        accessoriesPage.openURL(ACCESSORIES_LINK);
        Assert.assertTrue(accessoriesPage.isPageOpened(5), "Accessories page isn't opened.");
        Assert.assertTrue(accessoriesPage.isFooterContainerPresent(), "Footer container is missing.");
        accessoriesPage.scrollDownPage();
        int firstUnSortProduct = accessoriesPage.getProductPricesAsNumbers().get(0);
        int secondUnSortProduct = accessoriesPage.getProductPricesAsNumbers().get(1);
        int thirdUnSortProduct = accessoriesPage.getProductPricesAsNumbers().get(2);
        int fourthUnSortProduct = accessoriesPage.getProductPricesAsNumbers().get(5);
        Assert.assertTrue(accessoriesPage.isFilterButtonPresent(), "Filter button isn't visible.");
        accessoriesPage.clickFilterButton();
        Assert.assertTrue(accessoriesPage.isSortByButtonPresent(), "'SORT BY' button isn't present.");
        FilterBlockPageBase filterBlockPage = accessoriesPage.clickOnSortByButton();
        Assert.assertTrue(filterBlockPage.isHighPriceToLowPriceButtonPresent(),
                "HighPrice to LowPrice  filter button is not visible.");
        ProductListResultPageBase highPriceToLowPricePage = filterBlockPage.clickOnHighPriceToLowButton();
        Assert.assertTrue(highPriceToLowPricePage.isPopupVisible(), "Popup button isn't visible.");
        highPriceToLowPricePage.clickOnClosePopUp();
        highPriceToLowPricePage.scrollDownPage();
        int firstSortProduct = highPriceToLowPricePage.getResultPricesAsNumbers().get(0);
        Assert.assertNotEquals(firstUnSortProduct, firstSortProduct, "First products are equals.");
        int secondSortProduct = highPriceToLowPricePage.getResultPricesAsNumbers().get(1);
        Assert.assertNotEquals(secondUnSortProduct, secondSortProduct, "Second products are equals.");
        int thirdSortProduct = highPriceToLowPricePage.getResultPricesAsNumbers().get(2);
        Assert.assertNotEquals(thirdUnSortProduct, thirdSortProduct, "Third products are equals.");
        int fourthSortProduct = highPriceToLowPricePage.getResultPricesAsNumbers().get(5);
        Assert.assertNotEquals(fourthUnSortProduct, fourthSortProduct, "Fourth products are equals.");
    }

    @TestRailCases(testCasesId = "8")
    @Test(description = "Using TOP SELLERS filter on AccessoriesPage.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "android")
    public void verifyTopSellersFilter() {
        AccessoriesPageBase accessoriesPage = initPage(getDriver(), AccessoriesPageBase.class);
        accessoriesPage.openURL(ACCESSORIES_LINK);
        Assert.assertTrue(accessoriesPage.isPageOpened(5), "Accessories page isn't opened.");

        Assert.assertTrue(accessoriesPage.isFooterContainerPresent(), "Footer container is missing.");
        accessoriesPage.scrollDownPage();

        int firstUnSortProduct = accessoriesPage.getProductPricesAsNumbers().get(0);
        int secondUnSortProduct = accessoriesPage.getProductPricesAsNumbers().get(1);
        int thirdUnSortProduct = accessoriesPage.getProductPricesAsNumbers().get(3);
        int fourthUnSortProduct = accessoriesPage.getProductPricesAsNumbers().get(5);

        Assert.assertTrue(accessoriesPage.isFilterButtonPresent(), "Filter button isn't visible.");
        accessoriesPage.clickFilterButton();

        Assert.assertTrue(accessoriesPage.isSortByButtonPresent(), "'SORT BY' button isn't present.");
        FilterBlockPageBase filterBlockPage = accessoriesPage.clickOnSortByButton();

        Assert.assertTrue(filterBlockPage.isTopSellersButtonPresent(),
                "TOP SELLERS filter button is not visible.");
        ProductListResultPageBase topSellersPage = filterBlockPage.clickOnTopSellersButton();

        Assert.assertTrue(topSellersPage.isPopupVisible(), "Popup button isn't visible.");
        topSellersPage.clickOnClosePopUp();

        topSellersPage.scrollDownPage();

        int firstSortProduct = topSellersPage.getResultPricesAsNumbers().get(0);
        Assert.assertNotEquals(firstUnSortProduct, firstSortProduct, "First products are equals.");

        int secondSortProduct = topSellersPage.getResultPricesAsNumbers().get(1);
        Assert.assertNotEquals(secondUnSortProduct, secondSortProduct, "Second products are equals.");

        int thirdSortProduct = topSellersPage.getResultPricesAsNumbers().get(3);
        Assert.assertNotEquals(thirdUnSortProduct, thirdSortProduct, "Third products are equals.");

        int fourthSortProduct = topSellersPage.getResultPricesAsNumbers().get(5);
        Assert.assertNotEquals(fourthUnSortProduct, fourthSortProduct, "Fourth products are equals.");
    }

    @TestRailCases(testCasesId = "9")
    @Test(description = "Adding product to wishlist from Accessories page.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "android")
    public void checkAddProductToWishlist() {
        AccessoriesPageBase accessoriesPage = initPage(getDriver(), AccessoriesPageBase.class);
        accessoriesPage.openURL(ACCESSORIES_LINK);
        Assert.assertTrue(accessoriesPage.isPageOpened(5), "Adidas home page is not opened.");
        accessoriesPage.addProductToWishList(1);
        accessoriesPage.addProductToWishList(2);
        Assert.assertTrue(accessoriesPage.isPopupVisible(), "Popup button isn't visible.");
        accessoriesPage.clickOnClosePopUp();
        Assert.assertFalse(accessoriesPage.isPopupVisible(), "Popup button is visible.");
        accessoriesPage.addProductToWishList(3);
        ProductListResultPageBase wishlistResult = accessoriesPage.clickOnWishListButton();
        Assert.assertFalse(accessoriesPage.isWishlistListEmpty(), "Wishlist page is empty.");
    }

}