import Pages.DashboardPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginPageTests extends BaseTest {



    @Test
    public void testSuccessLogin(){
        // Add username
        loginPage.addUserName("Admin");
        // add Password
        loginPage.addPassword("admin123");
        // Click login
        DashboardPage dashboardPage= loginPage.clickLoginButton();
        //assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
        assertTrue(dashboardPage.checkDashboardIcon());
    }

    @Test
    public void testInvalidUsername(){
        loginPage.addUserName("as");
        loginPage.addPassword("admin123");
        loginPage.clickLoginButton();
        assertTrue(loginPage.isInvalidErrorMessageVisible());
    }

    @Test
    public void testInvalidPassword(){
        loginPage.addUserName("Admin");
        loginPage.addPassword("admin");
        loginPage.clickLoginButton();
        assertTrue(loginPage.isInvalidErrorMessageVisible());
    }

    @Test
    public void testEmptyPassword(){
        loginPage.addUserName("Admin");
        loginPage.addPassword("");
        loginPage.clickLoginButton();
        assertTrue(loginPage.isRequiredErrorMessageVisible());
    }

    @Test
    public void testEmptyUsername(){
        loginPage.addUserName("");
        loginPage.addPassword("admin123");
        loginPage.clickLoginButton();
        assertTrue(loginPage.isRequiredErrorMessageVisible());
    }

    @Test
    public void testEmptyUsernameAndPassword(){
        loginPage.addUserName("");
        loginPage.addPassword("");
        loginPage.clickLoginButton();
        assertTrue(loginPage.isDuplicateRequiredMessageVisible());
    }
}
