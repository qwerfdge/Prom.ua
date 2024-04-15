import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    protected WebDriver webDriver;

    @BeforeClass
    @Deprecated
    public void setUp() {
        this.webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get("https://prom.ua/");
    }

    @AfterClass
    public void tearDown() {
        this.webDriver.quit();
    }
}
