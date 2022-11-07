package com.cydeo.pages;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SmartBear_OrderPage {
    public SmartBear_OrderPage(){
            PageFactory.initElements(Driver.getDriver(), this);
        }

    @FindBy(id = "ctl00_MainContent_fmwOrder_ddlProduct")
    public WebElement product;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtQuantity")
    public WebElement quantity;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtName")
    public WebElement name;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox2")
    public WebElement street;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox3")
    public WebElement city;


    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox4")
    public WebElement state;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox5")
    public WebElement zip;

    @FindBy(xpath = "//input[@type='radio'][@name='ctl00$MainContent$fmwOrder$cardList']")
    public List<WebElement> cardTypes;

    @FindBy(id = "ctl00_MainContent_fmwOrder_InsertButton")
    public WebElement processButton;

    @FindBy(xpath = "//strong")
public WebElement successNotification;

//    @FindBy(xpath = "//input[@value='Visa']")
//    public WebElement cardTypeVisa;
//
//    @FindBy(xpath = "//input[@value='MasterCard']")
//    public WebElement cardTypeMasterCard;
//
//    @FindBy(xpath = "//input[@value='AmericanExpress']")
//    public WebElement cardTypeAmericanExpress;


    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox6")
    public WebElement cardNumber;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox1")
    public WebElement expiration;

    public void selectCardType(String cardType) {
        for (WebElement type : cardTypes) {
            if (type.getAttribute("value").equals(cardType)) {
                type.click();
            }
        }
    }
}
