package tests.theInternetHerokuappTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class DynamicControlsTest extends BaseTest {

    @Test
    public void addRemoveElementsTest() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        WebElement checkbox = driver.findElement(By.cssSelector("[type=checkbox]"));
        checkbox.click();
        WebElement removeAddButton = driver.findElement(By.xpath("//*[@id='checkbox-example']/descendant::button[@type='button']"));
        Assert.assertEquals(removeAddButton.getText(), "Remove");
        removeAddButton.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#loading")));
        wait.until(ExpectedConditions.and(
                textToBe((By.cssSelector("#message")), "It's gone!"),
                invisibilityOf(checkbox)));
        Assert.assertEquals(removeAddButton.getText(), "Add");
        removeAddButton.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#loading")));
        wait.until(ExpectedConditions.and(
                textToBe((By.cssSelector("#message")), "It's back!"),
                visibilityOfElementLocated(By.cssSelector("#checkbox"))));

        WebElement enableDisableButton = driver.findElement(By.xpath("//*[@id='input-example']/descendant::button[@type='button']"));
        Assert.assertEquals(enableDisableButton.getText(), "Enable");
        enableDisableButton.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#loading")));
        wait.until(textToBe((By.cssSelector("#message")), "It's enabled!"));
        Assert.assertEquals(enableDisableButton.getText(), "Disable");
        enableDisableButton.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#loading")));
        wait.until(textToBe((By.cssSelector("#message")), "It's disabled!"));
        Assert.assertEquals(enableDisableButton.getText(), "Enable");
        enableDisableButton.click();
    }
}
