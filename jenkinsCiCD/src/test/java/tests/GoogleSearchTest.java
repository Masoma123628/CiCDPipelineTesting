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
    public void check(){
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));  // setHeadless(false) to see the browser
            BrowserContext context = browser.newContext();

            Page page = context.newPage(); //Page provides methods to interact with a single tab in a browser

            page.navigate("https://www.saucedemo.com/");

            // Fill in the username field
            page.locator("#user-name").fill("standard_user");  // Replace "user_name" with the correct selector

            // Fill in the password field
            page.locator("#password").fill("secret_sauce");
            page.waitForTimeout(3000);
            // Click the login button
            page.locator("#login-button").click();
            page.waitForTimeout(5000);
            browser.close();
        }
    }
    
    @Test
    public void testGoogleSearch() {
        page.navigate("https://www.google.com");
        page.locator("textarea[name='q']").fill("Playwright Java");
        page.keyboard().press("Enter");
        page.waitForTimeout(3000);  // wait for results
        assert page.title().toLowerCase().contains("playwright java");
    }

    @Test
    public void testLoginSauceDemo() {
        // Navigate to Sauce Demo login page
        page.navigate("https://www.saucedemo.com/v1/");
        
        // Fill in login credentials
        page.locator("input#user-name").fill("standard_user");
        page.locator("input#password").fill("secret_sauce");
        
        // Click the login button
        page.locator("input[type='submit']").click();
        
        // Wait for the login to process
        page.waitForSelector(".inventory_list"); // Wait for the inventory page to load
        
        // Assert that the user has successfully logged in by verifying a visible element on the dashboard
        assert page.locator(".inventory_list").isVisible();
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
