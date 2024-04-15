import org.example.pages.LoginPage;
import org.example.pages.FavoritePage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FavoriteTest extends BaseTest {

    private FavoritePage favoritePage;

    @BeforeClass
    public void setUpBeforeTest() {
        favoritePage = new FavoritePage(webDriver);
        webDriver.get("https://prom.ua/p1989029978-igrovij-noutbuk-lenovo.html");
        new LoginPage(webDriver).login("brehernasti@gmail.com", "Mar19742005.");
    }

    @Test(priority = 1)
    public void addToFavoriteTest() {
        webDriver.navigate().refresh();
        Assert.assertTrue(favoritePage.isUserLoggedIn());
        favoritePage.addToFavorite();
        Assert.assertTrue(favoritePage.isProductInFavorites());
    }

    @Test(priority = 2)
    public void removeFromFavoriteTest() {
        favoritePage.removeFromFavorite();
        Assert.assertFalse(favoritePage.isProductInFavorites());
    }
}
