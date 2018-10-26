package POM

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

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
        Thread.sleep(6000)
        driver.findElement(By.className("profileImg")).click();
        driver.findElement(By.className("profileImg")).click();
        driver.findElement(By.id('viewPro-icon')).click()
    }
}
