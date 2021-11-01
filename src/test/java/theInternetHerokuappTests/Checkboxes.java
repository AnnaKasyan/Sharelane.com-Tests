package theInternetHerokuappTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Checkboxes {
    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

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
