package com.example.framework.driver;

import com.example.framework.config.Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public final class DriverFactory {
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    private DriverFactory() {
    }

    public static void start() {
        String browser = Config.get("browser").toLowerCase();
        if (!browser.equals("chrome")) {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
        // Local browser setup: Test
       //  WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        if (Config.getBoolean("headless")) {
            options.addArguments("--headless=new");
        }
        options.addArguments("--window-size=1920,1080");
        // DRIVER.set(new ChromeDriver(options));

        // Selenium Grid setup:
        try {
            DRIVER.set(new RemoteWebDriver(
                    new URL("http://192.168.0.101:4444/wd/hub"),
                    options
            ));
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Invalid Selenium Grid URL", e);
        }
    }

    public static WebDriver get() {
        WebDriver driver = DRIVER.get();
        if (driver == null) {
            throw new IllegalStateException("WebDriver has not been started");
        }
        return driver;
    }

    public static void stop() {
        WebDriver driver = DRIVER.get();
        if (driver != null) {
            driver.quit();
            DRIVER.remove();
        }
    }
}
