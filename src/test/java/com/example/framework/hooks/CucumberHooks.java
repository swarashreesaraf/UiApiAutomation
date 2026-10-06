package com.example.framework.hooks;

import com.example.framework.driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CucumberHooks {
    @Before("@ui")
    public void startBrowser() {
        DriverFactory.start();
    }

    @After("@ui")
    public void stopBrowser() {
        DriverFactory.stop();
    }
}
