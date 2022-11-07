package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SmartBear_CommonPage  {

    public SmartBear_CommonPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='login_info']")
    public WebElement userName;

    @FindBy(linkText = "Order")
    public WebElement orderTab;

    @FindBy(linkText = "View all orders")
    public WebElement viewAllOrdersTab;

    @FindBy(linkText = "View all products")
    public WebElement viewAllProducts;

    public boolean isUserNameDisplayed() {
        return userName.getText().contains("Tester");
    }



}
