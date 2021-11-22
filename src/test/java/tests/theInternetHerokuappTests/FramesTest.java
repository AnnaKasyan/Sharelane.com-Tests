package tests.theInternetHerokuappTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class FramesTest extends BaseTest {

    @Test
    public void framesTest() {
        driver.get("http://the-internet.herokuapp.com/frames");
        WebElement iframeButton = driver.findElement(By.xpath("//li/following::a[@href='/iframe']"));
        iframeButton.click();
        WebElement iFrame = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iFrame);
        WebElement text = driver.findElement(By.cssSelector("body[id='tinymce']"));
        Assert.assertEquals(text.getText(), "Your content goes here.");
        driver.switchTo().defaultContent();
    }
}