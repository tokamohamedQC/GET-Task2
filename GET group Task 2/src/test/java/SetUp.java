import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class SetUp {
    WebDriver driver = null;
    Properties prop;
    String configPath = "configuration.properties";
    RegisrationPage registration = new RegisrationPage();
    RelatedActions relatedActions = new RelatedActions();
    registrationSucessPage success = new registrationSucessPage();

    @BeforeMethod
    //@Parameters("browser") /* If you want to use testng.xml file pass browser argument in open()
    // , in switch() and comment the reading from config file lines (26-28)
    public void Open() throws Exception {

        prop = new Properties();
        InputStream input = new FileInputStream(configPath);
        prop.load(input);

        switch (prop.getProperty("browser")){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
        }
        driver.manage().window().maximize();
        driver.navigate().to(relatedActions.readStringFile(0, 0));
        WebDriverWait wait = new WebDriverWait(driver,10);
        registration.FirstNameInputText(driver, relatedActions.readStringFile(1,0));
        registration.LastNameInputText(driver, relatedActions.readStringFile(2,0));
        registration.EmailInputText(driver, relatedActions.readStringFile(3,0));
        registration.PhoneInputText(driver, relatedActions.readNumericFiled(4,0));
        registration.SelectCourse(driver);
        registration.clickPlatform(driver);
        registration.register(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"nf-response-msg\"]//p")));



    }

    @AfterMethod
    public void Close() throws IOException {
        prop = new Properties();
        InputStream input = new FileInputStream(configPath);
        prop.load(input);
        relatedActions.screenShots(driver, prop.getProperty("browser"));
        driver.close();
    }
}
