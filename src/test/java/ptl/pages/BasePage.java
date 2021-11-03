package ptl.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ptl.utilities.BrowserUtils;
import ptl.utilities.Driver;

import java.util.List;

public abstract class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//ul[@id='primary-navigation']/li//a/span")
    private List<WebElement> categories;

    public void navigate(String str){
        for (int i = 0; i < categories.size(); i++) {
            if(categories.get(i).getText().equalsIgnoreCase(str)){
                BrowserUtils.clickSafely(categories.get(i));
            }
        }
    }
}
