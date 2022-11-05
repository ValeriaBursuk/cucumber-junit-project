package com.cydeo.pages;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HioskarPage {

    public HioskarPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//div[@class='fieldMessages_field__hR-R1']")
    public List<WebElement> dropdowns;

    @FindBy(xpath = "//button[@type='button'][2]")
    public WebElement continueBtn;

    public void clickCategory(String category) {
        Driver.getDriver().findElement(By.xpath("//span[.='" + category + "']")).click();
    }

    public void selectAnything(String anything) {
        WebElement element = Driver.getDriver().findElement(By.xpath("//div[@aria-label='" + anything + "']"));
        element.click();
    }

}
