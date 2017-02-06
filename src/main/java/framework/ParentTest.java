package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest extends Reporter {
    private File pathToDriver = new File("./src/main/java/resources/drivers/chromedriver");
    private static WebDriver driver;
    protected HomePage homePage;


    public void startDriver(){
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", pathToDriver.getAbsolutePath());
            driver = new ChromeDriver();

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();

            homePage = new HomePage(driver);
        }
    }

    protected void navigateTo(String url){
        driver.get(url);
    }

    protected WebDriver getDriver(){
        return driver;
    }

    protected void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }


}
