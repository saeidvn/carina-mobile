package com.solvd.carinamobile.page.andriod;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carinamobile.page.common.ProductListResultPageBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductListResultPageBase.class)
public class ProductListResultPage extends ProductListResultPageBase {

    @FindBy(xpath = "//div[@class = 'badge-container___DVUWN']/div/div")
    private List<ExtendedWebElement> productPrices;

    public ProductListResultPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getResultPricesAsStrings() {
        return productPrices.stream()
                .map(ExtendedWebElement::getText)
                .collect(Collectors.toList());
    }

    public List<Integer> getResultPricesAsNumbers() {
        return getResultPricesAsStrings().stream()
                .map(price -> price.replaceAll("[^0-9]", ""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isProductListEmpty() {
        return productPrices.isEmpty();
    }

    /**
     *              IMPORTANT
     * Here we need to use 'swipe' method for scroll down!!!!!!!
     */
    @Override
    public void scrollDownPage() throws InterruptedException {
        int from = 0;
        int to = 500;

        for (int i = 0; i <= 5; i++) {

            ((JavascriptExecutor) getDriver()).executeScript("scroll(" + from + "," + to + ")");
            Thread.sleep(1000);
            from = from + 500;
            to = to + 500;
        }
    }

}
