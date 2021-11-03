package ptl.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ptl.utilities.Driver;

public class AnkleBootPage {
    public AnkleBootPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//p[contains(text(),'Croc Wide Fit Behati Block Heeled Ankle Boot')]")
    public WebElement AddedItemtName;

    @FindBy(xpath = "//h1[text()='Croc Wide Fit Behati Block Heeled Ankle Boot']")
    public WebElement selectedItemName;

    @FindBy(xpath = "//div[contains(text(),'7')]")
    public WebElement Size7;

    @FindBy(xpath = "//button[@id='add-to-bag']")
    public WebElement AddToBag;

    @FindBy(xpath = "//span[@class='bag-icon']")
    public WebElement bagIcon;
}
