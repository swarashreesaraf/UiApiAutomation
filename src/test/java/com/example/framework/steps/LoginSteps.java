package com.example.framework.steps;

import com.example.framework.pages.LoginPage;
import com.example.framework.pages.ProductsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.Assert.assertTrue;

public class LoginSteps {
    private LoginPage loginPage;
    private ProductsPage productsPage;

    @Given("I open the login page")
    public void openLoginPage() {
        loginPage = new LoginPage().open();
    }

    @When("I log in with username {string} and password {string}")
    public void login(String username, String password) {
        productsPage = loginPage.loginAs(username, password);
    }

    @Then("I should see the products page")
    public void verifyProductsPage() {
        assertTrue(productsPage.isDisplayed(), "Products page was not displayed");
    }
}
