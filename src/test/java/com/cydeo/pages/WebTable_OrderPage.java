package com.cydeo.pages;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WebTable_OrderPage {

    public WebTable_OrderPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[.='Order']")
    public WebElement orderSideBar;

    @FindBy(xpath = "//button[.='View all orders']")
    public WebElement allOrdersSideBar;

    @FindBy(name = "product")
    public WebElement product;

    @FindBy(name = "quantity")
    public WebElement quantity;

    @FindBy(name = "name")
    public WebElement customerName;

    @FindBy(name = "street")
    public WebElement street;

    @FindBy(name = "city")
    public WebElement city;

    @FindBy(name = "state")
    public WebElement state;

    @FindBy(name = "zip")
    public WebElement zipcode;

    @FindBy(xpath = "//input[@type='radio'][@name='card']")
    public List<WebElement> creditCardTypes;

    @FindBy(name="cardNo")
    public WebElement creditCardNumber;

    @FindBy(name="cardExp")
    public WebElement expirationDate;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement processOrderBtn;



    public void selectProduct(String productType) {
        Select select = new Select(product);
        select.selectByVisibleText(productType);
    }

    public void selectCreditCardType(String creditCardType) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        for (WebElement cardType : creditCardTypes) {
            if(cardType.getAttribute("value").equals(creditCardType)){
                wait.until(ExpectedConditions.attributeContains(cardType, "value", creditCardType));
                cardType.click();
            }
        }
    }

}
