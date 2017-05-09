package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;
import utils.LogHandler;

/**
 * Created by ggiorgi on 5/9/2017.
 */
public class BasePage {
    protected Logger logger;
    protected WebDriverWait wait;
    protected WebDriver driver;
    protected Actions action;

    public BasePage(){
        logger = LogHandler.initLogging();
    }

    public BasePage(WebDriver driver){

        this.driver= driver;
        this.action= new Actions(driver);
        this.wait= new WebDriverWait(driver, 15);
        logger = LogHandler.initLogging();
    }

    public void navigateTo(WebDriver driver,String url){
        driver.get(url);
    }

}
