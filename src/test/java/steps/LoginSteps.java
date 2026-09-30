package steps;

import driver.DriverFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.TestRunner;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.Login;

import java.time.Duration;

public class LoginSteps extends PageSteps {
//    private AndroidDriver driver = DriverFactory.driver;

    Login login = new Login();



    @Given("initial setup")
    public void iOpenTheOkooApp() throws InterruptedException {
        login.openApp();
    }

    @When("I confirm I am an adult")
    public void iConfirmIMAnAdult(){
        login.clickNext();
    }

    @And("I enter the correct result to the multiplication")
    public void iEnterTheCorrectResultToTheMultiplication() {
        login.enterMultiplicationResult();
    }

    @And("I agree to the questions")
    public void iAgreeToTheQuestions() {
        login.clickYes();
        login.clickAgree();
    }

    @And("I select the age of {int} years old")
    public void iSelectTheAgeOfYearsOld(int age) {
        login.selectAgeFromSlider(age);
        login.clickOk();
    }

//    @Then("I should be on the main page")
//    public void iShouldBeOnTheMainPage() {
//    }

    @Then("I should be on the main page for {int} year olds")
    public void iShouldBeOnTheMainPageForYearOlds(int age) throws InterruptedException {
        Assert.assertEquals(login.getSelectedAge(), age);
        Thread.sleep(2000);
    }

    @AfterTest
    public void teardown() throws InterruptedException {
        DriverFactory.driver.quit();
    }


    @Then("I should be on the age selection page")
    public void iShouldBeOnTheAgeSelectionPage() {
        Assert.assertTrue(login.ageSliderDisplayed());
    }


    @Given("I am on the age selection page")
    public void iAmOnTheAgeSelectionPage() {
        /*if (!login.isAgeDisplayed())
        {
            login.openApp();
        }
        else
        {
            login.clickAgeButton();
        }*/
    }
}
