package com.example.framework.pages;

import com.example.framework.config.Config;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginButton = By.id("login-button");

    public LoginPage open() {
        driver.get(Config.get("base.url"));
        return this;
    }

    public ProductsPage loginAs(String user, String secret) {
        type(username, user);
        type(password, secret);
        click(loginButton);
        return new ProductsPage();
    }
}
