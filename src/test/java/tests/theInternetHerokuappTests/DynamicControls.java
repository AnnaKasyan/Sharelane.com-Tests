package tests.theInternetHerokuappTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class DynamicControls extends BaseTest {

    @Test
    public void addRemoveElementsTest() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement checkbox = driver.findElement(By.cssSelector("[type=checkbox]"));
        checkbox.click();
        WebElement removeAddButton = driver.findElement(By.xpath("//*[@id='checkbox-example']/descendant::button[@type='button']"));
        removeAddButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        wait.until(ExpectedConditions.invisibilityOf(checkbox));
        removeAddButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkbox")));
        WebElement enableDisableButton = driver.findElement(By.xpath("//*[@id='input-example']/descendant::button[@type='button']"));
        Assert.assertEquals(enableDisableButton.getText(), "Enable");
        enableDisableButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        WebElement message = driver.findElement(By.id("message"));
        Assert.assertEquals(message.getText(), "It's enabled!");
        Assert.assertEquals(enableDisableButton.getText(), "Disable");
        enableDisableButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        message = driver.findElement(By.id("message"));
        Assert.assertEquals(message.getText(), "It's disabled!");
        enableDisableButton.click();
        Assert.assertEquals(enableDisableButton.getText(), "Enable");
    }
}
