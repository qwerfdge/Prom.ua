import org.example.pages.MenuPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MenuTest extends BaseTest {

    private MenuPage menuPage;

    @BeforeClass
    public void setUpBeforeTest() {
        menuPage = new MenuPage(webDriver);
    }

    @Test
    public void testOtherElementColorChange() {
        WebElement[] elements = {
                menuPage.getMilitary(),
                menuPage.getSupermarketProm(),
                menuPage.getBeautyAndHealth(),
                menuPage.getHouseAndGarden(),
                menuPage.getClothing(),
                menuPage.getTechniqueAndElectronics(),
                menuPage.getProductsForKids(),
                menuPage.getAutoMoto(),
                menuPage.getPresentsAndSouvenirs(),
                menuPage.getDecorationsAndClock(),
                menuPage.getMaterialsForRenovation()
        };
        for (WebElement menu : elements) {
            new Actions(webDriver).moveToElement(menu).perform();
            String actualColor = menu.getCssValue("color");
            String expectedColor = "rgba(255, 255, 255, 1)";
            Assert.assertEquals(actualColor, expectedColor, "Color is not expected");
        }
    }
}
