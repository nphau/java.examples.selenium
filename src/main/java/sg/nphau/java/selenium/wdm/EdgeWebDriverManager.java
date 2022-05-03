/**
 * Created by nphau on 04/05/2022, 10:30
 * Copyright (c) 2021 nphau. All rights reserved.
 * Last modified 04/05/2022, 15:54
 */

package sg.nphau.java.selenium.wdm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import javax.annotation.Nullable;

class EdgeWebDriverManager extends WebDriverManager {

    @Override
    protected DriverType getDriverType() {
        return DriverType.EDGE;
    }

    @Override
    public WebDriver setUp(@Nullable String driverPath) {
        EdgeOptions options = new EdgeOptions();
        WebDriver driver = new EdgeDriver(options);
        setUp(driver);
        return driver;
    }
}