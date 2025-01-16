package testPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import pages.*;
import utils.AddressDataHelper;
import utils.Helper;
import utils.JsonDataReader;

import java.io.FileInputStream;
import java.util.Properties;

// Base Classes
class BaseTest {
    protected WebDriver driver;

    protected Properties config;
    // Page Objects
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected VideoGamesPage videoGamesPage;
    protected FilterPage filterPage;
    protected CartPage cartPage;
    protected CheckOutPage checkOutPage;
    protected AddressModalPage addressModalPage;
    protected AddressDataHelper addressData;


    @BeforeClass
    public void setUp() throws Exception {
        this.config = new Properties();
        FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
        this.config.load(fis);
        String browser = this.config.getProperty("browser");

        if ("chrome".equalsIgnoreCase(browser)) {
            this.driver = new ChromeDriver();
        } else if ("firefox".equalsIgnoreCase(browser)) {
            this.driver = new FirefoxDriver();
        } else if ("edge".equalsIgnoreCase(browser)) {
            this.driver = new EdgeDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }


        this.driver.manage().window().maximize();
        this.driver.get(this.config.getProperty("url"));

        // Initialize Page Objects
        this.loginPage = new LoginPage(this.driver);
        this.homePage = new HomePage(this.driver);
        this.videoGamesPage = new VideoGamesPage(this.driver);
        this.filterPage = new FilterPage(this.driver);
        this.cartPage = new CartPage(this.driver);
        this.addressModalPage = new AddressModalPage(this.driver);
        this.checkOutPage = new CheckOutPage(this.driver);
        this.addressData = new AddressDataHelper();
        addressData = JsonDataReader.getAddressData("src/main/resources/addressData.json");

    }
    @AfterMethod
    public void takeSSonFailure(ITestResult result) {
        if (result.getStatus() == 2) {
            System.out.println("Failed !! ");
            System.out.println("Taking ScreenShot .... ");
            Helper.caputreScreenshot(this.driver, result.getName());
        }

        }
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }}
}