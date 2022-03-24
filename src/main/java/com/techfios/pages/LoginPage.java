package com.techfios.pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    
    WebDriver driver;
    String requestUrl = "jdbc:mysql://localhost:3306/september2021";
    String query = "select * from customerinformation order by full_name asc limit 1;";
    
    ResultSet rs;
    

    public LoginPage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);

       /* try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection c = DriverManager.getConnection(requestUrl, "root", "root");

            Statement s = c.createStatement();

            rs = s.executeQuery(query);
            rs.next();
            System.out.println(rs.getString("full_name"));


        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        */


    }
    

    //WebElement Library
    @FindBy (how = How.XPATH, using = "//input[@id='username']") WebElement username;
    @FindBy (how = How.XPATH, using = "//input[@id='password']") WebElement password;
    @FindBy (how = How.XPATH, using = "//button[@name='login']") WebElement submit;
    @FindBy (how = How.XPATH, using = "//a[contains(text(), 'Forgot password ?')]") WebElement loginText;
    @FindBy (how = How.XPATH, using = "//h2[contains(text(), 'Dashboard')]") WebElement dashboardText;

    public void login (String u, String p){
        username.sendKeys(u);
        password.sendKeys(p);
        submit.click();
    }
    public void typeUsername (String u){
        username.sendKeys(u);
    }
    public void typePassword (String p){
        password.sendKeys(p);
    }
    public void submit (){
        submit.click();
    }
    public void AssertDashboardPage (){
        Assert.assertEquals("Not on Dashboard!", "Dashboard", dashboardText.getText());
        driver.quit();
    }
    public void AssertNotDashboardPage (){
        Assert.assertEquals("Not on Login!", "Forgot password ?", loginText.getText());
        driver.quit();
    }

    
}
