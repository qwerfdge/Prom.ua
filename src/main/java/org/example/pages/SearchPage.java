package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchInput;

    @FindBy(xpath = "//button[@data-qaid='search_btn']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@data-qaid='product_block']")
    private List<WebElement> searchResults;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void doSearch(String searchQuery) {
        searchInput.sendKeys(searchQuery);
        searchButton.click();
    }

    public boolean areSearchResultsDisplayed() {
        return !searchResults.isEmpty() && searchResults.get(0).isDisplayed();
    }

    public boolean areSearchResultsMatchingQuery(String searchQuery) {
        int counter = 0;
        for (WebElement result : searchResults) {
            if (result.getText().contains(searchQuery)) {
                counter++;
            }
        }
        return counter > 0;
    }
}
