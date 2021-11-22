package tests.theInternetHerokuappTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class TyposTest extends BaseTest {

    @Test
    public void typosTest() {
        driver.get("http://the-internet.herokuapp.com/typos");
        WebElement text = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p[2]"));
        Assert.assertEquals(text.getText(), "Sometimes you'll see a typo, other times you won't.", "The word 'won,t' is misspelled");
    }
}
