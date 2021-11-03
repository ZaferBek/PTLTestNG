package ptl.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ptl.utilities.Driver;

public class HomePage extends BasePage{
    public HomePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//a[.='Accept All']")
    public WebElement AcceptCookies;

}
