package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LoginPage {


    private WebDriver driver;
    private WebDriverWait wait;
    // Webelment

    private By userNameFiled = By.cssSelector("input[name='username']");
    private By passwordField = By.cssSelector("input[type='password']");
    private By loginButton = By.cssSelector(".oxd-button.orangehrm-login-button");
    private By invalidErrorMessage = By.xpath("//p[contains(.,'credentials')]");
    private By requiredErrorMessage = By.tagName("span");


    public LoginPage (WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    // Methods
    public void addUserName(String username){
        wait.until(ExpectedConditions.visibilityOfElementLocated(userNameFiled));
        driver.findElement(userNameFiled).sendKeys(username);
    }

    public void addPassword (String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public DashboardPage clickLoginButton (){
        driver.findElement(loginButton).click();
        return new DashboardPage(driver);
    }

    public boolean isInvalidErrorMessageVisible (){
         wait.until(ExpectedConditions.visibilityOfElementLocated(invalidErrorMessage));
        return driver.findElement(invalidErrorMessage).isDisplayed();
    }

    public boolean isRequiredErrorMessageVisible(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(requiredErrorMessage));
        return driver.findElement(requiredErrorMessage).isDisplayed();
    }

    public boolean isDuplicateRequiredMessageVisible(){
        List<WebElement> requiredErrorList =  driver.findElements(requiredErrorMessage);
        for (WebElement webElement : requiredErrorList) {
            if (!webElement.isDisplayed()) {
                return false;
            }
        }
        return true;
    }



}
