package com.solvd.carinamobile.page.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class AdidasHomePageBase extends AbstractPage {

    public AdidasHomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract HelpPageBase clickOnHelpButton();

    public abstract void clickOnProfileButton();

    public abstract void typeEmail(String email);

    public abstract void clickOnContinueButton();

    public abstract void typePassword(String password);

    public abstract void clickOnLoginButton();

    public abstract MyAccountPageBase clickOnVisitYourAccountButton();

    public abstract boolean isSearchButtonVisible();

    public abstract void clickOnSearchButton();

    public abstract SearchBlockPageBase typeSpecialCharacter(String specialCharacter);

    public abstract SearchBlockPageBase searchProduct(String productName);

    public abstract boolean isProfileButtonPresent();

    public abstract boolean isVisitYourAccountPresent();

    public abstract boolean isEmailFieldPresent();

    public abstract boolean isContinueButtonVisible();

    public abstract boolean isPasswordFieldPresent();

    public abstract boolean isLoginButtonVisible();

    public abstract boolean isSearchFieldPresent();

    public abstract boolean isPopularProductPresent();

    public abstract WishlistPageBase clickOnWishListButton();

    public abstract void clickOnFirstPopularProduct();

    public abstract void scrollDownPage();

    public abstract void addProductToWishList (int indexOfProduct);

}