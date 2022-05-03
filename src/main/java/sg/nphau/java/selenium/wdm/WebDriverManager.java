/**
 * Created by nphau on 04/05/2022, 10:30
 * Copyright (c) 2021 nphau. All rights reserved.
 * Last modified 04/05/2022, 15:54
 */

package sg.nphau.java.selenium.wdm;

import org.openqa.selenium.WebDriver;

import javax.annotation.Nullable;
import java.time.Duration;

public abstract class WebDriverManager {

    protected abstract DriverType getDriverType();

    public abstract WebDriver setUp(@Nullable String driverPath);

    protected void setUp(WebDriver driver) {
        // Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static synchronized WebDriverManager get(String webBrowser) {
        if (webBrowser.equalsIgnoreCase(DriverType.CHROME.toString())) {
            return chromeDriver();
        } else if (webBrowser.equalsIgnoreCase(DriverType.EDGE.toString())) {
            return edgeDriver();
        } else {
            return firefoxDriver();
        }
    }

    public static synchronized WebDriverManager chromeDriver() {
        return new ChromeWebDriverManager();
    }

    public static synchronized WebDriverManager edgeDriver() {
        return new EdgeWebDriverManager();
    }

    public static synchronized WebDriverManager firefoxDriver() {
        return new FireFoxWebDriverManager();
    }
}
