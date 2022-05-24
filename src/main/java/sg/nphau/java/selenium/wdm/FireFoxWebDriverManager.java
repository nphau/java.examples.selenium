/**
 * Created by nphau on 04/05/2022, 10:30
 * Copyright (c) 2021 nphau. All rights reserved.
 * Last modified 04/05/2022, 15:54
 */

package sg.nphau.java.selenium.wdm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import javax.annotation.Nullable;

class FireFoxWebDriverManager extends WebDriverManager {

    @Override
    protected DriverType getDriverType() {
        return DriverType.FIRE_FOX;
    }

    @Override
    public WebDriver setUp(@Nullable String driverPath) {
        if (driverPath != null)
            System.setProperty("webdriver.gecko.driver", driverPath);
        FirefoxOptions options = new FirefoxOptions();
        WebDriver driver = new FirefoxDriver(options);
        setUp(driver);
        return driver;
    }
}