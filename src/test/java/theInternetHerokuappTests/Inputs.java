package theInternetHerokuappTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Inputs {
    private WebDriver driver;
    private WebElement inputField;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

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
