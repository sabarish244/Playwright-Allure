package stepdefinitions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import pages.BasePage;
import pages.CheckoutPage;
import pages.ItemsPage;
import pages.LoginPage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import cucumber.api.java.After;
import cucumber.api.java.en.*;


public class MobileStepsDefinitions  extends BasePage{
	   private AppiumDriver<MobileElement> driver;
	LoginPage loginPage;
	ItemsPage itemsPage;
	CheckoutPage checkoutPage;
    @Given("I open mobile Chrome")
    public void openMobileChrome() throws InterruptedException, IOException {
    	
    	  DesiredCapabilities capabilites = new DesiredCapabilities();

          capabilites.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
          capabilites.setCapability(MobileCapabilityType.UDID, "emulator-5554");
          capabilites.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
//          capabilites.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
          capabilites.setCapability("chromedriverExecutable", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
          capabilites.setCapability(AndroidMobileCapabilityType.APP_PACKAGE ,"com.android.chrome");
          capabilites.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY ,"com.google.android.apps.chrome.Main");
          capabilites.setCapability("noReset", true);

          driver= new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub") ,capabilites); 
          driver.get("https://www.saucedemo.com");
          driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
          Thread.sleep(5000);
        //We use Set<String> views to get all context values.
          //And then navigate Native_APP to WEBVIEW_chrome.

          Set<String> views = driver.getContextHandles();
          for (String view :views)
          {
              System.out.println("View is :- "+view);
              if(view.contains("WEBVIEW_chrome"))
              {
                  driver.context(view);
                  break;

              }

          }
    	// Run the adb command to set the Chrome app as the debug app
//        String setDebugAppCommand = "adb -s emulator-5554 shell am set-debug-app com.android.chrome";
//        executeADBCommand(setDebugAppCommand);
//
//        // Run the adb command to start Chrome with the desired URL
//        String startChromeCommand = "adb -s emulator-5554 shell am start -n com.android.chrome/com.google.android.apps.chrome.Main -d 'http://wikipedia.org'";
//        executeADBCommand(startChromeCommand);
//
//       
//        // Initialize Appium driver with desired capabilities
//        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//     	desiredCapabilities.setCapability("platformName", "android");
//		 desiredCapabilities.setCapability("appium:automationName", "UIAutomator2");
//		 desiredCapabilities.setCapability("appium:udid", "emulator-5554");
//		 desiredCapabilities.setCapability("appium:deviceName", "emulator-5554");
//		 desiredCapabilities.setCapability("appPackage", "com.android.chrome");
//		 desiredCapabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main");
//		// Add command line arguments for incognito mode
//	        HashMap<String, String> chromeOptions = new HashMap<>();
//	        chromeOptions.put("args", "--incognito");
//	        desiredCapabilities.setCapability("goog:chromeOptions", chromeOptions);
//		 desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true); 
//		 desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
//		 desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
//		 desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);
//		 desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
	     // Set the debug app
//	        desiredCapabilities.setCapability("appWaitPackage", "com.android.chrome");
//	        desiredCapabilities.setCapability("appWaitActivity", "com.google.android.apps.chrome.Main");
//		 driver = (AndroidDriver<WebElement>) new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
//		 desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        // Initialize Appium driver with desired capabilities
//		 ChromeOptions chromeOptions = new ChromeOptions();
//	        chromeOptions.addArguments("--incognito"); // Add this argument to enable incognito mode
//	        desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
//		 ChromeOptions options = new ChromeOptions();
//		 Map<String, Object> prefs = new HashMap<String, Object>();
//		 prefs.put("profile.default_content_settings.popups", 0);
//		 options.setExperimentalOption("prefs", prefs);
//		 desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
//	        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        // Run adb command using executeScript
//        String adbCommand = "adb -s emulator-5554 shell am start -n com.android.chrome/com.google.android.apps.chrome.Main -d 'http://wikipedia.org'";
//        driver.executeScript("mobile: shell", "command", adbCommand);
    }

    
   
    @When("I navigate to {string}")
    public void navigateToURL(String url) {
        // Use Playwright to open a URL in Chrome
//    	driver.navigate().to(url);
    	driver.findElement(By.xpath("//android.widget.EditText[contains(@resource-id, 'user-name')]")).sendKeys("standard_user");
    	driver.findElement(By.xpath("//android.widget.EditText[contains(@resource-id, 'password')]")).sendKeys("secret_sauce");
    	driver.findElement(By.xpath("//android.widget.EditText[contains(@resource-id, 'login-button')]")).click();
//        Page page = Playwright.create().chromium().launch().newPage();
//        page.navigate(url);
    	loginPage = new LoginPage(page);
		itemsPage = new ItemsPage(page);
		checkoutPage = new CheckoutPage(page);
    }

    // Add more step definitions for other actions

    @After
    public void tearDown() {
        // Close the driver and Playwright instances
        driver.quit();
        Playwright.create().close();
    }
}
