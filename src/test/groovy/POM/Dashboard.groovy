package POM

import org.junit.Assert
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

import java.util.concurrent.TimeUnit

/**
 * Created by fahad.ali on 25/10/2018.
 */
class Dashboard {

    WebDriver driver
    static Properties prop

    public Dashboard(WebDriver driver,def prop) {
        this.driver = driver
        this.prop = prop
    }

    void openProfile() {

        TimeUnit.SECONDS.sleep(30)
        driver.findElement(By.className("profileImg")).click();
        driver.findElement(By.id('viewPro-icon')).click()
    }

    void DashboardAssertion(){

        String userName = driver.findElement(By.cssSelector(".empTitle.ng-binding")).getText()
        Assert.assertTrue(userName.contains("ctfehragbyuidjk gcjibhtyuderfak"))
    }

}
