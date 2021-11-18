package tests.theInternetHerokuappTests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class ContextMenuTest extends BaseTest {


    public boolean isAlertDisplayed() {
        boolean onDisplay;
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            onDisplay = true;
        } catch (TimeoutException ex) {
            onDisplay = false;
        }
        return onDisplay;
    }

    @Test
    public void addRemoveElementsTest() {
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement box = driver.findElement(By.cssSelector("#hot-spot"));
        actions.contextClick(box).perform();
        Assert.assertTrue(isAlertDisplayed());
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "You selected a context menu");
        alert.accept();
    }
}

