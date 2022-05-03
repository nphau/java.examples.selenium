/**
 * Created by nphau on 04/05/2022, 10:30
 * Copyright (c) 2021 nphau. All rights reserved.
 * Last modified 04/05/2022, 15:54
 */

package sg.nphau.java.selenium;

import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import sg.nphau.java.selenium.wdm.WebDriverManager;

public class InstallDriversTest {

    @Test
    public void chromeSession() {
        WebDriver driver = WebDriverManager.chromeDriver().setUp(null);
        driver.quit();
    }

    @Test
    public void edgeSession() {
        WebDriver driver = WebDriverManager.edgeDriver().setUp(null);
        driver.quit();
    }

    @Test
    public void firefoxSession() {
        WebDriver driver = new FirefoxDriver();
        driver.quit();
    }

    @Test
    @Disabled("Only runs on Windows")
    public void ieSession() {
        WebDriver driver = new InternetExplorerDriver();
        driver.quit();
    }
}
