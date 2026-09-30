package pages;

import driver.DriverFactory;
import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public abstract class Page {

    protected final By bottomBarBy = By.id("fr.francetv.zouzous.inhouse:id/kidsBottomBar");
    protected final By okooLogoBy = By.id("fr.francetv.zouzous.inhouse:id/toolbarLogoImageView");
    protected final By ageButtonBy = By.id("fr.francetv.zouzous.inhouse:id/ageButton");

    public final String appActivity = "fr.francetv.kids.main.MainActivity";
    private final String appPackage = "fr.francetv.zouzous.inhouse";

    public int getAgeSliderValue(int age){
        HashMap<Integer, Integer> ageSliderKeys = new HashMap<Integer, Integer>();
        ageSliderKeys.put( 3, 370);
        ageSliderKeys.put( 4, 295);
        ageSliderKeys.put( 5, 240);
        ageSliderKeys.put( 6, 140);
        ageSliderKeys.put( 7, 40);
        ageSliderKeys.put( 8, -70);
        ageSliderKeys.put( 9, -120);
        ageSliderKeys.put(10, -215);
        ageSliderKeys.put(11, -290);
        ageSliderKeys.put(12, -370);

        return ageSliderKeys.get(age);
    }

    protected void waitForVisibility(WebDriver driver, WebElement element) {
        new WebDriverWait(DriverFactory.driver, Duration.ofSeconds(60)).until(elementToBeClickable(element));
    }

    protected void slide(WebElement element, int toX, int toY){
        Actions action = new Actions(DriverFactory.driver);
        action.dragAndDropBy(element, toX, toY).build().perform();
    }

    protected void write(WebElement element, String text){
        element.sendKeys(text);
    }

    public boolean isBottomBarVisible(){
        return DriverFactory.driver.findElement(bottomBarBy).isDisplayed();
    }

    public void clickAgeButton(){
        WebElement ageButton = DriverFactory.driver.findElement(ageButtonBy);
        ageButton.click();
    }

    public boolean isAppOpened(){
        try
        {
            return DriverFactory.driver.findElement(bottomBarBy).isDisplayed();
        }
        catch (NullPointerException e)
        {
            try
            {
                return DriverFactory.driver.findElement(okooLogoBy).isDisplayed();
            }
            catch (NullPointerException f)
            {
                return false;
            }
        }
    }

    public void openApp(){
        DriverFactory.driver.terminateApp(appPackage);
        DriverFactory.driver.activateApp(appPackage);
    }
}
