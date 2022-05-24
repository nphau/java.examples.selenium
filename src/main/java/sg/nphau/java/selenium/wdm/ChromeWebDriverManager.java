/**
 * Created by nphau on 04/05/2022, 10:30
 * Copyright (c) 2021 nphau. All rights reserved.
 * Last modified 04/05/2022, 15:54
 */

package sg.nphau.java.selenium.wdm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class ChromeWebDriverManager extends WebDriverManager {

    @Override
    protected DriverType getDriverType() {
        return DriverType.CHROME;
    }

    @Override
    public WebDriver setUp(String driverPath) {
        if (driverPath != null)
            System.setProperty("webdriver.chrome.driver", driverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-extensions");
        options.addArguments("disable-infobars");
        WebDriver driver = new ChromeDriver(options);
        setUp(driver);
        return driver;
    }
}