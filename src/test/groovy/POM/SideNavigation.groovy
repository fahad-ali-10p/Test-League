package POM

import org.junit.Assert
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

import java.util.concurrent.TimeUnit

/**
 * Created by fahad.ali on 27/10/2018.
 */
class SideNavigation {

    WebDriver driver
    static Properties prop

    public SideNavigation(WebDriver driver,def prop) {
        this.driver = driver
        this.prop = prop
    }

    void openReports() {
        driver.findElement(By.linkText("Reports")).click()
    }

    void Reporttextassertion(){

        TimeUnit.SECONDS.sleep(4)
        String userName = driver.findElement(By.cssSelector(".hidden-xs.ng-binding")).getText()
        Assert.assertTrue(userName.contains("ctfehragbyuidjk gcjibhtyuderfak"))
    }

}
