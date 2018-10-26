package POM

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

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

}