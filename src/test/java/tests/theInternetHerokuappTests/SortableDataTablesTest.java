package tests.theInternetHerokuappTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.util.List;

public class SortableDataTablesTest extends BaseTest {

    @Test
    public void sortableDataTablesTest() {

        driver.get("http://the-internet.herokuapp.com/tables");
        List<WebElement> elements = driver.findElements(By.className("header"));
        Assert.assertEquals(elements.get(0).getText(), "Last Name");
        Assert.assertEquals(elements.get(1).getText(), "First Name");
        Assert.assertEquals(elements.get(2).getText(), "Email");
        Assert.assertEquals(elements.get(3).getText(), "Due");
        Assert.assertEquals(elements.get(4).getText(), "Web Site");
        Assert.assertEquals(elements.get(5).getText(), "Action");

        List<WebElement> smithJohn = driver.findElements(By.xpath("//tbody/tr[1]/td"));
        Assert.assertEquals(smithJohn.get(0).getText(), "Smith");
        Assert.assertEquals(smithJohn.get(1).getText(), "John");
        Assert.assertEquals(smithJohn.get(2).getText(), "jsmith@gmail.com");
        Assert.assertEquals(smithJohn.get(3).getText(), "$50.00");
        Assert.assertEquals(smithJohn.get(4).getText(), "http://www.jsmith.com");
        Assert.assertEquals(smithJohn.get(5).getText(), "edit delete");

        List<WebElement> bachFrank = driver.findElements(By.xpath("//tbody/tr[2]/td"));
        Assert.assertEquals(bachFrank.get(0).getText(), "Bach");
        Assert.assertEquals(bachFrank.get(1).getText(), "Frank");
        Assert.assertEquals(bachFrank.get(2).getText(), "fbach@yahoo.com");
        Assert.assertEquals(bachFrank.get(3).getText(), "$51.00");
        Assert.assertEquals(bachFrank.get(4).getText(), "http://www.frank.com");
        Assert.assertEquals(bachFrank.get(5).getText(), "edit delete");

        List<WebElement> doeJason = driver.findElements(By.xpath("//tbody/tr[3]/td"));
        Assert.assertEquals(doeJason.get(0).getText(), "Doe");
        Assert.assertEquals(doeJason.get(1).getText(), "Jason");
        Assert.assertEquals(doeJason.get(2).getText(), "jdoe@hotmail.com");
        Assert.assertEquals(doeJason.get(3).getText(), "$100.00");
        Assert.assertEquals(doeJason.get(4).getText(), "http://www.jdoe.com");
        Assert.assertEquals(doeJason.get(5).getText(), "edit delete");

        List<WebElement> conwayTim = driver.findElements(By.xpath("//tbody/tr[4]/td"));
        Assert.assertEquals(conwayTim.get(0).getText(), "Conway");
        Assert.assertEquals(conwayTim.get(1).getText(), "Tim");
        Assert.assertEquals(conwayTim.get(2).getText(), "tconway@earthlink.net");
        Assert.assertEquals(conwayTim.get(3).getText(), "$50.00");
        Assert.assertEquals(conwayTim.get(4).getText(), "http://www.timconway.com");
        Assert.assertEquals(conwayTim.get(5).getText(), "edit delete");
    }
}
