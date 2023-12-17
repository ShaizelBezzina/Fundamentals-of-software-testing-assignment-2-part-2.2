package Amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonPart2 {
    private WebDriver driver;


    public AmazonPart2() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\bezzi\\OneDrive\\Desktop\\Software testing ass 2\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/?ref_=icp_country_from_de");
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void performLogin() {
        // Signing in
        WebElement signingIn = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        signingIn.click();

        // Explicit wait for email input field
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement enteringEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_email")));

        // Entering email
        enteringEmail.sendKeys("bezzinashaizel03@gmail.com");

        // Clicking on continue
        WebElement clickingOnContinue = driver.findElement(By.id("continue"));
        clickingOnContinue.click();

        // Explicit wait for password input field
        WebElement enteringPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));

        // Entering password
        enteringPassword.sendKeys("bezzina2003");

        // Clicking on Sign in
        WebElement clickingOnSignIn = driver.findElement(By.id("signInSubmit"));
        clickingOnSignIn.click();
    }

    public void searchForProduct(String term) {
        // Explicit wait for search bar
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement searchingForProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));

        // Searching for a product in the search bar
        searchingForProduct.sendKeys(term);

        // Clicking search
        WebElement clickingSearch = driver.findElement(By.id("nav-search-submit-button"));
        clickingSearch.click();

        // Explicit wait for the first product in the search results
        WebElement clickingOnFirstProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".s-title-instructions-style")));

        // Clicking on the first product in the search results
        clickingOnFirstProduct.click();
    }

    public void clickOnFirstProduct() {
        // You can add additional steps for interacting with the product page here
    }

    public void teardown() {
        driver.quit();
    }
}
