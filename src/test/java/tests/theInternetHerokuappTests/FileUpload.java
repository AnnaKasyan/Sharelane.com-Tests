package tests.theInternetHerokuappTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class FileUpload extends BaseTest {

    @Test
    public void fileUploadTest() {
        driver.get("http://the-internet.herokuapp.com/upload");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement chooseFileButton = driver.findElement(By.cssSelector("input[id='file-upload']"));
        chooseFileButton.sendKeys("C:\\Users\\Anna\\IdeaProjects\\TMS-QA\\src\\main\\resources\\American_Gothic.jpg");
        WebElement uploadButton = driver.findElement(By.cssSelector(".button"));
        uploadButton.click();
        WebElement file = driver.findElement(By.id("uploaded-files"));
        Assert.assertEquals(file.getText(), "American_Gothic.jpg");
    }
}
