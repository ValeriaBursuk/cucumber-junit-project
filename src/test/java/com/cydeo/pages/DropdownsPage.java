package com.cydeo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DropdownsPage extends BasePage{

    @FindBy(id = "month")
    public WebElement months_dropdown;

}
