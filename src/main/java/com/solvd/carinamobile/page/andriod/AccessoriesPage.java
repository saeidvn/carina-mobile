package com.solvd.carinamobile.page.andriod;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.solvd.carinamobile.page.common.AccessoriesPageBase;
import com.solvd.carinamobile.page.common.FilterBlockPageBase;
import com.solvd.carinamobile.page.common.ProductListResultPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AccessoriesPageBase.class)
public class AccessoriesPage extends AccessoriesPageBase implements IMobileUtils {

    @ExtendedFindBy(androidUIAutomator = "name = \"URL\"")
    private ExtendedWebElement urlField;

    @FindBy(xpath = "//div[@class='footer-bottom___1H5NH']")
    private ExtendedWebElement footerContainer;

    @FindBy(xpath = "//div[@class = 'badge-container___DVUWN']/div/div")
    private List<ExtendedWebElement> productPrices;

    @FindBy(xpath = "//div[@class='filters-icon-float___3d8_p']")
    private ExtendedWebElement filterButton;

    @FindBy(xpath = "//div[@class='gl-wishlist-icon wishlist_button___3ppwb outlined-icon-color___2xwB3']")
    private ExtendedWebElement wishListButton;

    @FindBy(xpath = "(//div[@class='plp-product-card__wishlist-button___qAqKB toggle_wishlist_button___my-ER  '])[%s]")
    private ExtendedWebElement addToWishlistButton;

    @FindBy(xpath = "//div[@class='sidebar_filter___1frgs'][1]")
    private ExtendedWebElement sortByButton;

    @FindBy(xpath = "//button[@class='gl-modal__close']")
//    @FindBy(xpath = "//button[@aria-label='Close']")
    private ExtendedWebElement popupButton;

    public AccessoriesPage(WebDriver driver) {
        super(driver);
    }

//    public void openLink(String link) {
//        urlField.click(5);
////        urlField.type(link + Keys.ENTER);
//    }

    /**
     *
     * @return
     */

    @Override
    public void clickFilterButton() {
        filterButton.click(20);
    }

    @Override
    public FilterBlockPageBase clickOnSortByButton() {
        sortByButton.click(20);
        return initPage(getDriver(), FilterBlockPageBase.class);
    }

//    @Override
//    public FilterBlockPageBase clickFilterButton() {
//        filterButton.clickIfPresent();
//        return initPage(getDriver(), FilterBlockPageBase.class);
//    }

    @Override
    public boolean isFilterButtonPresent() {
        return filterButton.isPresent();
    }

    @Override
    public boolean isSortByButtonPresent() {
        return sortByButton.isPresent();
    }

    @Override
    public List<String> getProductPricesAsStrings() {
        return productPrices.stream()
                .map(ExtendedWebElement::getText)
                .collect(Collectors.toList());
    }

    @Override
    public List<Integer> getProductPricesAsNumbers() {
        return getProductPricesAsStrings().stream()
                .map(price -> price.replaceAll("[^0-9]", ""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    @Override
    public ProductListResultPageBase clickOnWishListButton() {
        wishListButton.clickIfPresent();
        return initPage(getDriver(), ProductListResultPageBase.class);
    }

    @Override
    public void addProductToWishList(int indexOfProduct) {
        addToWishlistButton.format(indexOfProduct).click(20);
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
    public boolean isFooterContainerPresent() {
        return footerContainer.isPresent();
    }

    public void clickOnClosePopUp() {
        popupButton.click(20);
    }

    @Override
    public boolean isPopupVisible() {
        return popupButton.isVisible(20);
    }

}
