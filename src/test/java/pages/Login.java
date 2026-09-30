package pages;

import driver.DriverFactory;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends Page{

//    AndroidDriver driver = DriverFactory.driver;

    private final By nextButtonBy = By.id("fr.francetv.zouzous.inhouse:id/nextButton");
    private final By operationElementBy = By.id("fr.francetv.zouzous.inhouse:id/multiplicationTextView");
    private final By operationFieldBy = By.id("fr.francetv.zouzous.inhouse:id/resultEditText");
    private final By yesButtonBy = By.id("fr.francetv.zouzous.inhouse:id/yesButton");
    private final By agreeButtonBy = By.id("fr.francetv.zouzous.inhouse:id/button_agree");
    private final By ageSliderBy = By.id("fr.francetv.zouzous.inhouse:id/seekBar");
    private final By okButtonBy = By.id("fr.francetv.zouzous.inhouse:id/okButton");

    public void clickNext(){
        WebElement nextButton = DriverFactory.driver.findElement(nextButtonBy);
        nextButton.click();
    }
    public void clickYes(){
        WebElement yesButton = DriverFactory.driver.findElement(yesButtonBy);
        yesButton.click();
    }
    public void clickAgree(){
        WebElement agreeButton = DriverFactory.driver.findElement(agreeButtonBy);
        agreeButton.click();
    }
    public void clickOk(){
        WebElement okButton = DriverFactory.driver.findElement(okButtonBy);
        okButton.click();
    }


    public void selectAgeFromSlider(int age){

        WebElement ageSlider = DriverFactory.driver.findElement(ageSliderBy);
        //System.out.println(getAgeSliderValue(age));
        slide(ageSlider, 0, getAgeSliderValue(age));
    }

    public boolean ageSliderDisplayed(){
        return DriverFactory.driver.findElement(ageSliderBy).isDisplayed();
    }

    public int multiplicationResult(){
        WebElement operationElement = DriverFactory.driver.findElement(operationElementBy);
        String operationString = operationElement.getText();
        int operatorIndex =  operationString.indexOf("x");
        int equalIndex = operationString.indexOf("=");
        int firstNum = Integer.parseInt(operationString.substring(0, operatorIndex).trim());
        int secondNum = Integer.parseInt(operationString.substring(operatorIndex + 1, equalIndex - 1).trim());
        //    System.out.println(result);
        return firstNum * secondNum;
    }

    public void enterMultiplicationResult(){
        WebElement operationField = DriverFactory.driver.findElement(operationFieldBy);
        write(operationField, Integer.toString(multiplicationResult()));
    }


    public int getSelectedAge()
    {
        WebElement currentSelectedAge = DriverFactory.driver.findElement(ageButtonBy);
        String age = currentSelectedAge.getAttribute("content-desc");
        age = age.substring(age.indexOf(" ans" ) - 2).substring(0, 2).trim();
        //System.out.println(age);
        return Integer.parseInt(age);
    }

    public boolean isAgeDisplayed(){
        try {return DriverFactory.driver.findElement(ageButtonBy).isDisplayed();}
        catch (NullPointerException e){return false;}
    }

    public void openApp()
    {
        clickNext();
        enterMultiplicationResult();
        clickYes();
        clickAgree();
        selectAgeFromSlider(7);
        clickOk();
    }


}
