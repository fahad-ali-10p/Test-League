package POM

import org.junit.Assert
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.Select

import java.util.concurrent.TimeUnit

/**
 * Created by fahad.ali on 27/10/2018.
 */
class Reports {

    WebDriver driver
    static Properties prop

    public Reports(WebDriver driver,def prop) {
        this.driver = driver
        this.prop = prop
    }

    void openLeavesReports() {
        TimeUnit.SECONDS.sleep(2)
        driver.findElement(By.linkText("Leaves Report")).click()
    }


    void SearchEmployeeName(String EmployeeName) {

        TimeUnit.SECONDS.sleep(4)
        driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/ui-view/ui-view/div/div/div/div/div[3]/div/p/input")).sendKeys(EmployeeName)


    }


    void openProjectpulseReports() {

        TimeUnit.SECONDS.sleep(3)
        driver.findElement(By.linkText("Project Pulse Report")).click()
    }

    void openDropdownReport() {

        TimeUnit.SECONDS.sleep(3)
        new Select (driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/ui-view/ui-view/div/div/div/div/div[1]/div/div[1]/div[2]/select"))).selectByVisibleText("Mon 24 Sep 2018 - Sun 30 Sep 2018")

    }


        void downloadreport(){


            TimeUnit.SECONDS.sleep(1)
            driver.findElement(By.cssSelector(".btn.btn-primary.ng-scope")).click()
        }

    void projectCostingreport(){


        TimeUnit.SECONDS.sleep(1)
        driver.findElement(By.linkText("Project Costing Report")).click()
    }



}
