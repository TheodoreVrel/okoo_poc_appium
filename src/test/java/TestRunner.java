import driver.DriverFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"steps"},
        tags = "@AUTO-0003",
        plugin = {
                //"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "pretty"
        }
)

public class TestRunner extends AbstractTestNGCucumberTests {

    private final String deviceName = "pixel_2";
    private final String appPackage = "fr.francetv.zouzous.inhouse";
    private final String appActivity = "fr.francetv.kids.main.MainActivity";
    private final String androidDriverURL = "http://127.0.0.1:4723/wd/hub";
    private final int implicitWaitTime = 120;
    private enum Platform {
        ANDROID,
        IOS
    }
    private DesiredCapabilities desiredCapabilities;
    //public AndroidDriver driver = DriverFactory.driver;


    @BeforeSuite
    public void setUp() throws MalformedURLException {
        setUpCapabilities(deviceName, Platform.ANDROID);
        driverSetUp(desiredCapabilities);
        DriverFactory.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitTime));

    }
    @AfterSuite
    public void teardown() {
        DriverFactory.driver.quit();
    }


    public void setUpCapabilities(String deviceName) {
        setUpCapabilities(deviceName, Platform.ANDROID);
    }
    public void setUpCapabilities(String deviceName, Platform platform ) {
        String platformName = "android";
        switch (platform)
        {
            case IOS:
                platformName = "ios";
                break;
            case ANDROID:
                platformName = "android";
                break;
        }

        desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        desiredCapabilities.setCapability(CapabilityType.PLATFORM_NAME, platformName);
        desiredCapabilities.setCapability("appPackage", appPackage);
        desiredCapabilities.setCapability("appActivity", appActivity);

    }

    public void driverSetUp(DesiredCapabilities dc) throws MalformedURLException {
        driverSetUp(androidDriverURL, dc);
    }
    public void driverSetUp(String url, DesiredCapabilities dc) throws MalformedURLException {
        DriverFactory.driver = new AndroidDriver(new URL(url), dc);

        DriverFactory.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitTime));
    }

}
