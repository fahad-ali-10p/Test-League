package Test

import POM.Dashboard
import POM.LoginForm
import POM.Reports
import POM.SideNavigation
import org.junit.Assert
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.chrome.ChromeDriver
import spock.lang.Specification

import java.util.concurrent.TimeUnit

/**
 * Created by fahad.ali on 24/10/2018.
 */
class CogsTest extends Specification {


    static ChromeDriver driver
    //static LoginForm login
    static Properties prop = null
    static LoginForm LoginPage
    static Dashboard Dashboardpage
    static SideNavigation Sidenavigationbar
    static Reports Reportsmanagement
    //static LoginForm GoToURL

    static  {
        prop = new Properties()
        File Myconf = new File('src//test//groovy//Config//config.properties')
        //File Myconf = new File('D://D//TP-work//constellix//automation//testingLeague//src//test//groovy//Config//config.properties')
        Myconf.withInputStream {
            prop.load(it)

        }
        System.setProperty('webdriver.chrome.driver',prop.get('Chrome'))
        driver = new ChromeDriver()
        driver.manage().window().maximize()

        LoginPage = new LoginForm(driver,prop)
        Dashboardpage = new Dashboard(driver,prop)
        Sidenavigationbar = new SideNavigation(driver,prop)
        Reportsmanagement = new Reports(driver,prop)

        JavascriptExecutor jse = (JavascriptExecutor)driver;

}

    def "Login with valid username and Password"(){

        when:
        LoginPage.gotoURL();
        LoginPage.Login(prop.get('username'),prop.get('Password'))
        LoginPage.clickLogin()


        then:

        LoginPage.loginAssertion()

    }


    def "Open profile from the header navigation"(){

        when:
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS)
        Dashboardpage.openProfile()

        then:
        Dashboardpage.DashboardAssertion()

    }


    def "Open reports from the side navigation"(){

        when:
        Sidenavigationbar.openReports()
        then:
        Dashboardpage.DashboardAssertion()

    }

    def "ReportManagement- Leave Report"(){

        when:
        Reportsmanagement.openLeavesReports()
        Reportsmanagement.SearchEmployeeName('tbuhfdacgreyijk jibdyceaghrtfuk')

        then:
        Dashboardpage.DashboardAssertion()
    }


    def "ReportManagement- Project Pulse report"(){

        when:
        Sidenavigationbar.openReports()
        Reportsmanagement.openProjectpulseReports()
        Reportsmanagement.openDropdownReport()

        then:
        Dashboardpage.DashboardAssertion()
    }

    def "ReportManagement- Download Pulse report"(){

        when:
        TimeUnit.SECONDS.sleep(1)
        Reportsmanagement.downloadreport()

        then:
        true
    }

    def "Project Costing report"(){

        when:

        Sidenavigationbar.openReports()
        Reportsmanagement.projectCostingreport()

        then:
        true

    }
}