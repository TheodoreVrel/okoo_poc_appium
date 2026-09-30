package steps;

import driver.DriverFactory;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.Login;
import pages.ProgramPage;

public class ProgramPageSteps extends PageSteps {
    ProgramPage programPage = new ProgramPage();
    LoginSteps login = new LoginSteps();

    @Given("I am on a program's page")
    public void iAmOnAProgramSPage() {
        programPage.dismissFavOnboarding();
        programPage.clickOnFirstVisibleProgram();
        programPage.dismissInteractionOnboarding();
    }

    @When("I click on a video")
    public void iClickOnAVideo() {
        programPage.clickOnVideo();
    }

    @Then("the player opens and the video starts")
    public void thePlayerOpensAndTheVideoStarts() {
        Assert.assertTrue(programPage.videoOpensAssertion());
    }

    @When("I click \"Regarder un épisode\"")
    public void iClick() {
        programPage.clickStartVideo();
    }

    @Given("I am on the downloads tab and there is at least one downloaded video")
    public void iAmOnTheDownloadsTabAndThereIsAtLeastOneDownloadedVideo() {
    }

    @Given("I am on a program with interaction")
    public void iAmOnAProgramWithInteraction() {
    }

    @When("I click on the interaction button")
    public void iClickOnTheInteractionButton() {
    }

    @And("I click off")
    public void iClickOff() {
    }

}
