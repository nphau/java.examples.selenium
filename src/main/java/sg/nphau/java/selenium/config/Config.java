/**
 * Created by nphau on 04/05/2022, 10:30
 * Copyright (c) 2021 nphau. All rights reserved.
 * Last modified 04/05/2022, 15:54
 */

package sg.nphau.java.selenium.config;

public class Config {
    private String webBrowser;
    private String driverPath;

    public Config(String webBrowser) {
        this.webBrowser = webBrowser;
    }

    public String getWebBrowser() {
        return webBrowser;
    }

    public void setWebBrowser(String webBrowser) {
        this.webBrowser = webBrowser;
    }

    public String getDriverPath() {
        return driverPath;
    }

    public void setDriverPath(String webDriverPath) {
        this.driverPath = webDriverPath;
    }
}
