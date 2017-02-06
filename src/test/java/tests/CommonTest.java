package tests;

import framework.ParentTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CommonTest extends ParentTest {

    private String baseUrl = "http://www.google.com";

    @BeforeTest
    public void openBrovser(){
        startDriver();
        navigateTo(baseUrl);
    }

    @Test
    public void commonTest(){
    }

    @AfterTest(alwaysRun = true)
    public void closeBrowser(){
        closeDriver();
    }
}
