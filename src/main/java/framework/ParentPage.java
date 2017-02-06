package framework;

import org.openqa.selenium.WebDriver;


public class ParentPage extends DSL {

    public ParentPage(WebDriver driver) {
        super(driver);
    }

    protected boolean compareObjects(Object expected, Object actueal){
        return expected.equals(actueal);
    }

    protected boolean actualPage(String title){
        return getPageTitle().equals(title);
    }

    protected void sleepFor(int sec){
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
