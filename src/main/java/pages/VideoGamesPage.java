package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class VideoGamesPage extends BasePage {
    @FindBy(xpath = "//b[normalize-space()='Video Games']")
    WebElement videoGamesPageTitle;
    @FindBy(xpath = "//div[contains(@data-component-type, 's-search-result')][.//*[contains(@class,'puis-atcb-container')]]//*[contains(@class, 'a-price-whole')]")
    List<WebElement> priceElements;
    @FindBy(xpath = "//div[@data-csa-c-content-id='s-search-add-to-cart-action']")
    List<WebElement> addToCartButtons;
    @FindBy(xpath = "//a[text()='Next']")
    WebElement nextPage;




    @FindBy(id = "nav-cart-count-container")
    WebElement cartLink;
    int totalProductsAdded = 0;
    int totalProductsPrice = 0;

    public VideoGamesPage(WebDriver driver) {
        super(driver);

    }


    public boolean isVideoGamePageTitleDisplayed() {
        return isElementDisplayed(videoGamesPageTitle);
    }

    public void addProductsBelowPrice(int maxPrice) {
        boolean stopPagination = false; // Flag to control pagination

        while (!stopPagination) {
            // Refresh the lists dynamically on every iteration
            List<WebElement> prices = priceElements;
            List<WebElement> addToCart = addToCartButtons;

            if (!prices.isEmpty() && !addToCart.isEmpty()) {
                boolean productsBelowMaxPriceFound = false;


                // Iterate through all detected prices
                for (int i = 0; i < prices.size(); i++) {
                    try {
                        if (i < addToCart.size() && addToCart.get(i).isDisplayed()) {
                            // Extract and parse the price
                            String priceText = prices.get(i).getText().replaceAll("[^0-9]", ""); // Remove non-numeric characters


                            if (!priceText.isEmpty()) {
                                int price = Integer.parseInt(priceText);
                                // Check if the price is below the threshold
                                if (price < maxPrice) {
                                    // Check if a corresponding "Add to Cart" button exists

                                    addToCart.get(i).click();
                                    System.out.println("Added product with price: " + price + " to cart.");
                                    totalProductsAdded++;
                                    totalProductsPrice += price;
                                    Thread.sleep(5000);
                                    productsBelowMaxPriceFound = true;

                                }
                            } else {
                                System.err.println("No 'Add to Cart' button for product at index: " + i);

                            }
                        }
                    } catch (Exception e) {
                        System.err.println("Error processing product at index " + i + ": " + e.getMessage());
                    }
                }

                // Stop pagination if products below the max price were found
                if (productsBelowMaxPriceFound) {
                    stopPagination = true;
                } else {
                    // Try to navigate to the next page
                    try {
                        wait.until(ExpectedConditions.visibilityOf(nextPage));
                        if (nextPage.isDisplayed()) {
                            nextPage.click();
                            System.out.println("Navigated to the next page.");
                            wait.until(ExpectedConditions.visibilityOfAllElements(priceElements));

                        } else {
                            stopPagination = true; // No more pages available
                        }
                    } catch (Exception e) {
                        System.err.println("No more pages or navigation error: " + e.getMessage());
                        stopPagination = true;
                    }
                }
            } else {
                System.err.println("No prices or add-to-cart buttons found on this page.");
                //stopPagination = true; // End loop if no elements are found
            }
        }

        System.out.println("Total products added to cart: " + totalProductsAdded);
        System.out.println("Total prices of the products added to cart: " + totalProductsPrice);
    }

    public int getTotalProductsAdded() {
        return totalProductsAdded;
    }

    public int getTotalProductsPrice() {
        return totalProductsPrice;
    }

    public void clickOnCartBtn() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(arguments[0], arguments[1]);", 1452, -1);
        wait.until(ExpectedConditions.visibilityOf(cartLink));
        wait.until(ExpectedConditions.elementToBeClickable(cartLink)).click();

    }
}




