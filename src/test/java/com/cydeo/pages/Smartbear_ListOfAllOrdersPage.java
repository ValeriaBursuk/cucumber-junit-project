package com.cydeo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Smartbear_ListOfAllOrdersPage extends BasePage{


    @FindBy(xpath = "//table/tbody/tr[2]/td[2]")
    public WebElement actualNameInTable;
}
