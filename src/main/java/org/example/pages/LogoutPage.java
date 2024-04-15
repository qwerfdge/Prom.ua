package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LogoutPage extends BasePage {

    @FindBy(xpath = "//button[@data-qaid='accept_btn']")
    private WebElement acceptButton;

    @FindBy(xpath = "//span[@class='_3Trjq gwkkx' and text()='Вийти']")
    private WebElement logoutButton;

    public LogoutPage(WebDriver driver) {
        super(driver);
    }

    public void clickAcceptButton() {
        wait.until(ExpectedConditions.visibilityOf(acceptButton)).click();
    }

    public void logout() {
        wait.until(ExpectedConditions.visibilityOf(accountButton)).click();
        wait.until(ExpectedConditions.visibilityOf(logoutButton)).click();
    }
}
