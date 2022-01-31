import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchPage extends PageFactory {

    private final WebDriver driver;

    @FindBy(css = "input[aria-label='Search']")
    private WebElement searchInput;

    @FindBy(css = "a h3")
    private WebElement firstFoundLink;

    private static final String SEARCH_BUTTON_SELECTOR = "input[type='submit']";
    private static final String SEARCH_PAGE_URL = "https://www.google.com/search";

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public GoogleSearchPage open() {
        driver.get(SEARCH_PAGE_URL);
        return this;
    }

    public GoogleSearchPage fillSearchInputWithNumber(int number) {
        String romanNumerals = "";
        switch (number) {
            case 1 -> {
                romanNumerals = "Ⅰ";
            }
            case 2 -> {
                romanNumerals = "ⅠⅠ";
            }
            case 3 -> {
                romanNumerals = "ⅠⅠⅠ";
            }
            case 4 -> {
                romanNumerals = "Ⅳ";
            }
        }
        searchInput.sendKeys("History of " + romanNumerals + " century");
        return this;
    }

    public void clickSearchButton() {
        WebDriverWait waiter = new WebDriverWait(driver, 10);
        WebElement searchButton = waiter.until(ExpectedConditions.elementToBeClickable(getSearchButton()));
        searchButton.click();
    }

    public String getFirstFoundLinkText() {
        return firstFoundLink.getText();
    }

    public GoogleSearchPage getNullInstance() {
        return null;
    }

    private By getSearchButton() {
        return By.cssSelector(SEARCH_BUTTON_SELECTOR);
    }
}
