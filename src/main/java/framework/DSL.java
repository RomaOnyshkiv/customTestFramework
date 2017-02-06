package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DSL extends Reporter {
    private WebDriver driver;
    private WebElement element;

    public DSL(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement getElement(By by){
        element = driver.findElement(by);
        return element;
    }

    protected void clickOn(By by){
        driver.findElement(by).click();
    }

    protected void enterText(By by, String text){
        element = driver.findElement(by);
        element.clear();
        element.sendKeys(text);
    }

    protected String getPageTitle(){
        return driver.getTitle();
    }

    protected String getPageUrl(){
        return driver.getCurrentUrl();
    }

    protected void reloadPage(){
        driver.get(getPageUrl());
    }

    protected void fromDropDownByValue(By by, String value){
        Select select = new Select(getElement(by));
        select.selectByValue(value);
    }

    protected void fromDropDownByVisibleText(By by, String visibleText){
        Select select = new Select(getElement(by));
        select.selectByVisibleText(visibleText);
    }

    protected void deselectAllCheckBox(By by){
        Select select = new Select(getElement(by));
        select.deselectAll();
    }

    protected void deselectCheckBoxVisibleText(By by, String text){
        Select select = new Select(getElement(by));
        select.deselectByVisibleText(text);
    }

    protected void moveToElement(By by){
        Actions actions = new Actions(driver);
        actions.moveToElement(getElement(by)).build().perform();
    }


}
