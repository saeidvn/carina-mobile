package com.solvd.carinamobile;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.report.testrail.TestRailCases;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.carinamobile.page.common.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

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
        Assert.assertTrue(accessoriesPage.isPageOpened(5), "Adidas home page isn't opened.");

        Assert.assertTrue(accessoriesPage.isFooterContainerPresent(), "Footer container is missing.");
        accessoriesPage.scrollDownPage();

        firstUnSortProduct = accessoriesPage.getProductPricesAsNumbers().get(0);
        secondUnSortProduct = accessoriesPage.getProductPricesAsNumbers().get(2);
        thirdUnSortProduct = accessoriesPage.getProductPricesAsNumbers().get(3);
        fourthUnSortProduct = accessoriesPage.getProductPricesAsNumbers().get(5);

        Assert.assertTrue(accessoriesPage.isFilterButtonPresent(), "Filter button isn't visible.");
//        FilterBlockPageBase filterBlockPage = accessoriesPage.clickFilterButton();
        accessoriesPage.clickFilterButton();

        Assert.assertTrue(accessoriesPage.isSortByButtonPresent(), "Sort by button isn't present.");
        FilterBlockPageBase filterBlockPage = accessoriesPage.clickOnSortByButton();

        Assert.assertTrue(filterBlockPage.isLowPriceToHighPriceButtonPresent(),
                "LowPrice to HighPrice filter button is not visible.");
        ProductListResultPageBase lowPriceToHighPricePage = filterBlockPage.clickOnLowPriceToHighButton();

//        Assert.assertTrue(filterBlockPage.isApplyButtonPresent(), "Apply button is not present.");
//        ProductListResultPageBase lowPriceToHighPricePage = filterBlockPage.clickOnApplyButton();
//
//        Assert.assertTrue(lowPriceToHighPricePage.isPopupVisible(), "Popup button isn't visible.");
//        lowPriceToHighPricePage.clickOnClosePopUp();
//        Assert.assertFalse(lowPriceToHighPricePage.isPopupVisible(), "Popup button is visible.");
//
        lowPriceToHighPricePage.scrollDownPage();

        firstSortProduct = lowPriceToHighPricePage.getResultPricesAsNumbers().get(0);
        Assert.assertNotEquals(firstUnSortProduct, firstSortProduct, "Products are equals.");

        secondSortProduct = lowPriceToHighPricePage.getResultPricesAsNumbers().get(2);
        Assert.assertNotEquals(secondUnSortProduct, secondSortProduct, "Products are equals.");

        thirdSortProduct = lowPriceToHighPricePage.getResultPricesAsNumbers().get(3);
        Assert.assertNotEquals(thirdUnSortProduct, thirdSortProduct, "Products are equals.");

        fourthSortProduct = lowPriceToHighPricePage.getResultPricesAsNumbers().get(5);
        Assert.assertNotEquals(fourthUnSortProduct, fourthSortProduct, "Products are equals.");
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
        Assert.assertTrue(accessoriesPage.isPageOpened(5), "Adidas home page isn't opened.");

        Assert.assertTrue(accessoriesPage.isFooterContainerPresent(), "Footer container is missing.");
        accessoriesPage.scrollDownPage();

        firstUnSortProduct = accessoriesPage.getProductPricesAsNumbers().get(0);
        secondUnSortProduct = accessoriesPage.getProductPricesAsNumbers().get(2);
        thirdUnSortProduct = accessoriesPage.getProductPricesAsNumbers().get(3);
        fourthUnSortProduct = accessoriesPage.getProductPricesAsNumbers().get(5);

        Assert.assertTrue(accessoriesPage.isFilterButtonPresent(), "Filter button isn't visible.");
//        FilterBlockPageBase filterBlockPage = accessoriesPage.clickFilterButton();
        accessoriesPage.clickFilterButton();

        Assert.assertTrue(accessoriesPage.isSortByButtonPresent(), "Sort by button isn't present.");
        FilterBlockPageBase filterBlockPage = accessoriesPage.clickOnSortByButton();

        Assert.assertTrue(filterBlockPage.isHighPriceToLowPriceButtonPresent(),
                "HighPrice to LowPrice filter button isn't visible.");
        ProductListResultPageBase highPriceToLowPricePage = filterBlockPage.clickOnHighPriceToLowButton();

//        Assert.assertTrue(filterBlockPage.isApplyButtonPresent(), "Apply button is not present.");
//        ProductListResultPageBase lowPriceToHighPricePage = filterBlockPage.clickOnApplyButton();
//
//        Assert.assertTrue(lowPriceToHighPricePage.isPopupVisible(), "Popup button isn't visible.");
//        lowPriceToHighPricePage.clickOnClosePopUp();
//        Assert.assertFalse(lowPriceToHighPricePage.isPopupVisible(), "Popup button is visible.");
//
        highPriceToLowPricePage.scrollDownPage();

        firstSortProduct = highPriceToLowPricePage.getResultPricesAsNumbers().get(1);
        Assert.assertNotEquals(firstUnSortProduct, firstSortProduct, "Products are equals.");

        secondSortProduct = highPriceToLowPricePage.getResultPricesAsNumbers().get(2);
        Assert.assertNotEquals(secondUnSortProduct, secondSortProduct, "Products are equals.");

        thirdSortProduct = highPriceToLowPricePage.getResultPricesAsNumbers().get(3);
        Assert.assertNotEquals(thirdUnSortProduct, thirdSortProduct, "Products are equals.");

        fourthSortProduct = highPriceToLowPricePage.getResultPricesAsNumbers().get(5);
        Assert.assertNotEquals(fourthUnSortProduct, fourthSortProduct, "Products are equals.");
    }

    @TestRailCases(testCasesId = "9")
    @Test(description = "Adding product to wishlist from Accessories page.")
    @MethodOwner(owner = "Saeid Vahidnia", platform = "web")
    public void checkAddProductToWishlist() {
        AccessoriesPageBase accessoriesPage = initPage(getDriver(), AccessoriesPageBase.class);
        accessoriesPage.openURL(ACCESSORIES_LINK);
        Assert.assertTrue(accessoriesPage.isPageOpened(5), "Adidas home page is not opened.");

        // add first and second product to wishlist
        accessoriesPage.addProductToWishList(1);
        accessoriesPage.addProductToWishList(2);

//        List<Integer> indexOfProducts =
//                Arrays.asList(1, 2);
//        for(int indexOfProduct :  indexOfProducts){
//            accessoriesPage.addProductToWishList(indexOfProduct);
//        }


//        Assert.assertTrue(accessoriesPage.isPopupVisible(), "Popup button is not visible.");
        accessoriesPage.clickOnClosePopUp();
//        Assert.assertFalse(accessoriesPage.isPopupVisible(), "Popup button is visible.");

        accessoriesPage.addProductToWishList(3);

//        ProductListResultPageBase wishlistResult = accessoriesPage.clickOnWishListButton();
//        Assert.assertFalse(accessoriesPage.isWishlistListEmpty(), "Wishlist page is empty.");
    }

}