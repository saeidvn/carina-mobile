package com.solvd.carinamobile.page.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carinamobile.page.common.ProductListResultPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductListResultPageBase.class)
public class ProductListResultPage extends ProductListResultPageBase implements IMobileUtils {

    @FindBy(xpath = "//div[@class = 'badge-container___DVUWN']/div/div")
    private List<ExtendedWebElement> productPrices;

    @FindBy(xpath = "//div[@class='footer-bottom___1H5NH']")
    private ExtendedWebElement footerContainer;

    @FindBy(xpath = "//button[@class='gl-modal__close']")
    private ExtendedWebElement popupButton;

    @FindBy(xpath = "//span[@class='a-size-base a-color-base s-medium-weight-text a-text-normal']")
    private ExtendedWebElement amazonSearchResult;

    @FindBy(xpath = "//div[@class='a-section']")
    private ExtendedWebElement booksResult;

    @FindBy(xpath = "//h1[text()='Health, Household and Baby Care']")
    private ExtendedWebElement healthAndHouseholdText;

    @FindBy(xpath = "//h1[text()=' Help']")
    private ExtendedWebElement helpText;

    @FindBy(xpath = "//span[@id='s-all-filters']")
    private ExtendedWebElement filterButton;

    @FindBy(xpath = "//div[@class='a-section']/span[text()='Movies']")
    private ExtendedWebElement movieButton;

    @FindBy(xpath = "//a[@class='a-link-normal sf-top-nav-btn aok-float-right']/span[text()='Close']")
    private ExtendedWebElement closeFilterButton;

    @FindBy(xpath = "//div[@class='a-section a-spacing-none s-title-instructions-style']")
    private List<ExtendedWebElement> listOfMovies;

    @FindBy(xpath = "//h4[text()='My Wishlist']")
    private ExtendedWebElement myWishlistText;

    public ProductListResultPage(WebDriver driver) {
        super(driver);
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
    public boolean isProductListNotEmpty() {
        return productPrices.isEmpty();
    }

    @Override
    public boolean isPopupVisible() {
        return popupButton.isVisible();
    }

    @Override
    public void clickOnClosePopUp() {
        popupButton.click();
    }

    @Override
    public void scrollDownPage() {
        swipe(footerContainer);
    }

    @Override
    public boolean isAmazonResultVisible() {
        return amazonSearchResult.isVisible();
    }

    @Override
    public boolean isFilterButtonVisible() {
        return filterButton.isVisible();
    }

    @Override
    public void clickOnFilterButton() {
        filterButton.click();
    }

    @Override
    public boolean isBooksResultVisible() {
        return booksResult.isVisible();
    }

    @Override
    public String getHealthAndHouseholdResultText() {
        return healthAndHouseholdText.getText();
    }

    @Override
    public String getHelpText() {
        return helpText.getText();
    }

    @Override
    public boolean isMovieButtonVisible() {
        return movieButton.isVisible();
    }

    @Override
    public void clickOnMovieButton() {
        movieButton.click();
    }

    @Override
    public boolean isCloseFilterButtonVisible() {
        return closeFilterButton.isVisible();
    }

    @Override
    public void clickOnCloseFilterButton() {
        closeFilterButton.click();
    }

    @Override
    public List<String> getResultMoviesAsStrings() {
        return listOfMovies.stream()
                .map(ExtendedWebElement::getText)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isMoviesResultEmpty() {
        return listOfMovies.isEmpty();
    }

    @Override
    public String getWishlistText() {
        return myWishlistText.getText();
    }

}
