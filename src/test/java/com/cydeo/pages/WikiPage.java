package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiPage {
    public WikiPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "searchInput")
    private WebElement searchbox;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchBtn;

    @FindBy(id = "firstHeading")
    private WebElement mainHeader;

    @FindBy(xpath = "//table//th[@class='infobox-above']//div")
    private WebElement imgHeader;


    public WebElement getSearchbox() {
        return searchbox;
    }

    public WebElement getSearchBtn() {
        return searchBtn;
    }

    public WebElement getMainHeader(){return mainHeader;}

    public WebElement getImgHeader() {
        return imgHeader;
    }
}
