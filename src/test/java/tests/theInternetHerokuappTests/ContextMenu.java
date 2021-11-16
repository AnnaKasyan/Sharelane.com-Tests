package tests.theInternetHerokuappTests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class ContextMenu extends BaseTest {

    public boolean isAlertDisplayed() {
        boolean onDisplay;
        WebDriverWait wait = new WebDriverWait(driver, 10);
        if (wait.until(ExpectedConditions.alertIsPresent()) == null) {
            onDisplay = false;
        } else {
            onDisplay = true;
        }
        return onDisplay;
    }

    @Test
    public void addRemoveElementsTest() {
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement box = driver.findElement(By.cssSelector("#hot-spot"));
        actions.contextClick(box).perform();
        Assert.assertTrue(isAlertDisplayed());
        Alert alert = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(alert.getText(), "You selected a context menu");
        alert.accept();
    }
}

