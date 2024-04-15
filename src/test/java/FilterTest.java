import org.example.pages.FilterPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FilterTest extends BaseTest {

    private FilterPage filterPage;

    @BeforeClass
    public void setUpBeforeTest() {
        filterPage = new FilterPage(webDriver);
        webDriver.get("https://prom.ua/ua/Tehnika-i-elektronika");
    }

    @Test
    public void filterByCategoryTest() {
        filterPage.getComputerSoftware().click();
        Assert.assertEquals(webDriver.getCurrentUrl(),
                "https://prom.ua/ua/Kompyuternaya-tehnika-i-programmnoe-obespechenie");
        webDriver.navigate().back();

        filterPage.getAppliances().click();
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://prom.ua/ua/Bytovaya-tehnika");
        webDriver.navigate().back();

        filterPage.getPhonesAndAccessories().click();
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://prom.ua/ua/Telefony");
        webDriver.navigate().back();

        filterPage.getAudioEquipment().click();
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://prom.ua/ua/Audio-i-aksessuary");
        webDriver.navigate().back();

        filterPage.getVideoEquipment().click();
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://prom.ua/ua/Audio-video-foto-tehnika");
        webDriver.navigate().back();

        filterPage.getCarElectronics().click();
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://prom.ua/ua/Avtomobilnaya-elektronika");
        webDriver.navigate().back();

        filterPage.getCameraAndAccessories().click();
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://prom.ua/ua/Foto-videokamery-i-aksessuary");
        webDriver.navigate().back();
    }

    @Test
    public void filterByPriceTest() {
        filterPage.getMinPriceField().sendKeys("1000");
        filterPage.getMaxPriceField().sendKeys("10000");
        filterPage.getAcceptButton().click();
        Assert.assertTrue(filterPage.isFilteredByPrice(1000.0, 10000.0));
    }
}
