package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{

        @FindBy  (id= "ap_email")
         WebElement emailField ;

        @FindBy (id="continue")
        WebElement continueButton;

    @FindBy (id="ap_password")
        WebElement passwordField;

    @FindBy (id="signInSubmit")
    WebElement signInButton;


        public LoginPage(WebDriver driver) {
            super(driver);
        }

        public void login(String email, String password) {
            wait.until(ExpectedConditions.visibilityOf(emailField)).sendKeys(email);
            wait.until(ExpectedConditions.visibilityOf(continueButton)).click();
            wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(password);
            wait.until(ExpectedConditions.visibilityOf(signInButton)).click();
        }
    }


