
package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class Login {
    private final By userNameTextboxLocator = By.id("UserName");
    private final By passwordTextboxLocator = By.id("Password");
    private final By loginButtonLocator = By.xpath("//*[@id='loginForm']/form/div[3]/input[1]");
    WebElement usernameTextbox;
    WebElement passwordTextbox;
    WebElement loginButton;

    public void LoginActions(WebDriver driver, String username, String password) {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        //Launch turnUp Portal and navigate to login page
        String baseURL = "http://horse.industryconnect.io/Account/Login";
        driver.navigate().to(baseURL);

        //Identify username textbox and enter valid username
        WebElement usernameTextbox = driver.findElement(By.id("UserName"));
        usernameTextbox.sendKeys("hari");

        //Identify password textbox and enter valid password
        WebElement passwordTextbox = driver.findElement(By.id("Password"));
        passwordTextbox.sendKeys("123123");

        //Identify login button and click on the button
        WebElement loginButton = driver.findElement(By.xpath("//*[@id='loginForm']/form/div[3]/input[1]"));
        loginButton.click();
    }

}
