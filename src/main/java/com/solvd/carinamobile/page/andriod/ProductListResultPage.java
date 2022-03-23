package com.solvd.carinamobile.page.andriod;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carinamobile.page.common.ProductListResultPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

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

    @FindBy(xpath = "//div[@class='apb-browse-slot-margin']")
    private ExtendedWebElement healthAndHouseholdResult;

    public ProductListResultPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public List<String> getResultPricesAsStrings() {
        return productPrices.stream()
                .map(ExtendedWebElement::getText)
                .collect(Collectors.toList());
    }

    @Override
    public List<Integer> getResultPricesAsNumbers() {
        return getResultPricesAsStrings().stream()
                .map(price -> price.replaceAll("[^0-9]", ""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isProductListNotEmpty() {
        return productPrices.isEmpty();
    }

    @Override
    public boolean isPopupVisible() {
        return popupButton.isVisible(10);
    }

    @Override
    public void clickOnClosePopUp() {
        popupButton.click(10);
    }

    @Override
    public void scrollDownPage() {
        swipe(footerContainer);
    }

    @Override
    public boolean isAmazonResultVisible() {
        return amazonSearchResult.isVisible(10);
    }

    @Override
    public boolean isBooksResultVisible() {
        return booksResult.isVisible();
    }

    @Override
    public boolean isHealthAndHouseholdResultVisible() {
        return healthAndHouseholdResult.isVisible();
    }

}
