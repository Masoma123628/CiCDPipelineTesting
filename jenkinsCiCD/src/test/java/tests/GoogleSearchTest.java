package tests;
import com.microsoft.playwright.*;
import org.testng.annotations.*;

public class GoogleSearchTest {
    private static Playwright playwright;
    private static Browser browser;
    private Page page;

    @BeforeClass
    public void setupClass() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
    }

    @BeforeMethod
    public void setup() {
        page = browser.newPage();
    }

    @Test
    public void testGoogleSearch() {
        page.navigate("https://www.google.com");
        page.locator("textarea[name='q']").fill("Playwright Java");
        page.keyboard().press("Enter");
        page.waitForTimeout(3000);  // wait for results
        assert page.title().toLowerCase().contains("playwright java");
    }

    @AfterMethod
    public void teardown() {
        page.close();
    }

    @AfterClass
    public void teardownClass() {
        browser.close();
        playwright.close();
    }
}
