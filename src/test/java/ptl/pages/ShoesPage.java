package ptl.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ptl.utilities.BrowserUtils;
import ptl.utilities.Driver;

import java.util.List;
import java.util.Locale;

public class ShoesPage {
    public ShoesPage(){
        PageFactory.initElements(Driver.get(),this);
    }

//    @FindBy(xpath = "//h2[contains(text(),'Croc Wide Fit Behati Block Heeled Ankle Boot')]")
//    public WebElement AnkleBoot;

    @FindBy(xpath = "//div[@class='category-product js-productitem']//h2")
    private List<WebElement> shoeProducts;

    public void selectShoe(String str){
        for (int i = 0; i < shoeProducts.size(); i++) {
            if(shoeProducts.get(i).getText().toLowerCase().contains(str.toLowerCase())){
                BrowserUtils.clickSafely(shoeProducts.get(i));
            }
        }
    }

}
