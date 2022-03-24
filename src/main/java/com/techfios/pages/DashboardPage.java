package com.techfios.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
    
    WebDriver driver;
    
    public DashboardPage(WebDriver driver){
        this.driver = driver; 
        PageFactory.initElements(driver, this);
    }

    //WebElement Library
    @FindBy (how = How.XPATH, using = "//span[text() = 'Dashboard']") WebElement dashboardButton;
    @FindBy (how = How.XPATH, using = "//h2[contains(text(), 'Dashboard')]") WebElement pageTitle;
    @FindBy (how = How.XPATH, using = "//span[text() = 'Bank & Cash']") WebElement bankCash;
    @FindBy (how = How.XPATH, using = "//a[contains(text(), 'New Account')]") WebElement newAccount;

    public void clickOnDashboard(){
        dashboardButton.click();
    }
    public void verifyDashboard (){
       Assert.assertEquals("Not on Dashboard Page!", "Dashboard", pageTitle.getText());
    }

    public void clickBankButton (){
        bankCash.click();
    }
    public void clickNewAccount (){
        newAccount.click();
    }
    public void waitForDashboardPage() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()=' Dashboard ']")));
        System.out.println("Dashboard Loaded!");
    }


}
