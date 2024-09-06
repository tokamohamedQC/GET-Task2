import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;


public class RelatedActions {

    public String readStringFile(int row, int column) throws Exception {
        File src = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx");
        FileInputStream testData = new FileInputStream(src);
        XSSFWorkbook x = new XSSFWorkbook(testData);
        XSSFSheet sheet = x.getSheetAt(0);
        String testDataInput = sheet.getRow(row).getCell(column).getStringCellValue();
        return testDataInput;
    }

    public String readNumericFiled(int row, int column) throws Exception {
        File src = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx");
        FileInputStream testData = new FileInputStream(src);
        XSSFWorkbook x = new XSSFWorkbook(testData);
        XSSFSheet sheet = x.getSheetAt(0);
        String testDataInput = String.valueOf((int)sheet.getRow(row).getCell(column).getNumericCellValue());
        return testDataInput;
    }


    public void screenShots(WebDriver driver, String browser) throws IOException {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile,new File(".//Screen_shots//"+browser+" Test.jpg"));
    }
}
