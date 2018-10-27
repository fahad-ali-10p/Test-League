package POM

import org.junit.Assert
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

import java.util.concurrent.TimeUnit

/**
 * Created by fahad.ali on 24/10/2018.
 */
class LoginForm {


    WebDriver driver
    static Properties prop

    public LoginForm(WebDriver driver,def prop) {
        this.driver = driver
        this.prop = prop
    }

    void gotoURL() {
       driver.get(prop.get('URL'))
    }

    void Login(String UserName, String Password){
        driver.findElement(By.id('inputUsername')).sendKeys(prop.get('UserName'))
        driver.findElement(By.id('inputPassword')).sendKeys(prop.get('Password'))
    }

    void clickLogin() {
        driver.findElement(By.id('login-button')).click()
    }

    void loginAssertion(){

        TimeUnit.SECONDS.sleep(2)
        String userName = driver.findElement(By.cssSelector(".hidden-xs.ng-binding")).getText()
        Assert.assertTrue(userName.contains("ctfehragbyuidjk gcjibhtyuderfak"))
    }
}