package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FavoritePage extends BasePage {

    @FindBy(xpath = "//span[@data-qaid='add_favorite']")
    private WebElement addToFavoriteButton;

    @FindBy(xpath = "//span[@data-qaid='counter']")
    private WebElement counter;

    public FavoritePage(WebDriver driver) {
        super(driver);
    }

    public void addToFavorite() {
        addToFavoriteButton.click();
        wait.until(ExpectedConditions.visibilityOf(counter));
    }

    public boolean isProductInFavorites() {
        String clicked = addToFavoriteButton.getAttribute("data-tg-clicked");
        return clicked.contains("label/label\":\"on");
    }

    public void removeFromFavorite() {
        addToFavoriteButton.click();
        wait.until(ExpectedConditions.invisibilityOf(counter));
    }
}
