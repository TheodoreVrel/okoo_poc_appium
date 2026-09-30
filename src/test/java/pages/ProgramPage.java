package pages;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProgramPage extends Page{

//    AndroidDriver driver = DriverFactory.driver;

    private final By startAVideoButtonBy = By.id("fr.francetv.zouzous.inhouse:id/primaryButton");
    private final By titleBy = By.id("fr.francetv.zouzous.inhouse:id/title");
    private final By playerBy = By.id("fr.francetv.zouzous.inhouse:id/ftv_player_surface");
    private final By firstProgramBy = By.xpath("//android.widget.ImageView[2]");
    private final By favOnboardingBy = By.id("fr.francetv.zouzous.inhouse:id/sliderItems");
    private final By interactionOnboardingBy = By.id("fr.francetv.zouzous.inhouse:id/title");
    //public void clickFirstProgram(){}

    public void clickStartVideo(){
        WebElement startAVideoButton = DriverFactory.driver.findElement(startAVideoButtonBy);
        startAVideoButton.click();
    }
    public void clickOnVideo(){
        WebElement videoTitle = DriverFactory.driver.findElement(titleBy);
        //videoTitle.click();
    }

    public void dismissFavOnboarding(){
        WebElement favOnboarding = DriverFactory.driver.findElement(favOnboardingBy);
        favOnboarding.click();
    }
    public void dismissInteractionOnboarding(){
        WebElement interactionOnboarding = DriverFactory.driver.findElement(interactionOnboardingBy);
        interactionOnboarding.click();
    }

    public void clickOnFirstVisibleProgram(){
        WebElement firstProgram = DriverFactory.driver.findElement(firstProgramBy);
        firstProgram.click();
    }

    public boolean videoOpensAssertion()
    {
        return DriverFactory.driver.findElement(playerBy).isDisplayed();
    }


}
