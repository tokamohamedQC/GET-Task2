import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;


public class OpenBrowser extends SetUp{

    SoftAssert softAssert = new SoftAssert();

    @Test (priority = 1)
    public void ValidScenario(){
        softAssert.assertEquals(success.ThankYou(driver).getText(), "Your registration is completed. We will contact with you soon. Thank you !");
        softAssert.assertAll();
    }

    @Test (priority = 2)
    public void InvalidScenario(){
        Assert.assertEquals(success.ThankYou(driver).getText(), "Test Failure");
    }

}
