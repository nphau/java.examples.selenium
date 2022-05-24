/**
 * Created by nphau on 04/05/2022, 10:30
 * Copyright (c) 2021 nphau. All rights reserved.
 * Last modified 04/05/2022, 15:54
 */

package sg.nphau.java.selenium;

import org.testng.annotations.Test;
import org.junit.jupiter.api.Disabled;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import sg.nphau.java.selenium.wdm.DriverType;
import sg.nphau.java.selenium.wdm.WebDriverManager;

public class InstallDriversTest {

    @Test(priority = 2)
    public void chromeSession() {
        WebDriver driver = WebDriverManager.get(DriverType.CHROME);
        driver.quit();
    }

    @Test(priority = 3)
    public void edgeSession() {
        WebDriver driver = WebDriverManager.get(DriverType.EDGE);
        driver.quit();
    }

    @Test(priority = 1)
    public void firefoxSession() {
        WebDriver driver = WebDriverManager.get(DriverType.FIRE_FOX);
        driver.quit();
    }

    @Test
    @Disabled("Only runs on Windows")
    public void ieSession() {
        WebDriver driver = new InternetExplorerDriver();
        driver.quit();
    }
}
