/**
 * Created by nphau on 04/05/2022, 10:30
 * Copyright (c) 2021 nphau. All rights reserved.
 * Last modified 04/05/2022, 15:54
 */

package sg.nphau.java.selenium;

import org.openqa.selenium.WebDriver;
import sg.nphau.java.selenium.config.Config;
import sg.nphau.java.selenium.config.ConfigLoader;
import sg.nphau.java.selenium.utils.Utils;
import sg.nphau.java.selenium.wdm.WebDriverManager;

public class Main {

    private final static String BASE_URL = "https://www.nytimes.com/international";

    public static void main(String[] args) {
        Config config = ConfigLoader.loadConfig();
        WebDriver driver = WebDriverManager
                .get(config.getWebBrowser())
                .setUp(config.getWebDriverPath());
        try {
            driver.get(BASE_URL);
            // get the actual value of the title
            String actualTitle = driver.getTitle();
            String currentUrl = driver.getCurrentUrl();
            Utils.screenshot(driver);
            System.out.println("ActualTitle:" + actualTitle);
            System.out.println("CurrentUrl:" + currentUrl);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // close
            driver.close();
        }
    }
}
