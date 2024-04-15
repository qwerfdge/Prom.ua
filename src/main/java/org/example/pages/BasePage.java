package org.example.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    @FindBy(xpath = "//div[@data-qaid='avatar']")
    protected WebElement accountButton;

    protected WebDriver webDriver;

    protected WebDriverWait wait;

    public BasePage(WebDriver webDriver){
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        PageFactory.initElements(webDriver,this);
    }

    public boolean isUserLoggedIn() {
        try {
            return accountButton.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
