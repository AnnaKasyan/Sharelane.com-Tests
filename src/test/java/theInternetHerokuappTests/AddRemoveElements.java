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

public class AddRemoveElements {
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
    public void addRemoveElementsTest() {
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addButton = driver.findElement(By.xpath("//button[text()='Add Element']"));
        addButton.click();
        addButton.click();
        List<WebElement> deleteButtons = driver.findElements(By.xpath("//button[text()='Delete']"));
        deleteButtons.get(0).click();
        deleteButtons = driver.findElements(By.xpath("//button[text()='Delete']"));
        Assert.assertEquals(deleteButtons.size(), 1);
    }

}
