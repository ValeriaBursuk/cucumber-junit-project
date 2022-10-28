package com.cydeo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EtsyPage extends BasePage {

    @FindBy(id = "global-enhancements-search-query")
    private WebElement searchBox;

    @FindBy(xpath = "//button[@type='submit'][@value='Search']")
    private WebElement searchButton;


    public WebElement getSearchBox() {
        return searchBox;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }


    // ABSTRACT BASE PAGE
    //PAGE.INIT.ELEMENTS(DRIVER.GT.DRIVER, THIS)









}
