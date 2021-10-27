import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class ShareLaneTests {

    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void zipCodePositiveTest() throws InterruptedException {
        // Navigate https://www.sharelane.com/
        driver.get("https://www.sharelane.com/");
        WebElement enterButton = driver.findElement(By.cssSelector("a[href='../cgi-bin/main.py']"));
        enterButton.click();
        // Click "Sign up" link
        WebElement singUpLink = driver.findElement(By.cssSelector("a[href='./register.py']"));
        singUpLink.click();
        // Enter 5 digits to ZIP code field
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("12345");
        // Click "Continue" button
        WebElement continueButton = driver.findElement(By.cssSelector("input[value = 'Continue']"));
        continueButton.click();
        //Verify that user is redirected to "Sign up" page
        WebElement registerButton = driver.findElement(By.cssSelector("input[value = 'Register']"));
        zipCodeInput = driver.findElement(By.name("zip_code"));
        Assert.assertFalse(zipCodeInput.isDisplayed(), "Zip code input should be hidden");
        Assert.assertTrue(registerButton.isDisplayed(), "Register button should be display");
    }

    @Test
    public void ZipCodeTest() {
        // Navigate https://www.sharelane.com/
        driver.get("https://www.sharelane.com/");
        WebElement enterButton = driver.findElement(By.cssSelector("a[href='../cgi-bin/main.py']"));
        enterButton.click();
        // Click "Sign up" link
        WebElement singUpLink = driver.findElement(By.cssSelector("a[href='./register.py']"));
        singUpLink.click();
        // Click "Continue" button
        WebElement continueButton = driver.findElement(By.cssSelector("input[value = 'Continue']"));
        continueButton.click();
        //Verify that user is stayed on "Sign up" page
        WebElement errorMessage = driver.findElement(By.className("error_message"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error Message should be display");
    }

    @Test
    public void zipCodeFourDigitsTest() {
        driver.get("https://www.sharelane.com/");
        WebElement enterButton = driver.findElement(By.cssSelector("a[href='../cgi-bin/main.py']"));
        enterButton.click();
        WebElement singUpLink = driver.findElement(By.cssSelector("a[href='./register.py']"));
        singUpLink.click();
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("1234");
        WebElement continueButton = driver.findElement(By.cssSelector("input[value = 'Continue']"));
        continueButton.click();
        //VVerify that user is stayed on "Sign up" page
        WebElement registerButton = driver.findElement(By.cssSelector("input[value = 'Continue']"));
        Assert.assertTrue(registerButton.isDisplayed(), "Continue button should be display");
    }

    @Test
    public void zipCodeSixDigitsTest() {
        driver.get("https://www.sharelane.com/");
        WebElement enterButton = driver.findElement(By.cssSelector("a[href='../cgi-bin/main.py']"));
        enterButton.click();
        WebElement singUpLink = driver.findElement(By.cssSelector("a[href='./register.py']"));
        singUpLink.click();
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("123456");
        WebElement continueButton = driver.findElement(By.cssSelector("input[value = 'Continue']"));
        continueButton.click();
        //Verify that user is stayed on "Sign up" page
        WebElement registerButton = driver.findElement(By.cssSelector("input[value = 'Register']"));
        Assert.assertFalse(registerButton.isDisplayed(), "Register button should be display");
    }

    @Test
    public void registerPositiveTest() {
        driver.get("https://www.sharelane.com/");
        WebElement enterButton = driver.findElement(By.cssSelector("a[href='../cgi-bin/main.py']"));
        enterButton.click();
        WebElement singUpLink = driver.findElement(By.cssSelector("a[href='./register.py']"));
        singUpLink.click();
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("12345");
        WebElement continueButton = driver.findElement(By.cssSelector("input[value = 'Continue']"));
        continueButton.click();
        WebElement firstNameInput = driver.findElement(By.name("first_name"));
        firstNameInput.sendKeys("Anna");
        WebElement lastNameInput = driver.findElement(By.name("last_name"));
        lastNameInput.sendKeys("Kas");
        WebElement emailNameInput = driver.findElement(By.name("email"));
        emailNameInput.sendKeys("abcd@gmail.com");
        WebElement passwordInput = driver.findElement(By.name("password1"));
        passwordInput.sendKeys("1234");
        WebElement confirmPasswordInput = driver.findElement(By.name("password2"));
        confirmPasswordInput.sendKeys("1234");
        WebElement registerButton = driver.findElement(By.cssSelector("input[value = 'Register']"));
        registerButton.click();
        //Verify that user is created an account
        WebElement confirmationMessage = driver.findElement(By.className("confirmation_message"));
        Assert.assertTrue(confirmationMessage.isDisplayed(), "Account is created");
    }

    @Test
    public void registerNegativeTest() {
        driver.get("https://www.sharelane.com/");
        WebElement enterButton = driver.findElement(By.cssSelector("a[href='../cgi-bin/main.py']"));
        enterButton.click();
        WebElement singUpLink = driver.findElement(By.cssSelector("a[href='./register.py']"));
        singUpLink.click();
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("12345");
        WebElement continueButton = driver.findElement(By.cssSelector("input[value = 'Continue']"));
        continueButton.click();
        WebElement firstNameInput = driver.findElement(By.name("first_name"));
        firstNameInput.sendKeys("Anna");
        WebElement lastNameInput = driver.findElement(By.name("last_name"));
        lastNameInput.sendKeys("Kas");
        WebElement emailNameInput = driver.findElement(By.name("email"));
        emailNameInput.sendKeys("abcd@gmail.com");
        WebElement passwordInput = driver.findElement(By.name("password1"));
        passwordInput.sendKeys("1111");
        WebElement confirmPasswordInput = driver.findElement(By.name("password2"));
        confirmPasswordInput.sendKeys("dfg");
        WebElement registerButton = driver.findElement(By.cssSelector("input[value = 'Register']"));
        registerButton.click();
        //Verify that user isn't created an account
        WebElement errorMessage = driver.findElement(By.className("error_message"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Invalid fields");
    }

    @Test
    public void emptyShoppingCartTest() {
        driver.get("https://www.sharelane.com/");
        WebElement enterButton = driver.findElement(By.cssSelector("a[href='../cgi-bin/main.py']"));
        enterButton.click();
        WebElement TestPortal = driver.findElement(By.cssSelector("a[href='../test_portal.html']"));
        TestPortal.click();
        WebElement AccountCreator = driver.findElement(By.cssSelector("a[href='../cgi-bin/create_account.py']"));
        AccountCreator.click();
        WebElement buttonCreate = driver.findElement(By.cssSelector("input[value = 'Create new user account']"));
        buttonCreate.click();
        WebElement buttonAutoLogin = driver.findElement(By.cssSelector("input[value = 'Auto Login']"));
        buttonAutoLogin.click();
        WebElement shoppingCart = driver.findElement(By.cssSelector("a[href='./shopping_cart.py']"));
        shoppingCart.click();
        WebElement confirmationMessage = driver.findElement(By.className("confirmation_message"));
        Assert.assertFalse(confirmationMessage.isSelected(), "Cart should be empty");
    }

    @Test
    public void addBookToShoppingCartTest() {
        driver.get("https://www.sharelane.com/");
        WebElement enterButton = driver.findElement(By.cssSelector("a[href='../cgi-bin/main.py']"));
        enterButton.click();
        WebElement TestPortal = driver.findElement(By.cssSelector("a[href='../test_portal.html']"));
        TestPortal.click();
        WebElement AccountCreator = driver.findElement(By.cssSelector("a[href='../cgi-bin/create_account.py']"));
        AccountCreator.click();
        WebElement buttonCreate = driver.findElement(By.cssSelector("input[value = 'Create new user account']"));
        buttonCreate.click();
        WebElement buttonAutoLogin = driver.findElement(By.cssSelector("input[value = 'Auto Login']"));
        buttonAutoLogin.click();
        WebElement searchInput = driver.findElement(By.name("keyword"));
        searchInput.sendKeys("Great Expectations");
        WebElement searchButton = driver.findElement(By.cssSelector("input[value = 'Search']"));
        searchButton.click();
        WebElement addButton = driver.findElement(By.cssSelector("a[href='./add_to_cart.py?book_id=1']"));
        addButton.click();
        WebElement confirmationMessage = driver.findElement(By.className("confirmation_message"));
        Assert.assertTrue(confirmationMessage.isDisplayed(), "Book was added to the Shopping Cart");
        WebElement shoppingCart = driver.findElement(By.cssSelector("a[href='./shopping_cart.py']"));
        shoppingCart.click();
        WebElement updateButton = driver.findElement(By.cssSelector("input[value = 'Update']"));
        Assert.assertTrue(updateButton.isDisplayed(), "Update button should be display");
    }

    @Test
    public void add10BooksToShoppingCartTest() {
        driver.get("https://www.sharelane.com/");
        WebElement enterButton = driver.findElement(By.cssSelector("a[href='../cgi-bin/main.py']"));
        enterButton.click();
        WebElement TestPortal = driver.findElement(By.cssSelector("a[href='../test_portal.html']"));
        TestPortal.click();
        WebElement AccountCreator = driver.findElement(By.cssSelector("a[href='../cgi-bin/create_account.py']"));
        AccountCreator.click();
        WebElement buttonCreate = driver.findElement(By.cssSelector("input[value = 'Create new user account']"));
        buttonCreate.click();
        WebElement buttonAutoLogin = driver.findElement(By.cssSelector("input[value = 'Auto Login']"));
        buttonAutoLogin.click();
        WebElement searchInput = driver.findElement(By.name("keyword"));
        searchInput.sendKeys("White Fang");
        WebElement searchButton = driver.findElement(By.cssSelector("input[value = 'Search']"));
        searchButton.click();
        WebElement addButton = driver.findElement(By.cssSelector("a[href='./add_to_cart.py?book_id=2']"));
        addButton.click();
        WebElement shoppingCart = driver.findElement(By.cssSelector("a[href='./shopping_cart.py']"));
        shoppingCart.click();
        WebElement quantity = driver.findElement(By.cssSelector("input[value = '1']"));
        quantity.sendKeys("0");
        WebElement updateButton = driver.findElement(By.cssSelector("input[value = 'Update']"));
        updateButton.click();
        WebElement confirmationMessage = driver.findElement(By.className("confirmation_message"));
        Assert.assertTrue(confirmationMessage.isDisplayed(), "Cart Updated");
    }

    @Test
    public void proceedToPageCheckoutTest (){
        driver.get("https://www.sharelane.com/");
        WebElement enterButton = driver.findElement(By.cssSelector("a[href='../cgi-bin/main.py']"));
        enterButton.click();
        WebElement TestPortal = driver.findElement(By.cssSelector("a[href='../test_portal.html']"));
        TestPortal.click();
        WebElement AccountCreator = driver.findElement(By.cssSelector("a[href='../cgi-bin/create_account.py']"));
        AccountCreator.click();
        WebElement buttonCreate = driver.findElement(By.cssSelector("input[value = 'Create new user account']"));
        buttonCreate.click();
        WebElement buttonAutoLogin = driver.findElement(By.cssSelector("input[value = 'Auto Login']"));
        buttonAutoLogin.click();
        WebElement searchInput = driver.findElement(By.name("keyword"));
        searchInput.sendKeys("White Fang");
        WebElement searchButton = driver.findElement(By.cssSelector("input[value = 'Search']"));
        searchButton.click();
        WebElement addButton = driver.findElement(By.cssSelector("a[href='./add_to_cart.py?book_id=2']"));
        addButton.click();
        WebElement shoppingCart = driver.findElement(By.cssSelector("a[href='./shopping_cart.py']"));
        shoppingCart.click();
        WebElement proceedToCheckoutButton = driver.findElement(By.cssSelector("input[value = 'Proceed to Checkout']"));
        proceedToCheckoutButton.click();
        WebElement makePaymentButton = driver.findElement(By.cssSelector("input[value = 'Make Payment']"));
        Assert.assertTrue(makePaymentButton.isDisplayed(), "Checkout page should be display");

    }
}
