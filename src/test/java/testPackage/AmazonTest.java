package testPackage;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.AddressDataHelper;
import utils.JsonDataReader;

public class AmazonTest extends BaseTest {


    @Test
    public void testAmazonAutomation() throws InterruptedException {

        loginPage.login(config.getProperty("email"), config.getProperty("password"));
        Assert.assertTrue(homePage.isAmazonHomePageDisplayed());

        homePage.navigateToVideoGamesList();
        Assert.assertTrue(homePage.isListDisplayed());

        homePage.clickOnSeeAllBtn();
        homePage.clickOnVideoGamesBtn();
        Assert.assertTrue(homePage.isVideoGameTitleDisplayed());

        homePage.navigateToVideoGamesScreen();
        Assert.assertTrue(videoGamesPage.isVideoGamePageTitleDisplayed());

        filterPage.applyFilters();
        filterPage.sortByPriceHighToLow();
        videoGamesPage.addProductsBelowPrice(15000);
        videoGamesPage.clickOnCartBtn();
        Assert.assertTrue(cartPage.isCartPageTitleDisplayed());
        Assert.assertEquals(videoGamesPage.getTotalProductsAdded(), cartPage.getNumberOfItemsInCart());
        Assert.assertEquals(videoGamesPage.getTotalProductsPrice(), cartPage.getTotalPriceOfProductsInCart());
        cartPage.clickOnProceedToBuyBtn();
        checkOutPage.clickOnAddNewDeliveryAddressBtn();


        Assert.assertTrue(addressModalPage.isAddressModalHeaderDisplayed());

        // Call the addAddress method with extracted data
        addressModalPage.addAddress(addressData.getCountry(), addressData.getFullName(), addressData.getPhoneNumber(), addressData.getStreetName(), addressData.getBuildingNameOrNumber(), addressData.getCity(), addressData.getArea());
        addressModalPage.clickOnUseThisAddressBtn();
        Thread.sleep(5000);
        Assert.assertTrue(checkOutPage.validateOrderTotal());

    }
}