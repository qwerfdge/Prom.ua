import org.example.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    private LoginPage loginPage;

    @BeforeClass
    public void setUpBeforeTest() {
        loginPage = new LoginPage(webDriver);
    }

    @Test
    public void loginWithInvalidCredentials() {
        loginPage.login("brehernasti@gmail.com", "Invalid_password");
        Assert.assertTrue(loginPage.isErrorDisplayed());
    }

    @Test
    public void loginWithValidCredentials() {
        webDriver.navigate().refresh();
        loginPage.login("brehernasti@gmail.com", "Mar19742005.");
        Assert.assertTrue(loginPage.isUserLoggedIn());
    }
}
