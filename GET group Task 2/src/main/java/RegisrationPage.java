import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class RegisrationPage {
    Random random = new Random();
    int rand = random.nextInt(100000);

    public WebElement FirstNameInput(WebDriver driver){
        By FN_input = By.xpath("//input[@name=\"fname\"]");
        WebElement FN_InputElement = driver.findElement(FN_input);
        return FN_InputElement;
    }

    public WebElement LastNameInput(WebDriver driver){
        By LN_input = By.xpath("//input[@name=\"lname\"]");
        WebElement LN_InputElement = driver.findElement(LN_input);
        return LN_InputElement;
    }


    public WebElement EmailInput(WebDriver driver){
        By email_input = By.xpath("//input[@name=\"email\"]");
        WebElement email_InputElement = driver.findElement(email_input);
        return email_InputElement;
    }

    public WebElement PhoneInput(WebDriver driver){
        By phone_input = By.xpath("//input[@name=\"nf-field-20\"]");
        WebElement phone_InputElement = driver.findElement(phone_input);
        return phone_InputElement;
    }

    public WebElement CourseInput(WebDriver driver){
        By phone_input = By.xpath("(//select)[1]");
        WebElement phone_InputElement = driver.findElement(phone_input);
        return phone_InputElement;
    }

    public WebElement Platform(WebDriver driver){
        By platform_input = By.xpath("(//ul[@aria-describedby=\"nf-error-23\"]//li)[1]");
        WebElement platform_Element = driver.findElement(platform_input);
        return platform_Element;
    }

    public WebElement Submit(WebDriver driver){
        By submit_btn = By.xpath("//input[@type=\"submit\"]");
        WebElement submit_Element = driver.findElement(submit_btn);
        return submit_Element;
    }

    public void FirstNameInputText(WebDriver driver, String text){
        FirstNameInput(driver).sendKeys(text);
    }

    public void LastNameInputText(WebDriver driver, String text){
        LastNameInput(driver).sendKeys(text);
    }

    public void SelectCourse(WebDriver driver){
        Select select = new Select(CourseInput(driver));
        select.selectByValue("selenium-automation");
    }

    public void PhoneInputText(WebDriver driver, String text){
        PhoneInput(driver).sendKeys("20"+ text);
    }

    public void EmailInputText(WebDriver driver, String text){
        EmailInput(driver).sendKeys(text + rand +"@gmail.com");
    }

    public void clickPlatform(WebDriver driver){
        Platform(driver).click();
    }

    public void register(WebDriver driver){
        Submit(driver).click();
    }



}
