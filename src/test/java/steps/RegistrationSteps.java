package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.RegistrationPage;
import utils.DriverFactory;
import utils.LogHandler;

/**
 * Created by ggiorgi on 5/9/2017.
 */
public class RegistrationSteps extends BaseSteps {

    WebDriver driver;
    RegistrationPage registrationPage;

    @Before
    public void beforeScenario(){
        logger = LogHandler.initLogging();
        logger.info("--- Initializing the browser ---");
        driver = new DriverFactory().startbrowser();
        registrationPage = new RegistrationPage(driver);
        registrationPage.navigateTo(driver,"http://demoqa.com/");

    }

    @After
    public void afterScenario(){
        logger.info("--- Closing the browser ---");
        driver.quit();
    }

    @Given("^I am new to the website I want to create an account$")
    public void i_am_new_to_the_website_I_want_to_create_an_account() {

    }

    @When("^I go to the registration form$")
    public void i_go_to_the_registration_form() {
        logger.info("Going to the registration page");
        driver.get("http://demoqa.com/registration/");
    }

    @When("^I complete all the required registration details correctly :  First Name with \"([^\"]*)\"$")
    public void i_complete_all_the_required_registration_details_correctly_First_Name_with(String firstName){
       registrationPage.fillFirstNameField(firstName);
    }

    @When("^I fill Last Name with\"([^\"]*)\"$")
    public void i_fill_Last_Name_with(String lastName){
        registrationPage.fillLastNameField(lastName);
    }

    @When("^I select the hobby \"([^\"]*)\"$")
    public void i_select_the_hobby(String hobby) {
        registrationPage.selectHobby(hobby);
    }

    @When("^I fill the phoneNumber with\"([^\"]*)\"$")
    public void i_fill_the_phoneNumber_with(String phone_Number) {
        registrationPage.fillPhoneNumber(phone_Number);
    }

    @When("^I fill the username with \"([^\"]*)\"$")
    public void i_fill_the_username_with(String user){
        registrationPage.fillUsernameField(user);
    }

    @When("^I fill the e-mail with \"([^\"]*)\"$")
    public void i_fill_the_e_mail_with(String email)  {
        registrationPage.fillEmailField(email);
    }

    @When("^I fill the password with \"([^\"]*)\"$")
    public void i_fill_the_password_with(String password)   {
        registrationPage.fillPasswordField(password);
    }
    @When("^I fill the password confirmation with \"([^\"]*)\"$")
    public void i_fill_the_password_confirmation_with(String confirmPassword) throws Throwable {
        registrationPage.fillconfirmPasswordField(confirmPassword);
    }

    @When("^I submit the form$")
    public void i_submit_the_form() throws Throwable {
        registrationPage.submitForm();
    }

    @Then("^I will be registered on the website$")
    public void i_will_be_registered_on_the_website() throws Throwable {
       registrationPage.verifySuccesfulRegistration();
    }

    @Then("^I will be asked to fill all the mandatory fields correctly$")
    public void i_will_be_asked_to_fill_all_the_mandatory_fields_correctly() throws Throwable {
        registrationPage.verifyMandatoryFields();
    }

    @Then("^It should be shown a message saying that the User already exist$")
    public void it_should_be_shown_a_message_saying_that_the_User_already_exist() throws Throwable {
       registrationPage.verifyExistentUser();
    }

    @Then("^It should be shown a message saying that the E-mail already exist$")
    public void it_should_be_shown_a_message_saying_that_the_E_mail_already_exist() throws Throwable {
        registrationPage.verifyExistentEmail();
    }
}
