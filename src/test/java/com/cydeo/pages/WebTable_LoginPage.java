package com.cydeo.pages;

import com.cydeo.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebTable_LoginPage extends BasePage {

    @FindBy(name = "username")
    public WebElement usernameBox;

    @FindBy(name = "password")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[@type='submit'][.='Login']")
    public WebElement loginBtn;


    public void login(String username, String password){
        usernameBox.sendKeys(username);
        passwordBox.sendKeys(password);
        BrowserUtils.waitUntilClickable(loginBtn);
        loginBtn.click();
    }

}