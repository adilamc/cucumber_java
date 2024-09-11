package com.tau.steps;

import base.BaseUtil;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static junit.framework.Assert.assertTrue;

public class LoginTest extends BaseUtil {

    private BaseUtil baseUtil;

    private LoginTest(BaseUtil util){
        this.baseUtil =util;
    }

    private WebDriver driver;

    @Before
    public  void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Given("I'm in login page")
    @Given("I'm in login page of ParaBank Application")
    public void i_m_in_login_page_of_para_bank_application() {

        driver.get("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");
    }

//    @When("I enter valid credentials")
//    public void i_enter_valid_credentials() {
//        driver.findElement(By.xpath("//input[@name ='username']")).sendKeys("tautester");
//        driver.findElement(By.xpath("//input[@name ='password']")).sendKeys("password");
//        driver.findElement(By.xpath("//input[@type ='submit']")).click();
//
//    }

    @When("I enter valid {string} and {string} with {string}")
    public void i_enter_valid_credentials(String username, String password, String userFullName) {

        baseUtil.userFullName = userFullName;
        driver.findElement(By.xpath("//input[@name ='username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@name ='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@type ='submit']")).click();

    }

    @Then("I should be taken to Overview page")
    public void i_should_be_taken_to_overview_page() throws InterruptedException {
        Thread.sleep(5000);
        String actualuserFullName =driver.findElement(By.className("smallText")).getText().toString();
        System.out.println(baseUtil.userFullName.toString());
        assertTrue(actualuserFullName, actualuserFullName.contains(baseUtil.userFullName));
        driver.findElement(By.xpath("//*[@id ='rightPanel']/h1")).isDisplayed();
        driver.findElement(By.linkText("Log Out")).click();
    }

    @When("I enter valid credentials")
    public void iEnterValidCredentials(DataTable table) {
        List<String> loginForm = table.asList();
        driver.findElement(By.xpath("//input[@name ='username']")).sendKeys(loginForm.get(0));
        driver.findElement(By.xpath("//input[@name ='password']")).sendKeys(loginForm.get(1));
        driver.findElement(By.xpath("//input[@type ='submit']")).click();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
