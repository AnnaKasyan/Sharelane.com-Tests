package tests.theInternetHerokuappTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownload extends BaseTest {

    @Test
    public void fileDownloadTest() {
        driver.get("http://the-internet.herokuapp.com/download");
        WebElement downloadLink = driver.findElement(By.cssSelector("a[href='download/American_Gothic.jpg']"));
        downloadLink.click();
        boolean fileExists = Files.exists(Paths.get("C:\\Users\\Anna\\Downloads\\American_Gothic.jpg"));
        Assert.assertTrue(fileExists);
    }
}
