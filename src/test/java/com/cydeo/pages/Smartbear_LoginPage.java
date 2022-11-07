package com.cydeo.pages;

import com.cydeo.utilities.ConfigReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Smartbear_LoginPage {
    public Smartbear_LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id = "ctl00_MainContent_username")
    public WebElement usernamePlaceholder; //declaring an instance field

    @FindBy(id="ctl00_MainContent_password")
    public WebElement passwordPlaceholder;

    @FindBy(id="ctl00_MainContent_login_button")
    public WebElement loginBtn;

    public void goTo(){
        Driver.getDriver().get(ConfigReader.getProperty("smartbear_url"));
    }

    public void login(String username, String password){
        usernamePlaceholder.sendKeys(username);
        passwordPlaceholder.sendKeys(password);
        loginBtn.click();
    }

    public boolean isAtLoginPage(){
        return Driver.getDriver().getTitle().equals("Web Orders Login");
    }


}
