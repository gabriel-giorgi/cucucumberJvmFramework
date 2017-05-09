package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.DriverFactory;

/**
 * Created by ggiorgi on 5/9/2017.
 */
public class RegistrationPage extends BasePage{

    By FirstNameFieldLocator = By.id("name_3_firstname");
    By LastNameFieldLocator = By.xpath("//*[@id='name_3_lastname']");
    By DropdownLocatorCountry = By.id("dropdown_7");
    By DropdownLocatorMonth = By.id("mm_date_8");
    By DropdownLocatorDay = By.id("dd_date_8");
    By DropdownLocatorYear = By.id("yy_date_8");
    By PhoneNumberLocator = By.id("phone_9");
    By UserNameLocator = By.id("username");
    By EmailNameLocator = By.id("email_1");
    By UploadButtonLocator = By.id("profile_pic_10");
    By DescripcionLocator = By.id("description");
    By passwordLocator = By.id("password_2");
    By passwordConfirmLocator = By.id("confirm_password_password_2");
    By submitLocator = By.name("pie_submit");
    By dragAndDropLocator = By.id("draggable");
    By  messageLocator = By.xpath("//*[@id=\"post-49\"]/div/p");
    String hobbyXpath="//input[@type='checkbox'and @value='specifichobby' ]";


    public RegistrationPage(WebDriver driver){
        super(driver);
    }

    public void fillFirstNameField(String name){
        logger.info("--- Completing the First Name Field with "+ name + " ---");
        wait.until(ExpectedConditions.presenceOfElementLocated(FirstNameFieldLocator));
        driver.findElement(FirstNameFieldLocator).sendKeys(name);
    }

    public void fillLastNameField(String lastName) {
        logger.info("--- Completing the First Name Field with "+ lastName + " ---");
        driver.findElement(LastNameFieldLocator).sendKeys(lastName);
    }

    public void selectHobby(String hooby){
        logger.info("--- Selectin the Hobby: "+ hooby + " ---");
        driver.findElement(By.xpath(hobbyXpath.replace("specifichobby",hooby))).click();
    }

    public void fillPhoneNumber(String phoneNumber){
        logger.info("--- Completing the phone number with: "+ phoneNumber + " ---");
        driver.findElement(PhoneNumberLocator).sendKeys(phoneNumber);
    }

    public void fillUsernameField(String username){
        logger.info("--- Completing the username field with: "+ username + " ---");
        driver.findElement(UserNameLocator).sendKeys(username);
    }

    public void fillEmailField(String email){
        logger.info("--- Completing the email field with: "+ email + " ---");
        driver.findElement(EmailNameLocator).sendKeys(email);
    }

    public void fillPasswordField(String password){
        logger.info("--- Completing the password field with: "+ password + " ---");
        driver.findElement(passwordLocator).sendKeys(password);
    }

    public void fillconfirmPasswordField(String confirmPassword){
        logger.info("--- Completing the confirm password field with: "+ confirmPassword + " ---");
        driver.findElement(passwordConfirmLocator).sendKeys(confirmPassword);
    }

    public void submitForm(){
        logger.info("Submiting the registration form");
        driver.findElement(submitLocator).click();
    }

    public void verifySuccesfulRegistration(){
        WebDriverWait wait = new WebDriverWait(driver,15);
        Assert.assertTrue(wait.until(ExpectedConditions.presenceOfElementLocated(messageLocator)).isDisplayed());
        WebElement popUp = driver.findElement(new By.ByXPath("//*[contains(text(),'Thank you for your registration')]"));
        System.out.println(popUp.getText());
        driver.quit();
    }

    public void verifyMandatoryFields(){
        WebDriverWait wait = new WebDriverWait(driver,15);
        WebElement popUp = driver.findElement(new By.ByXPath("//span[@class='legend error']"));
        Assert.assertTrue(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='legend error']"))).isDisplayed());
        System.out.println(popUp.getText());
        driver.quit();
    }

    public void verifyExistentUser(){
        WebDriverWait wait = new WebDriverWait(driver,15);
        Assert.assertTrue(wait.until(ExpectedConditions.presenceOfElementLocated(messageLocator)).isDisplayed());
        WebElement popUp = driver.findElement(new By.ByXPath("//*[contains(text(),'Username already exists')]"));
        System.out.println(popUp.getText());
        driver.quit();
    }

    public void verifyExistentEmail(){
        WebDriverWait wait = new WebDriverWait(driver,15);
        Assert.assertTrue(wait.until(ExpectedConditions.presenceOfElementLocated(messageLocator)).isDisplayed());
        WebElement popUp = driver.findElement(new By.ByXPath("//*[contains(text(),'E-mail address already exists')]"));
        driver.quit();
    }
}

