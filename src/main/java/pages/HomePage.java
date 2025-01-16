package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    @FindBy(id = "nav-hamburger-menu")
    WebElement menuBtn;
    @FindBy(xpath = "//a[@id='nav-logo-sprites']")
    WebElement amazonLogo;
    @FindBy(xpath = "//a[div[text()='Video Games']]")
    WebElement videoGamesLink;
    @FindBy(xpath = "//*[@id=\"hmenu-content\"]/ul[32]/li[3]/a")
    WebElement allVideoGamesLink;
    @FindBy(xpath = "//div[@id='hmenu-content']")
    WebElement categoriesList;
    @FindBy(xpath = "(//*[@id=\"hmenu-content\"]/ul[1]/li[14]/a[1])[1]")
    WebElement seeAllBtn;
    @FindBy(xpath = "//div[@role='heading'][normalize-space()='Video Games']")
    WebElement videoGamesTitleInList;


    public HomePage(WebDriver driver) {
        super(driver);

    }

    public void navigateToVideoGamesList() {

        wait.until(ExpectedConditions.visibilityOf(menuBtn)).click();
    }

    public void clickOnSeeAllBtn() {
        wait.until(ExpectedConditions.visibilityOf(seeAllBtn)).click();
    }

    ;

    public void clickOnVideoGamesBtn() {
        wait.until(ExpectedConditions.visibilityOf(videoGamesLink)).click();

    }

    public void navigateToVideoGamesScreen() {

        wait.until(ExpectedConditions.visibilityOf(allVideoGamesLink));
        wait.until(ExpectedConditions.elementToBeClickable(allVideoGamesLink)).click();
    }

    public boolean isAmazonHomePageDisplayed() {
        return isElementDisplayed(amazonLogo);
    }

    public boolean isListDisplayed() {
        return isElementDisplayed(categoriesList);
    }

    public boolean isVideoGameTitleDisplayed() {
        return isElementDisplayed(videoGamesTitleInList);
    }
}
