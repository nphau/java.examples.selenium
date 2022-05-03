/**
 * Created by nphau on 04/05/2022, 10:30
 * Copyright (c) 2021 nphau. All rights reserved.
 * Last modified 04/05/2022, 15:54
 */

package sg.nphau.java.selenium.config;

import org.apache.log4j.PropertyConfigurator;
import sg.nphau.java.selenium.wdm.DriverType;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;

public class ConfigLoader {

    private static final String CONFIG_PATH = "config.properties";
    private static final String LOG4J2_PATH = "log4j2.properties";

    public static Config loadConfig() {
        Config config = new Config(DriverType.CHROME.toString().toLowerCase(Locale.ROOT));
        try {
            Properties properties = new Properties();
            InputStream inputStream = ConfigLoader.class.getClassLoader().getResourceAsStream(CONFIG_PATH);
            properties.load(inputStream);
            config.setWebBrowser(properties.getProperty("webBrowser"));
            config.setWebDriverPath(properties.getProperty("webDriverPath"));

            Properties log4jProperties = new Properties();
            InputStream log4jIs = ConfigLoader.class.getClassLoader().getResourceAsStream(LOG4J2_PATH);
            log4jProperties.load(log4jIs);
            PropertyConfigurator.configure(log4jProperties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return config;
    }

}
