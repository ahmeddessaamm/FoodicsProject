package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AddressModalPage extends BasePage {
    @FindBy(xpath = "//h4[@id='a-popover-header-2']")
    WebElement addAddressHeader;
    @FindBy(xpath = "//select[@id='address-ui-widgets-countryCode-dropdown-nativeId']")
    WebElement selectCountry;
    @FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressFullName']")
    WebElement fullNameField;
    @FindBy(id = "address-ui-widgets-enterAddressPhoneNumber")
    WebElement phoneNumberField;
    @FindBy(id = "address-ui-widgets-enterAddressLine1")
    WebElement streetNameField;
    @FindBy(id = "address-ui-widgets-enter-building-name-or-number")
    WebElement buildingNameOrNumberField;
    @FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressCity']")
    WebElement cityOrAreaField;
    @FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressDistrictOrCounty']")
    WebElement districtField;
    @FindBy(xpath = "//li[contains(@id, 'address-ui-widgets-autoCompleteResult')]")
    List<WebElement> cityOrDistrictDropDown;
    @FindBy(xpath = "//div[@id='address-ui-widgets-addr-details-res-radio-outer']")
    WebElement selectHomeAsAddressType;
    @FindBy(xpath = "//span[@id='checkout-primary-continue-button-id']")
    WebElement useThisAddressBtn;

    public AddressModalPage(WebDriver driver) {
        super(driver);

    }

    public boolean isAddressModalHeaderDisplayed() {
        return isElementDisplayed(addAddressHeader);
    }

    public void selectCityOrDistrictUsingAutoSuggest(WebElement inputField, String searchTxt, List<WebElement> suggestionList) {
        wait.until(ExpectedConditions.elementToBeClickable(inputField)).sendKeys(searchTxt);
        wait.until(ExpectedConditions.visibilityOfAllElements(suggestionList));
        suggestionList.get(0).click();
    }

    public void addAddress(String country, String fullName, String phoneNumber, String streetName, String buildingNameOrNumber, String city, String district) {

        wait.until(ExpectedConditions.elementToBeClickable(selectCountry));
        Select countrySelect = new Select(selectCountry);
        countrySelect.selectByVisibleText(country); // Select by visible text
        wait.until(ExpectedConditions.elementToBeClickable(fullNameField)).sendKeys(fullName);

        wait.until(ExpectedConditions.elementToBeClickable(phoneNumberField)).sendKeys(phoneNumber);
        wait.until(ExpectedConditions.elementToBeClickable(streetNameField)).sendKeys(streetName);
        wait.until(ExpectedConditions.elementToBeClickable(buildingNameOrNumberField)).sendKeys(buildingNameOrNumber);

        selectCityOrDistrictUsingAutoSuggest(cityOrAreaField, city, cityOrDistrictDropDown);
        selectCityOrDistrictUsingAutoSuggest(districtField, district, cityOrDistrictDropDown);
        wait.until(ExpectedConditions.elementToBeClickable(selectHomeAsAddressType)).click();

    }

    public void clickOnUseThisAddressBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(useThisAddressBtn)).click();

    }
}
