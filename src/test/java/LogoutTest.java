import org.example.pages.LoginPage;
import org.example.pages.LogoutPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    private LogoutPage logoutPage;

    @BeforeClass
    public void setUpBeforeTest() {
        new LoginPage(webDriver).login("brehernasti@gmail.com", "Mar19742005.");
        logoutPage = new LogoutPage(webDriver);
        logoutPage.clickAcceptButton();
    }

    @Test
    public void logoutTest() {
        logoutPage.logout();
        Assert.assertFalse(logoutPage.isUserLoggedIn());
    }
}
