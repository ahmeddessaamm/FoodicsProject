package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;
import java.util.List;

public class CheckOutPage extends BasePage {
    @FindBy(id = "add-new-address-desktop-sasp-tango-link")
    WebElement addNewDeliveryAddressBtn;

    @FindBy(id = "subtotals-marketplace-table")
    WebElement subtotalsTable;

    public CheckOutPage(WebDriver driver) {
        super(driver);

    }

    public void clickOnAddNewDeliveryAddressBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(addNewDeliveryAddressBtn)).click();

    }

    public HashMap<String, Double> getOrderPrices() {
        wait.until(ExpectedConditions.visibilityOf(subtotalsTable));

        HashMap<String, Double> prices = new HashMap<>();


        List<WebElement> rows = subtotalsTable.findElements(By.xpath(".//tr"));

        for (WebElement row : rows) {
            wait.until(ExpectedConditions.visibilityOfAllElements(row));

            List<WebElement> cells = row.findElements(By.tagName("td"));
            if (cells.size() == 2) {
                wait.until(ExpectedConditions.visibilityOfAllElements(cells));

                String label = cells.get(0).getText().trim();
                String priceText = cells.get(1).getText().trim().replace("EGP", "").replace(",", "").replace("-", "").trim();


                double price = priceText.isEmpty() ? 0.0 : Double.parseDouble(priceText);


                prices.put(label, price);
            }
        }

        return prices;
    }

    public boolean validateOrderTotal() {
        wait.until(ExpectedConditions.visibilityOf(subtotalsTable));

        HashMap<String, Double> prices = getOrderPrices();

        double itemsPrice = prices.getOrDefault("Items:", 0.0);
        System.out.println("Item price equal : " + itemsPrice);
        double shippingPrice = prices.getOrDefault("Shipping & handling:", 0.0);
        System.out.println("Shipping price equal : " + shippingPrice);

        double totalPrice = prices.getOrDefault("Total:", 0.0);
        System.out.println("total price equal : " + totalPrice);

        double freeDelivery = -prices.getOrDefault("Free Delivery", 0.0); // Free delivery is negative
        System.out.println("Delivery price equal : " + freeDelivery);

        double orderTotal = prices.getOrDefault("Order total", 0.0);
        System.out.println("Order Total price equal : " + orderTotal);

        double calculatedTotal = itemsPrice + shippingPrice + freeDelivery;
        System.out.println("Calculated Total price equal : " + calculatedTotal);

        return orderTotal == calculatedTotal;
    }
}

