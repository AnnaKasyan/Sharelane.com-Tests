package tests.theInternetHerokuappTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class HoversTest extends BaseTest {

    @Test
    public void hoversTest () {
        Actions builder = new Actions(driver);

        driver.get("http://the-internet.herokuapp.com/hovers");
        WebElement user1 = driver.findElement(By.xpath("//descendant::div[@class='figure'][1]"));
        builder.moveToElement(user1).build().perform();
        WebElement user1Name = driver.findElement(By.xpath("//h5[text()='name: user1']"));
        Assert.assertTrue(user1Name.isDisplayed());
        WebElement link1 = driver.findElement(By.cssSelector("a[href='/users/1']"));
        link1.click();
        WebElement verifyPage = driver.findElement(By.xpath("//h1[text()='Not Found']"));
        Assert.assertTrue(verifyPage.isDisplayed(), "Error 404");
        driver.navigate().back();

        WebElement user2 = driver.findElement(By.xpath("//descendant::div[@class='figure'][2]"));
        builder.moveToElement(user2).build().perform();
        WebElement user2Name = driver.findElement(By.xpath("//h5[text()='name: user2']"));
        Assert.assertTrue(user2Name.isDisplayed());
        WebElement link2 = driver.findElement(By.cssSelector("a[href='/users/2']"));
        link2.click();
        verifyPage = driver.findElement(By.xpath("//h1[text()='Not Found']"));
        Assert.assertTrue(verifyPage.isDisplayed(),"Error 404");
        driver.navigate().back();

        WebElement user3 = driver.findElement(By.xpath("//descendant::div[@class='figure'][2]"));
        builder.moveToElement(user3).build().perform();
        WebElement user3Name = driver.findElement(By.xpath("//h5[text()='name: user3']"));
        Assert.assertTrue(user3Name.isDisplayed());
        WebElement link3 = driver.findElement(By.cssSelector("a[href='/users/3']"));
        link3.click();
        verifyPage = driver.findElement(By.xpath("//h1[text()='Not Found']"));
        Assert.assertTrue(verifyPage.isDisplayed(),"Error 404");
    }
}
