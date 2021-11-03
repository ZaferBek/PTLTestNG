package ptl.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils {
    static WebDriverWait wait = new WebDriverWait(Driver.get(),15);
    public static void clickSafely(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public static String getTextSafely(WebElement element){
       wait.until(ExpectedConditions.visibilityOf(element));
       return element.getText().trim();
    }
}
