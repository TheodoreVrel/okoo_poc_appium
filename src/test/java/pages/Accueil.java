package pages;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Accueil extends Page{

    private final By MEAListBy = By.id("fr.francetv.zouzous.inhouse:id/nextButton");
    WebElement MEAList = DriverFactory.driver.findElement(MEAListBy);
    private String ep = MEAList.getAttribute("content-desc");
    public List<WebElement> programsWithFallbackImage;
    //Check en mettant en préprod d'abord


    public void findElementsWithNoImages(){
         programsWithFallbackImage = DriverFactory.driver.findElements(By.xpath("//*[not(@text='')]"));

    }



}
