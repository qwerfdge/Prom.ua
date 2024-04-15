package org.example.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class MenuPage extends BasePage {

    @FindBy(xpath = "//a[@href='/ua/sc/military']")
    private WebElement military;

    @FindBy(xpath = "//a[@href='/ua/sc/supermarket-prom']")
    private WebElement supermarketProm;

    @FindBy(xpath = "//a[@href='/ua/Krasota-i-zdorove']")
    private WebElement beautyAndHealth;

    @FindBy(xpath = "//a[@href='/ua/Dom-i-sad']")
    private WebElement houseAndGarden;

    @FindBy(xpath = "//a[@href='/ua/Odezhda']")
    private WebElement clothing;

    @FindBy(xpath = "//a[@href='/ua/Tehnika-i-elektronika']")
    private WebElement techniqueAndElectronics;

    @FindBy(xpath = "//a[@href='/ua/Tovary-dlya-detej']")
    private WebElement productsForKids;

    @FindBy(xpath = "//a[@href='/ua/Avto-moto']")
    private WebElement autoMoto;

    @FindBy(xpath = "//a[@href='/ua/Podarki-i-suveniry']")
    private WebElement presentsAndSouvenirs;

    @FindBy(xpath = "//a[@href='/ua/Ukrasheniya-i-chasy']")
    private WebElement decorationsAndClock;

    @FindBy(xpath = "//a[@href='/ua/Materialy-dlya-remonta']")
    private WebElement materialsForRenovation;

    public MenuPage(WebDriver driver) {
        super(driver);
    }
}
