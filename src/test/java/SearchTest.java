import org.example.pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @DataProvider(name = "searchQuery")
    public Object[][] searchQuery() {
        return new Object[][] {
                {"Ноутбук"},
                {"Кросівки"},
                {"Блендер"}
        };
    }

    @Test(dataProvider = "searchQuery")
    public void searchTest(String searchQuery) {
        SearchPage searchPage = new SearchPage(webDriver);
        searchPage.doSearch(searchQuery);
        Assert.assertTrue(searchPage.areSearchResultsDisplayed(), "Search results are not displayed");
        Assert.assertTrue(searchPage.areSearchResultsMatchingQuery(searchQuery),
                "Not all search results match the query: " + searchQuery);
        webDriver.get("https://prom.ua/");
    }
}
