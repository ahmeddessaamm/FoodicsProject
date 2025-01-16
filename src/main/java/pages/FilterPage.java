package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class FilterPage extends BasePage {

    @FindBy(xpath = "//span[text()='Free Shipping']")
    WebElement freeShippingFilter;
    @FindBy(xpath = "//span[text()='New']")
    WebElement newConditionFilter;
    @FindBy(id = "s-result-sort-select")
    WebElement sortDropdown;

//    private By newConditionFilter = By.xpath("//span[text()='New']");
//    private By sortDropdown = By.id("s-result-sort-select");

    public FilterPage(WebDriver driver) {
        super(driver);
    }

    public void applyFilters() {
      //  wait.until(ExpectedConditions.visibilityOf(freeShippingFilter)).click();
        wait.until(ExpectedConditions.visibilityOf(newConditionFilter)).click();
    }

    public void sortByPriceHighToLow() {
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOf(sortDropdown));
        Select sortSelect = new Select(dropdown);
        sortSelect.selectByVisibleText("Price: High to Low");
//    }
    }
}
