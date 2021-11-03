package ptl.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ptl.utilities.Driver;

public class YourBagPage extends BasePage {
    public YourBagPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//div[2]/div[5]/p/span")
    public WebElement bagSubtotal;

    @FindBy(xpath = "//span[contains(text(),'Proceed to Checkout')]")
    public WebElement proceedToCheckout;
}
