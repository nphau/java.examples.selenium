/**
 * Created by nphau on 04/05/2022, 10:30
 * Copyright (c) 2021 nphau. All rights reserved.
 * Last modified 04/05/2022, 15:54
 */

package sg.nphau.java.selenium.wdm;

import org.openqa.selenium.WebDriver;
import sg.nphau.java.selenium.config.Config;
import sg.nphau.java.selenium.config.ConfigLoader;

import javax.annotation.Nullable;
import java.time.Duration;

public abstract class WebDriverManager {

    protected abstract DriverType getDriverType();

    protected abstract WebDriver setUp(@Nullable String driverPath);

    protected void setUp(WebDriver driver) {
        // Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    public static synchronized WebDriver get(String webBrowser) {
        WebDriverManager manager;
        if (webBrowser.equalsIgnoreCase(DriverType.CHROME.toString())) {
            manager = chromeDriver();
        } else if (webBrowser.equalsIgnoreCase(DriverType.EDGE.toString())) {
            manager = edgeDriver();
        } else {
            manager = firefoxDriver();
        }
        Config config = ConfigLoader.loadConfig();
        return manager.setUp(config.getDriverPath());
    }

    public static synchronized WebDriver get(DriverType type) {
        return get(type.toString());
    }

    private static synchronized WebDriverManager chromeDriver() {
        return new ChromeWebDriverManager();
    }

    private static synchronized WebDriverManager edgeDriver() {
        return new EdgeWebDriverManager();
    }

    private static synchronized WebDriverManager firefoxDriver() {
        return new FireFoxWebDriverManager();
    }
}
