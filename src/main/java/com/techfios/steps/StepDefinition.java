package com.techfios.steps;

import java.util.Random;

import com.techfios.pages.BankPage;
import com.techfios.pages.DashboardPage;
import com.techfios.pages.LoginPage;
import com.techfios.utils.BrowserFactory;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition {

    private WebDriver driver;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private BankPage bankPage;

    @Before
    public void BeforeMethod() {

        driver = (new BrowserFactory().init());

        loginPage = new LoginPage(driver);

        dashboardPage = new DashboardPage(driver);

        bankPage = new BankPage(driver);

    }

    @Given("^User is on techfios website in the billing page$")
    public void user_is_on_techfios_website_in_the_billing_page() {

        driver.get("https://www.techfios.com/billing");

    }

    @When("^User enters \"([^\"]*)\" \"([^\"]*)\"$")
    public void user_enters(String arg1, String arg2) {

        if (arg1.equalsIgnoreCase("username")) {
            loginPage.typeUsername(arg2);
        } else if (arg1.equalsIgnoreCase("password")) {
            loginPage.typePassword(arg2);
        }

    }

    @When("^User clicks \"([^\"]*)\"$")
    public void user_clicks_submit(String arg0) {

        if (arg0.equalsIgnoreCase("login")) {
            loginPage.submit();
        } else if (arg0.equalsIgnoreCase("bankCash")) {
            dashboardPage.clickBankButton();
        } else if (arg0.equalsIgnoreCase("newAccount")) {
            dashboardPage.clickNewAccount();
        } else if (arg0.equalsIgnoreCase("submit")) {
            bankPage.submit();
        }
        // else {
        // System.out.println("not found!");
        // }

    }

    @Then("^User should land on Dashboard page$")
    public void user_should_land_on_Dashboard_page() {

        dashboardPage.waitForDashboardPage();
        dashboardPage.verifyDashboard();
    }

    @Then("^User enters \"([^\"]*)\" in accounts page$")
    public void user_enters(String arg0) {

        if (arg0.equalsIgnoreCase("accountTitle")) {
            bankPage.fillAccount((1234 + (new Random()).nextInt(12345)) + "Md Checking");
        } else if (arg0.equalsIgnoreCase("description")) {
            bankPage.fillDescription("Md's checking account");
        } else if (arg0.equalsIgnoreCase("initialBalance")) {
            bankPage.fillBalance("1000000");
        } else if (arg0.equalsIgnoreCase("accountNumber")) {
            bankPage.fillAccountNumber("1100011");
        } else if (arg0.equalsIgnoreCase("contactPerson")) {
            bankPage.fillContactPerson("Morgan Chase");
        } else if (arg0.equalsIgnoreCase("phone")) {
            bankPage.fillContactPhone("347813");
        } else if (arg0.equalsIgnoreCase("internetBankingUrl")) {
            bankPage.fillUrl("https://www.chase.com");
        }
        // else {
        // System.out.println("not found!!");
        // }
    }

    @Then("^User should be able to validate account created successfully$")
    public void user_should_be_able_to_validate_account_created_successfully() {

        bankPage.confirmAccountCreation();
    }

}
