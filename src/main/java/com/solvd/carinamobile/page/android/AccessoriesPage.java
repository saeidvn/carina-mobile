package com.solvd.carinamobile.page.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carinamobile.page.common.AccessoriesPageBase;
import com.solvd.carinamobile.page.common.FilterBlockPageBase;
import com.solvd.carinamobile.page.common.ProductListResultPageBase;
import com.solvd.carinamobile.page.common.WishlistPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AccessoriesPageBase.class)
public class AccessoriesPage extends AccessoriesPageBase implements IMobileUtils {

    @FindBy(xpath = "//div[@class='footer-bottom___1H5NH']")
    private ExtendedWebElement footerContainer;

    @FindBy(xpath = "//div[@class = 'badge-container___DVUWN']/div/div")
    private List<ExtendedWebElement> productPrices;

    @FindBy(xpath = "//div[@class='filters-icon-float___3d8_p']")
    private ExtendedWebElement filterButton;

    @FindBy(xpath = "//a[@data-auto-id='cart-wishlist-icon-header']")
    private ExtendedWebElement wishListButton;

    @FindBy(xpath = "(//div[@class='plp-product-card__wishlist-button___qAqKB toggle_wishlist_button___my-ER  '])[%s]")
    private ExtendedWebElement addToWishlistButton;

    @FindBy(xpath = "//div[@class='sidebar_filter___1frgs'][1]")
    private ExtendedWebElement sortByButton;

    @FindBy(xpath = "//button[@class='gl-modal__close']")
    private ExtendedWebElement popupButton;

    public AccessoriesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickFilterButton() {
        filterButton.click();
    }

    @Override
    public FilterBlockPageBase clickOnSortByButton() {
        sortByButton.click();
        return initPage(getDriver(), FilterBlockPageBase.class);
    }

    @Override
    public boolean isFilterButtonVisible() {
        return filterButton.isVisible();
    }

    @Override
    public boolean isSortByButtonVisible() {
        return sortByButton.isVisible();
    }

    @Override
    public WishlistPageBase clickOnWishlistButton() {
        wishListButton.click();
        return initPage(getDriver(), WishlistPageBase.class);
    }

    @Override
    public List<Integer> getResultPricesAsNumbers() {
        List<Integer> productPrice = new ArrayList<>();
        productPrices.stream()
                .map(extendedWebElement -> extendedWebElement.getText()
                        .replaceAll("[^0-9]", ""))
                .map(Integer::parseInt)
                .forEach(productPrice::add);
        return productPrice;
    }

    @Override
    public ProductListResultPageBase clickOnWishListButton() {
        wishListButton.click();
        return initPage(getDriver(), ProductListResultPageBase.class);
    }

    @Override
    public void addProductToWishList(int indexOfProduct) {
        addToWishlistButton.format(indexOfProduct).click();
    }

    @Override
    public boolean isWishlistListEmpty() {
        return productPrices.isEmpty();
    }

    @Override
    public void scrollDownPage() {
        swipe(footerContainer);
    }

    @Override
    public boolean isFooterContainerVisible() {
        return footerContainer.isVisible();
    }

    @Override
    public void clickOnClosePopUp() {
        popupButton.click();
    }

    @Override
    public boolean isPopupVisible() {
        return popupButton.isVisible();
    }

}
