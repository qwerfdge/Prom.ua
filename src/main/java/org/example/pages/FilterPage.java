package org.example.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class FilterPage extends BasePage {

    @FindBy(xpath = "//a[@href='/ua/Kompyuternaya-tehnika-i-programmnoe-obespechenie']")
    private WebElement computerSoftware;

    @FindBy(xpath = "//a[@href='/ua/Bytovaya-tehnika']")
    private WebElement appliances;

    @FindBy(xpath = "//a[@href='/ua/Telefony']")
    private WebElement phonesAndAccessories;

    @FindBy(xpath = "//a[@href='/ua/Audio-i-aksessuary']")
    private WebElement audioEquipment;

    @FindBy(xpath = "//a[@href='/ua/Audio-video-foto-tehnika']")
    private WebElement videoEquipment;

    @FindBy(xpath = "//a[@href='/ua/Avtomobilnaya-elektronika']")
    private WebElement carElectronics;

    @FindBy(xpath = "//a[@href='/ua/Foto-videokamery-i-aksessuary']")
    private WebElement cameraAndAccessories;

    @FindBy(xpath = "(//input[@data-testid='input_field_textbox'])[1]")
    private WebElement minPriceField;

    @FindBy(xpath = "(//input[@data-testid='input_field_textbox'])[2]")
    private WebElement maxPriceField;

    @FindBy(xpath = "//button[@data-qaid='accept_price']")
    private WebElement acceptButton;

    @FindBy(xpath = "//div[@data-qaid='product_price']")
    private List<WebElement> filterResults;

    public FilterPage(WebDriver driver) {
        super(driver);
    }

    public boolean isFilteredByPrice(Double minPrice, Double maxPrice) {
        for (WebElement element : filterResults) {
            String priceStr = element.getAttribute("data-qaprice");

            if (priceStr != null && !priceStr.isEmpty()) {
                try {
                    double price = Double.parseDouble(priceStr);
                    if (price < minPrice || price > maxPrice) {
                        return false;
                    }
                } catch (NumberFormatException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return true;
    }
}
