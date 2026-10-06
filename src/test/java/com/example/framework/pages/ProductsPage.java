package com.example.framework.pages;

import org.openqa.selenium.By;

public class ProductsPage extends BasePage {
    private final By title = By.cssSelector("[data-test='title']");

    public boolean isDisplayed() {
        return isVisible(title);
    }
}
