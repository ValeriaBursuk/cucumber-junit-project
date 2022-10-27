package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiPage {

    @FindBy(id = "searchInput")
    private WebElement searchbox;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchBtn;

    public WikiPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    public WebElement getSearchbox() {
        return searchbox;
    }

    public WebElement getSearchBtn() {
        return searchBtn;
    }
}
