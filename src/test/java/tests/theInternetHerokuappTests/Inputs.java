package tests.theInternetHerokuappTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.BaseTest;

public class Inputs extends BaseTest {
    private WebElement inputField;

    @BeforeMethod
    public void linking() {
        driver.get("http://the-internet.herokuapp.com/inputs");
    }

    @Test
    public void inputsUpDownTest() {
        inputField = driver.findElement(By.tagName("input"));
        inputField.sendKeys(Keys.ARROW_UP, Keys.ARROW_UP);
        inputField = driver.findElement(By.tagName("input"));
        Assert.assertEquals(inputField.getAttribute("value"), "2");
        inputField.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN);
        inputField = driver.findElement(By.tagName("input"));
        Assert.assertEquals(inputField.getAttribute("value"), "-1");
    }

    @Test
    public void inputsNotDigitalTest() {
        inputField = driver.findElement(By.tagName("input"));
        inputField.sendKeys("abc");
        inputField = driver.findElement(By.tagName("input"));
        Assert.assertEquals(inputField.getAttribute("value"), "");
    }

    @Test
    public void inputsDigitalTest() {
        inputField = driver.findElement(By.tagName("input"));
        inputField.sendKeys("5");
        inputField = driver.findElement(By.tagName("input"));
        Assert.assertEquals(inputField.getAttribute("value"), "5");
    }
}
