package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//button[@data-qaid='show_sidebar']")
    private WebElement cabinetButton;

    @FindBy(xpath = "//button[@data-qaid='sign_in_mob_sidebar']")
    private WebElement signInMobSidebar;

    @FindBy(xpath = "//span[@data-qaid='error_field']")
    private WebElement errorField;

    @FindBy(xpath = "//div[@data-qaid='email_btn']")
    private WebElement emailButton;

    @FindBy(xpath = "//input[@id='email_field']")
    private WebElement emailField;

    @FindBy(xpath = "//button[@id='emailConfirmButton']")
    private WebElement emailConfirmButton;

    @FindBy(xpath = "//input[@id='enterPassword']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@id='enterPasswordConfirmButton']")
    private WebElement passwordConfirmButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isErrorDisplayed() {
        return errorField != null && errorField.getText().trim()
                .equals("Перевірте правильність введеного пароля".trim());
    }

    public void login(String email, String password) {
        cabinetButton.click();
        signInMobSidebar.click();

        wait.until(ExpectedConditions.visibilityOf(emailButton));
        emailButton.click();

        emailField.sendKeys(email);
        emailConfirmButton.click();

        passwordField.sendKeys(password);
        passwordConfirmButton.click();
    }
}
