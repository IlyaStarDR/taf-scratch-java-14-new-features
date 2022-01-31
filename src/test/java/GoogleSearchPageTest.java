import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class GoogleSearchPageTest {
    private WebDriver driver;
    private GoogleSearchPage googleSearchPage;

    @Test
    public void checkFirstFoundLinkIsWikipedia() {
        googleSearchPage
                .open()
                .fillSearchInputWithNumber(2)
                .clickSearchButton();
        Assert.assertEquals(googleSearchPage.getFirstFoundLinkText(), "1st century - Wikipedia", "First found link doesn't match");
    }

    @Test
    public void checkFirstFoundLinkIsWikipediaWithNullInstance() {
        googleSearchPage
                .getNullInstance()
                .open()
                .fillSearchInputWithNumber(2)
                .clickSearchButton();
        Assert.assertEquals(googleSearchPage.getFirstFoundLinkText(), "1st century - Wikipedia", "First found link doesn't match");
    }

    @BeforeSuite
    public void setUp() {
        driver = new ChromeDriver();
        googleSearchPage = PageFactory.initElements(driver, GoogleSearchPage.class);
    }

    @AfterSuite
    public void tearDown() {
        if (driver!= null) {
            driver.close();
        }
    }
}