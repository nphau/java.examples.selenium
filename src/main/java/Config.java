/**
 * Created by nphau on 04/05/2022, 10:30
 * Copyright (c) 2021 nphau. All rights reserved.
 * Last modified 04/05/2022, 15:54
 */
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Config {

    public static void setUp(WebDriver driver) {
        // Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public enum Properties {

        CHROME("webdriver.chrome.driver", "./src/main/resources/chromedriver");

        public final String key;
        public final String value;

        Properties(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
}
