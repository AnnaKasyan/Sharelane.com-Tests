package tests.theInternetHerokuappTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.util.List;

public class Checkboxes extends BaseTest {

    @Test
    public void checkboxesTest() {
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("[type=checkbox]"));
        Assert.assertFalse(checkboxes.get(0).isSelected(), "The first checkbox is unchecked");
        checkboxes.get(0).click();
        Assert.assertTrue(checkboxes.get(0).isSelected(), "The first checkbox is checked");
        Assert.assertTrue(checkboxes.get(1).isSelected(), "The second checkbox is checked");
        checkboxes.get(1).click();
        Assert.assertFalse(checkboxes.get(1).isSelected(), "The second checkbox is unchecked");
    }
}
