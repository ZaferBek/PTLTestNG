package ptl.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ptl.utilities.Driver;

public class CheckoutPage extends BasePage{
    public CheckoutPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//input[@id='customer-email']")
    public WebElement emailInput;

    @FindBy(xpath = "//input[@id='customer-password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement continueButton;

    @FindBy(xpath = "//ul/li[3]/span[2]")
    public WebElement grandTotalAmount;

    @FindBy(xpath = "//*[@id=\"btn-payment--payNow\"]")
    public WebElement payWithCard;
}
