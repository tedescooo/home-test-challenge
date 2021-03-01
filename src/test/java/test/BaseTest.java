package test;

import common.BalanceEntry;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import page.BalancePage;
import page.ExpensePage;
import page.IncomePage;
import page.MainPage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public abstract class BaseTest {

    private static AppiumDriver<MobileElement> driver;

    MainPage mainPage;
    ExpensePage expensePage;
    IncomePage incomePage;
    BalancePage balancePage;

    @Before
    public void setUpTest() throws MalformedURLException {
        File app = new File("com.monefy.app.lite.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.APPIUM);
        driver = new AppiumDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

        mainPage = new MainPage(driver);
        PageFactory.initElements(driver, mainPage);

        expensePage = new ExpensePage(driver);
        PageFactory.initElements(driver, expensePage);

        incomePage = new IncomePage(driver);
        PageFactory.initElements(driver, incomePage);

        balancePage = new BalancePage(driver);
        PageFactory.initElements(driver, balancePage);
    }

    @After
    public void cleanUp() {
        driver.quit();
    }

    boolean isBalanceEntryPresent(List<BalanceEntry> balanceEntries, BalanceEntry expectedEntry) {
        return balanceEntries.stream().anyMatch(balance -> balance.equals(expectedEntry));
    }

    // Utils
    String getCurrentDateString() {
        return new SimpleDateFormat("d MMM").format(new Date());
    }
}
