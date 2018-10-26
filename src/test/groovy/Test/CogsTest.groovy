package Test

import POM.Dashboard
import POM.LoginForm
import org.openqa.selenium.chrome.ChromeDriver
import spock.lang.Specification
/**
 * Created by fahad.ali on 24/10/2018.
 */
class CogsTest extends Specification {


    static ChromeDriver driver
    //static LoginForm login
    static Properties prop = null
    static LoginForm LoginPage
    static Dashboard Dashboardpage
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




}

    def "Login with valid username and Password"(){

        when:
        LoginPage.gotoURL();
        LoginPage.Login(prop.get('username'),prop.get('Password'))
        LoginPage.clickLogin()


        then:
        true

    }


    def "Open header navigation"(){

        when:
        Thread.sleep(9000)
        Dashboardpage.openProfile()
        then:
        true

    }

}