package tests.theInternetHerokuappTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.util.List;

public class DropdownTest extends BaseTest {

    @Test
    public void dropdownTest() {
        driver.get("http://the-internet.herokuapp.com/dropdown");
        Select select = new Select(driver.findElement(By.id("dropdown")));
        List<WebElement> options = select.getOptions();
        Assert.assertEquals(options.size(), 3);
        Assert.assertTrue(options.get(0).isSelected(), "Please select an option - on display");
        options.get(1).click();
        Assert.assertTrue(options.get(1).isSelected(), "Option 1 is selected");
        options.get(2).click();
        Assert.assertTrue(options.get(2).isSelected(), "Option 1 is selected");
    }
}
