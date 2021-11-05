package tests.htmlAndJson;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.util.List;

public class startHtml extends BaseTest {

    @BeforeMethod
    public void linking() {
        driver.get("C:\\Users\\Anna\\IdeaProjects\\TMS-QA\\src\\main\\resources\\MyPage.html");
    }

    @Test
    public void tableTest() {
        List<WebElement> elements = driver.findElements(By.xpath("//table[@style='width:100%']/tbody/tr[1]/th"));
        Assert.assertEquals(elements.get(0).getText(), "№");
        Assert.assertEquals(elements.get(1).getText(), "Person");
        Assert.assertEquals(elements.get(2).getText(), "Country");
        Assert.assertEquals(elements.get(3).getText(), "Phone Number");
        Assert.assertEquals(elements.get(4).getText(), "Order Number");

        List<WebElement> mariaAnders = driver.findElements(By.xpath("//table[@style='width:100%']/tbody/tr[2]/td"));
        Assert.assertEquals(mariaAnders.get(0).getText(), "1");
        Assert.assertEquals(mariaAnders.get(1).getText(), "Maria Anders");
        Assert.assertEquals(mariaAnders.get(2).getText(), "Germany");
        Assert.assertEquals(mariaAnders.get(3).getText(), "+7 10 499604879");
        Assert.assertEquals(mariaAnders.get(4).getText(), "8562");
    }

    @Test
    public void inputTest() {
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("abc");
        WebElement password = driver.findElement(By.id("pwd"));
        password.sendKeys("12345");
        Assert.assertEquals(username.getAttribute("value"), "abc");
        Assert.assertEquals(password.getAttribute("value"), "12345");
    }

    @Test
    public void checkboxTest() {
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("[type=checkbox]"));
        checkboxes.get(0).click();
        Assert.assertTrue(checkboxes.get(0).isSelected(), "The first checkbox 'I like to listen to music' is checked");
        checkboxes.get(4).click();
        Assert.assertTrue(checkboxes.get(4).isSelected(), "The fifth checkbox 'I like to spend time with friends' is checked");
        Assert.assertFalse(checkboxes.get(1).isSelected(), "The second checkbox is unchecked");
    }

    @Test
    public void selectTest() {
        Select select = new Select(driver.findElement(By.id("time")));
        List<WebElement> options = select.getOptions();
        Assert.assertEquals(options.size(), 10);
        options.get(2).click();
        Assert.assertTrue(options.get(2).isSelected(), "11:00 am is selected");
        options.get(7).click();
        Assert.assertTrue(options.get(7).isSelected(), "4:00 pm is selected");
    }

    @Test
    public void RadioButtonsTest() {
        List<WebElement> seasons = driver.findElements(By.cssSelector("[type=radio]"));
        seasons.get(1).click();
        Assert.assertTrue(seasons.get(1).isSelected(), "Summer is checked");
        seasons.get(3).click();
        Assert.assertTrue(seasons.get(3).isSelected(), "Winter is checked");
    }

    @Test
    public void buttonTest() {
        WebElement menButton = driver.findElement(By.xpath("//button[text()='Men']"));
        menButton.click();
    }

    @Test
    public void imagesTest() {
        WebElement painting2 = driver.findElement(By.cssSelector("a[href='https://losko.ru/rene-magritte/']"));
        painting2.click();
        WebElement element = driver.findElement(By.cssSelector("a[href='/']"));
        Assert.assertTrue(element.isDisplayed(), "Page about Rene Magritte should be on display");
    }

    @Test
    public void pTest() {
        WebElement text = driver.findElement(By.xpath("//div[@class='poem']/p[5]"));
        Assert.assertEquals(text.getText(), "And never stops—at all—");
    }

    @Test
    public void aTest() {
        WebElement tens4 = driver.findElement(By.cssSelector("a[href='#tens4']"));
        tens4.click();
        tens4 = driver.findElement(By.id("tens4"));
        Assert.assertTrue(tens4.isDisplayed(), "Present Perfect Continuous should be on display");
    }
}
