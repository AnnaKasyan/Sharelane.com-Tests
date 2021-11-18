package tests.theInternetHerokuappTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class NotificationMessageTest extends BaseTest {

    @Test
    public void notificationMessageTest() {
        driver.get("http://the-internet.herokuapp.com/notification_message_rendered");
        WebElement clickHere = driver.findElement(By.cssSelector("a[href='/notification_message']"));
        clickHere.click();
        WebElement message = driver.findElement(By.id("flash"));
        Assert.assertEquals(message.getText(), "Action successful", "Message about unsuccessful action on display");
    }
}
