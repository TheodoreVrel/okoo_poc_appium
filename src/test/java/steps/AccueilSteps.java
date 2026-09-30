package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.Accueil;
import pages.Login;

public class AccueilSteps {
    Login login = new Login();
    Accueil accueil = new Accueil();

    @Given("I open the Okoo app")
    public void iOpenTheOkooApp()
    {
        login.openApp();
    }

    @When("I search the main page")
    public void iSearchTheMainPage()
    {
        login.openApp();
    }

    @Then("there shouldn't be any programs without images")
    public void noProgramWithoutImages()
    {
        accueil.findElementsWithNoImages();
        Assert.assertTrue(accueil.programsWithFallbackImage.isEmpty());
    }

}
