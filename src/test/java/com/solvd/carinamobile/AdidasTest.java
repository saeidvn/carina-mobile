package com.solvd.carinamobile;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.report.testrail.TestRailCases;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.carinamobile.page.common.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdidasTest implements IAbstractTest, IMobileUtils {

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

//        Assert.assertTrue(adidasHomePage.isPasswordFieldPresent(), "Password field isn't present.");
        adidasHomePage.typePassword(R.CONFIG.get("password"));

//        Assert.assertTrue(adidasHomePage.isLoginBtnVisible(), "Login button isn't present.");
//        adidasHomePage.clickOnLoginBtn();

//        Assert.assertTrue(adidasHomePage.isVisitYourAccountPresent(), "");
//        MyAccountPage myAccountPage = adidasHomePage.clickOnVisitYourAccountButton();
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
        Assert.assertTrue(wishlistPage.isProductListEmpty(), "Result page isn't opened.");
    }

    @TestRailCases(testCasesId = "5")
    @Test(description = "Open the Adidas Home page and search product.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "android")
    public void checkSearchSomeProduct() {
        AdidasHomePageBase adidasHomePage = initPage(getDriver(), AdidasHomePageBase.class);
        adidasHomePage.open();
        Assert.assertTrue(adidasHomePage.isPageOpened(), "Adidas home page isn't opened.");

        adidasHomePage.clickOnSearchButton();

        Assert.assertTrue(adidasHomePage.isSearchFieldPresent(), "Search box isn't present.");
        SearchBlockPageBase searchBlock = adidasHomePage.searchProduct("cap");

        Assert.assertTrue(searchBlock.isNewFrameVisible(), "Result page isn't opened.");
        ProductListResultPageBase searchResultPage = searchBlock.clickOnCapBtn();

        Assert.assertTrue(searchResultPage.isProductListNotEmpty(), "Search result page is empty.");
    }

    @TestRailCases(testCasesId = "6")
    @Test(description = "Using LowPrice to HighPrice filter on AccessoriesPage.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "android")
    public void verifyLowPriceToHighPriceFilter() {
        int firstUnSortProduct, firstSortProduct;
        int secondUnSortProduct, secondSortProduct;
        int thirdUnSortProduct, thirdSortProduct;
        int fourthUnSortProduct, fourthSortProduct;

        AccessoriesPageBase accessoriesPage = initPage(getDriver(), AccessoriesPageBase.class);
        accessoriesPage.openURL(ACCESSORIES_LINK);
        Assert.assertTrue(accessoriesPage.isPageOpened(5), "Accessories page isn't opened.");

        Assert.assertTrue(accessoriesPage.isFooterContainerPresent(), "Footer container is missing.");
        accessoriesPage.scrollDownPage();

        firstUnSortProduct = accessoriesPage.getProductPricesAsNumbers().get(0);
        secondUnSortProduct = accessoriesPage.getProductPricesAsNumbers().get(2);
        thirdUnSortProduct = accessoriesPage.getProductPricesAsNumbers().get(3);
        fourthUnSortProduct = accessoriesPage.getProductPricesAsNumbers().get(5);

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

        firstSortProduct = lowPriceToHighPricePage.getResultPricesAsNumbers().get(0);
        Assert.assertNotEquals(firstUnSortProduct, firstSortProduct, "First products are equals.");

        secondSortProduct = lowPriceToHighPricePage.getResultPricesAsNumbers().get(2);
        Assert.assertNotEquals(secondUnSortProduct, secondSortProduct, "Second products are equals.");

        thirdSortProduct = lowPriceToHighPricePage.getResultPricesAsNumbers().get(3);
        Assert.assertNotEquals(thirdUnSortProduct, thirdSortProduct, "Third products are equals.");

        fourthSortProduct = lowPriceToHighPricePage.getResultPricesAsNumbers().get(5);
        Assert.assertNotEquals(fourthUnSortProduct, fourthSortProduct, "Fourth products are equals.");
    }

    @TestRailCases(testCasesId = "7")
    @Test(description = "Using HighPrice to LowPrice filter on AccessoriesPage.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "android")
    public void verifyHighPriceToLowPriceFilter() {
        int firstUnSortProduct, firstSortProduct;
        int secondUnSortProduct, secondSortProduct;
        int thirdUnSortProduct, thirdSortProduct;
        int fourthUnSortProduct, fourthSortProduct;

        AccessoriesPageBase accessoriesPage = initPage(getDriver(), AccessoriesPageBase.class);
        accessoriesPage.openURL(ACCESSORIES_LINK);
        Assert.assertTrue(accessoriesPage.isPageOpened(5), "Accessories page isn't opened.");

        Assert.assertTrue(accessoriesPage.isFooterContainerPresent(), "Footer container is missing.");
        accessoriesPage.scrollDownPage();

        firstUnSortProduct = accessoriesPage.getProductPricesAsNumbers().get(0);
        secondUnSortProduct = accessoriesPage.getProductPricesAsNumbers().get(1);
        thirdUnSortProduct = accessoriesPage.getProductPricesAsNumbers().get(2);
        fourthUnSortProduct = accessoriesPage.getProductPricesAsNumbers().get(5);

        Assert.assertTrue(accessoriesPage.isFilterButtonPresent(), "Filter button isn't visible.");
        accessoriesPage.clickFilterButton();

        Assert.assertTrue(accessoriesPage.isSortByButtonPresent(), "'SORT BY' button isn't present.");
        FilterBlockPageBase filterBlockPage = accessoriesPage.clickOnSortByButton();

        Assert.assertTrue(filterBlockPage.isLowPriceToHighPriceButtonPresent(),
                "HighPrice to LowPrice  filter button is not visible.");
        ProductListResultPageBase highPriceToLowPricePage = filterBlockPage.clickOnHighPriceToLowButton();

        Assert.assertTrue(highPriceToLowPricePage.isPopupVisible(), "Popup button isn't visible.");
        highPriceToLowPricePage.clickOnClosePopUp();

        highPriceToLowPricePage.scrollDownPage();

        firstSortProduct = highPriceToLowPricePage.getResultPricesAsNumbers().get(0);
        Assert.assertNotEquals(firstUnSortProduct, firstSortProduct, "First products are equals.");

        secondSortProduct = highPriceToLowPricePage.getResultPricesAsNumbers().get(1);
        Assert.assertNotEquals(secondUnSortProduct, secondSortProduct, "Second products are equals.");

        thirdSortProduct = highPriceToLowPricePage.getResultPricesAsNumbers().get(2);
        Assert.assertNotEquals(thirdUnSortProduct, thirdSortProduct, "Third products are equals.");

        fourthSortProduct = highPriceToLowPricePage.getResultPricesAsNumbers().get(5);
        Assert.assertNotEquals(fourthUnSortProduct, fourthSortProduct, "Fourth products are equals.");
    }

    @TestRailCases(testCasesId = "8")
    @Test(description = "Using TOP SELLERS filter on AccessoriesPage.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "android")
    public void verifyTopSellersFilter() {
        int firstUnSortProduct, firstSortProduct;
        int secondUnSortProduct, secondSortProduct;
        int thirdUnSortProduct, thirdSortProduct;
        int fourthUnSortProduct, fourthSortProduct;

        AccessoriesPageBase accessoriesPage = initPage(getDriver(), AccessoriesPageBase.class);
        accessoriesPage.openURL(ACCESSORIES_LINK);
        Assert.assertTrue(accessoriesPage.isPageOpened(5), "Accessories page isn't opened.");

        Assert.assertTrue(accessoriesPage.isFooterContainerPresent(), "Footer container is missing.");
        accessoriesPage.scrollDownPage();

        firstUnSortProduct = accessoriesPage.getProductPricesAsNumbers().get(0);
        secondUnSortProduct = accessoriesPage.getProductPricesAsNumbers().get(1);
        thirdUnSortProduct = accessoriesPage.getProductPricesAsNumbers().get(3);
        fourthUnSortProduct = accessoriesPage.getProductPricesAsNumbers().get(5);

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

        firstSortProduct = topSellersPage.getResultPricesAsNumbers().get(0);
        Assert.assertNotEquals(firstUnSortProduct, firstSortProduct, "First products are equals.");

        secondSortProduct = topSellersPage.getResultPricesAsNumbers().get(1);
        Assert.assertNotEquals(secondUnSortProduct, secondSortProduct, "Second products are equals.");

        thirdSortProduct = topSellersPage.getResultPricesAsNumbers().get(3);
        Assert.assertNotEquals(thirdUnSortProduct, thirdSortProduct, "Third products are equals.");

        fourthSortProduct = topSellersPage.getResultPricesAsNumbers().get(5);
        Assert.assertNotEquals(fourthUnSortProduct, fourthSortProduct, "Fourth products are equals.");
    }

    @TestRailCases(testCasesId = "9")
    @Test(description = "Adding product to wishlist from Accessories page.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "android")
    public void checkAddProductToWishlist() {
        AccessoriesPageBase accessoriesPage = initPage(getDriver(), AccessoriesPageBase.class);
        accessoriesPage.openURL(ACCESSORIES_LINK);
        Assert.assertTrue(accessoriesPage.isPageOpened(5), "Adidas home page is not opened.");

        /**
         *   add first and second product to wishlist
         */
        accessoriesPage.addProductToWishList(1);
        accessoriesPage.addProductToWishList(2);

        Assert.assertTrue(accessoriesPage.isPopupVisible(), "Popup button isn't visible.");
        accessoriesPage.clickOnClosePopUp();
        Assert.assertFalse(accessoriesPage.isPopupVisible(), "Popup button is visible.");

        /**
         *   add third product to wishlist
         */
        accessoriesPage.addProductToWishList(3);

        ProductListResultPageBase wishlistResult = accessoriesPage.clickOnWishListButton();
        Assert.assertFalse(accessoriesPage.isWishlistListEmpty(), "Wishlist page is empty.");
    }

}