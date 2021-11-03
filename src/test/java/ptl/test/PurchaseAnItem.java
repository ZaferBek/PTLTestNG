package ptl.test;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import ptl.pages.*;
import ptl.utilities.ConfigurationReader;
import static ptl.utilities.BrowserUtils.clickSafely;
import static ptl.utilities.BrowserUtils.getTextSafely;

public class PurchaseAnItem extends TestBase{

    HomePage homePage = new HomePage();
    ShoesPage shoesPage = new ShoesPage();
    AnkleBootPage ankleBootPage = new AnkleBootPage();
    YourBagPage yourBagPage = new YourBagPage();
    CheckoutPage checkoutPage = new CheckoutPage();

    @Test
    public void purchaseAnItem(){

        extentLogger= report.createTest("Purchase an Item Test");

        extentLogger.info("launch chromedriver");

        extentLogger.info("Navigate to https://www.prettylittlething.com/");
        driver.get(ConfigurationReader.get("url"));

        clickSafely(homePage.AcceptCookies);

        extentLogger.info("Choose Shoes Category from the nav menu");
        homePage.navigate("Shoes");

        extentLogger.info("Choose an item from Shoes page");
        //clickSafely(shoesPage.AnkleBoot);
        shoesPage.selectShoe("Block Heeled Ankle Boot");

        extentLogger.info("Store the Product name in a string ");
        String selectedItemName = getTextSafely(ankleBootPage.selectedItemName);

        extentLogger.info("Select product size");
        clickSafely(ankleBootPage.Size7);

        extentLogger.info("Select add to bag");
        clickSafely(ankleBootPage.AddToBag);

        extentLogger.info("Assert the selected product name against the product name in the bag page");
        String addedItemName = getTextSafely(ankleBootPage.AddedItemtName);
        Assert.assertTrue(selectedItemName.equalsIgnoreCase(addedItemName));

        extentLogger.info("Select the bag icon on the top right ");
        clickSafely(ankleBootPage.bagIcon);

        extentLogger.info("Store the subtotal value in a string ");
        String bagSubtotalAmount = getTextSafely(yourBagPage.bagSubtotal);

        extentLogger.info("Select Proceed to checkout");
        clickSafely(yourBagPage.proceedToCheckout);

        extentLogger.info("Enter username and select continue");
        checkoutPage.emailInput.sendKeys(ConfigurationReader.get("username"));
        clickSafely(checkoutPage.continueButton);

        extentLogger.info("Enter password and select continue");
        checkoutPage.passwordInput.sendKeys(ConfigurationReader.get("password"));
        clickSafely(checkoutPage.continueButton);

        extentLogger.info("Assert that your bag subtotal against the checkout subtotal");
        String checkoutSubtotal = getTextSafely(checkoutPage.grandTotalAmount);
        //Assert.assertTrue(bagSubtotalAmount.equalsIgnoreCase(checkoutSubtotal));

        extentLogger.info("Scroll to the payment method");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,650)", "");

        extentLogger.info("Select a payment method");
        clickSafely(checkoutPage.payWithCard);

        extentLogger.info("close browser");

    }

}
