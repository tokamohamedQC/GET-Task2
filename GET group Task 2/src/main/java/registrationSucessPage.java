import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class registrationSucessPage {

    public WebElement ThankYou(WebDriver driver){
        By registrationSucess = By.xpath("//div[@class=\"nf-response-msg\"]//p");
        WebElement successMessage_Element = driver.findElement(registrationSucess);
        return successMessage_Element;
    }
}
