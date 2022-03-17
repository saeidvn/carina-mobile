package com.solvd.carinamobile.page.andriod.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carinamobile.page.common.components.FilterBlockBase;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class FilterBlock extends FilterBlockBase {

    @FindBy(xpath = "//li[contains(@class,'sorting_option___3bTnn') and text()='Price (low - high)']")
    private ExtendedWebElement lowPriceToHighPriceBtn;

    @FindBy(xpath = "//li[contains(@class,'sorting_option___3bTnn') and text()='Price (high - low)']")
    private ExtendedWebElement highPriceToLowPriceBtn;

    @FindBy(xpath = "//li[contains(@class,'sorting_option___3bTnn') and text()='Top Sellers']")
    private ExtendedWebElement topSellersBtn;

    @FindBy(xpath = "//button[@class='gl-cta gl-cta--primary gl-cta--full-width']")
    private ExtendedWebElement applyBtn;

    public FilterBlock(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public void clickOnLowPriceToHighBtn() {
        lowPriceToHighPriceBtn.clickIfPresent();
    }

    @Override
    public void clickOnHighPriceToLowBtn() {
        highPriceToLowPriceBtn.clickIfPresent();
    }

    @Override
    public void clickOnTopSellersBtn() {
        topSellersBtn.clickIfPresent();
    }

    @Override
    public boolean isLowPriceToHighPriceBtnPresent() {
        return lowPriceToHighPriceBtn.isPresent();
    }

    @Override
    public boolean isHighPriceToLowPriceBtnPresent() {
        return highPriceToLowPriceBtn.isPresent();
    }

    @Override
    public boolean isTopSellersBtnPresent() {
        return topSellersBtn.isPresent();
    }

    @Override
    public boolean isApplyBtnPresent() {
        return applyBtn.isPresent();
    }

//    public ProductListResultPage clickOnApplyBtn() {
//        applyButton.clickIfPresent();
//        return new ProductListResultPage(driver);
//    }

}