package pages;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }
    public boolean isElementDisplayed(WebElement webElement){
        try {
            wait.until(ExpectedConditions.visibilityOf(webElement));
            return true;
        } catch (Exception e){
            return false;
        }
    }
    public void safeClick(WebElement element) {
        int attempts = 0;
        while (attempts < 3) {
            try {
                element.click();
                break;
            } catch (ElementClickInterceptedException e) {
                System.out.println("ElementClickInterceptedException: Retrying click...");
                attempts++;
                try {
                    Thread.sleep(500); // Wait before retrying
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

}


