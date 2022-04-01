package com.solvd.carinamobile.page.TrackgoApp;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carinamobile.page.common.GoodsPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = GoodsPageBase.class)
public class GoodsPage extends GoodsPageBase {

    @FindBy(xpath = "//android.view.View[@content-desc='Recommended Tab 2 of 2']")
    private ExtendedWebElement recommendedTab;

    @FindBy(xpath = "//android.view.View[@content-desc='Interesting Tab 1 of 2']")
    private ExtendedWebElement interestingTab;

    @FindBy(xpath = "//android.widget.ImageView")
    private List<ExtendedWebElement> goodsProducts;

    public GoodsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isRecommendedTabPresent() {
        return recommendedTab.isPresent();
    }

    @Override
    public void clickOnRecommendedTab() {
        recommendedTab.click();
    }

    @Override
    public boolean isInterestingTabPresent() {
        return interestingTab.isPresent();
    }

    @Override
    public void clickOnInterestingTab() {
        interestingTab.click();
    }

    @Override
    public List<String> getGoodsResultProducts() {
        return goodsProducts.stream()
                .map(ExtendedWebElement::getText)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isGoodsResultProductsEmpty() {
        return getGoodsResultProducts().isEmpty();
    }
}
