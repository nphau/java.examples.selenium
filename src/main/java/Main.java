/**
 * Created by nphau on 04/05/2022, 10:30
 * Copyright (c) 2021 nphau. All rights reserved.
 * Last modified 04/05/2022, 15:54
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    private final static String BASE_URL = "https://github.com";

    public static void main(String[] args) {
        System.setProperty(Config.Properties.CHROME.key, Config.Properties.CHROME.value);

        WebDriver driver = new ChromeDriver();
        try {
            Config.setUp(driver);
            driver.get(BASE_URL);

            // get the actual value of the title
            String actualTitle = driver.getTitle();
            System.out.println("Title: " + actualTitle);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // close
            driver.close();
        }
    }
}
