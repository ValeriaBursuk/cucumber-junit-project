package com.cydeo.pages;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTable_LoginPage  {

    public WebTable_LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "username")
    public WebElement usernameBox;

    @FindBy(name = "password")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[@type='submit'][.='Login']")
    public WebElement loginBtn;


    public void login(String username, String password){
        usernameBox.sendKeys(username);
        BrowserUtils.sleep(1);
        passwordBox.sendKeys(password);
        BrowserUtils.sleep(1);
        loginBtn.click();
    }

}
