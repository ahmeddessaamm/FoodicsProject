package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CartPage extends BasePage{
    @FindBy(id = "sc-buy-box-ptc-button")
    WebElement proceedToBuyBtn;
    @FindBy(id = "sc-subtotal-amount-activecart")
   WebElement totalAmountInCart;
    @FindBy(id = "sc-active-items-header")
    WebElement shoppingCartHeader;
    @FindBy(xpath = "//div[@id='sc-active-cart']//div[contains(@class,'a-row sc-list-item sc-java-remote-feature')]")
    List<WebElement> itemsInCart;

//div[@id='sc-active-cart']//div[contains(@class,'a-row sc-list-item sc-java-remote-feature')]




    public CartPage(WebDriver driver) {
        super(driver);

    }


    public int getNumberOfItemsInCart() {

            // Return the count of elements in the cart
            return itemsInCart.size();
        }

    public int getTotalPriceOfProductsInCart() {

        String priceText = totalAmountInCart.getText();
        String numericPrice = priceText.replace("EGP", "")
                .replace(".00", "")
                .replace(",", "")
                .trim();

        // Convert to integer and return
        return Integer.parseInt(numericPrice);
    }
    public boolean isCartPageTitleDisplayed() {
        return isElementDisplayed(shoppingCartHeader);
    }

    public void clickOnProceedToBuyBtn (){
        wait.until(ExpectedConditions.elementToBeClickable(proceedToBuyBtn)).click();

    }
}
