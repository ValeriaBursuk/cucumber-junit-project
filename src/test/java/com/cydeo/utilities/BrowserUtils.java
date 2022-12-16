package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BrowserUtils {

    public static void sleep(int seconds) {

        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Performs a pause
     *
     * @param seconds
     */
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Waits for element to be clickable
     */
    public static WebElement waitForElementToBeClickable(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Checks for visibility of the element
     * @param element
     * @return
     */
    public static boolean checkVisibilityOfElement(WebElement element) {
        boolean result = false;
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);

        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            result = true;
            System.out.println("Element was visible withing the timeframe");
        } catch (TimeoutException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    /**
     * Checks for visibility of the element
     * @param element
     * @param waitTime
     * @return
     */
    public static boolean checkVisibilityOfElement(WebElement element, int waitTime) {
        boolean result = false;
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), waitTime);

        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            result = true;
            System.out.println("Element was visible withing the timeframe");
        } catch (TimeoutException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Checks for invisibility of the element
     * @param element
     * @param waitTime
     */
    public static void waitForInvisibilityOf(WebElement element, int waitTime) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), waitTime);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public static void waitForInvisibilityOf(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Waits for visibility of the element
     * @param element
     * @param waitTime
     */
    public static void waitForVisibilityOf(WebElement element, int waitTime) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), waitTime);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForVisibilityOf(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Switch windows and verify title
     * @param expectedUrl
     * @param expectedTitle
     */

    public static void switchWindowAndVerify(String expectedUrl, String expectedTitle) {
        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();

        for (String eachWindow : allWindowHandles) {
            Driver.getDriver().switchTo().window(eachWindow);
            if (Driver.getDriver().getCurrentUrl().contains(expectedUrl)) {
                break;
            }
        }
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue("Title verification failed", actualTitle.contains(expectedTitle));
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     *
     * @param expectedTitle
     */

    public static void verifyTitle(String expectedTitle) {
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals("Title Verification Failed", actualTitle, expectedTitle);

    }

    /**
     * Verify title contains
     * @param expectedTitle
     */
    public static void verifyTitleContains(String expectedTitle) {
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue("Title Verification Failed", actualTitle.contains(expectedTitle));
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////


    /**
     * this method will accept Dropdown as WebElement and return all the options' text as a List of String
     */
    public static List<String> getDropdownOptionsAsString(WebElement selectElement) {
        Select select = new Select(selectElement);
        List<WebElement> optionsElements = select.getOptions();
        List<String> listOfActualOptions = new ArrayList<>();

        for (WebElement option : optionsElements) {
            String actualText = option.getText();
            listOfActualOptions.add(actualText);
        }

        return listOfActualOptions;
    }


    /**
     * Waits for provided element to be clickable
     *
     * @param element
     * @param timeout
     * @return
     */
    public static WebElement waitForClickability(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Waits for element matching the locator to be clickable
     *
     * @param locator
     * @param timeout
     * @return
     */
    public static WebElement waitForClickability(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }






    /**
     * Returns Elements texts with Stream
     * @param elements
     * @return list<String>
     */

    public static List<String> getElementsText(List<WebElement> elements) {
        List<String> elementsText = new ArrayList<>();
        for (WebElement element : elements) {
            elementsText.add(element.getText());
        }

        return elementsText;
    }

    /**
     * Returns Elements texts with Stream
     * @param elements
     * @return list<String>
     */

    public static List<String> getElementsTextWithStream(List<WebElement> elements) {

        return elements.stream().map(x->x.getText()).collect(Collectors.toList());
    }



    /**
     * Scrolls down to an element using JavaScript
     *
     * @param element
     */
    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }



    /**
     * Clicks on an element using JavaScript
     *
     * @param element
     */
    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Waits for alertIsPresent
     */
    public static void waitForAlertIsPresent(int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        wait.until(ExpectedConditions.alertIsPresent());
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Click on radio button  with attribute value
     * @param radioButtons
     * @param attributeValue
     */
    public static void clickRadioButton(List<WebElement> radioButtons, String attributeValue) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        for (WebElement radioButtton : radioButtons) {
            if (radioButtton.getAttribute("value").equalsIgnoreCase(attributeValue)) {
                wait.until(ExpectedConditions.attributeContains(radioButtton, "value", attributeValue));
                radioButtton.click();
            }
        }
    }

    /**
     * This method will accept dropdown as a WebElement
     * and return all the options' text in a List of String
     * @return List<String>
     */
    public static List<String> dropdownOptionsAsString(WebElement dropdownElement){

        Select select = new Select(dropdownElement);

        //List of all ACTUAL month <options> as a WebElement
        List<WebElement> actualOptionsAsWebElement = select.getOptions();

        //List of all ACTUAL month options as a String
        List<String> actualOptionsAsString = new ArrayList<>();

        // with using for loop we will convert each WebElement of options to String wit using getText() method
        // with using add() method we will add each String option in List<String> actual options as String
        for (WebElement each : actualOptionsAsWebElement) {
            actualOptionsAsString.add(each.getText());
        }

        return actualOptionsAsString;

    }

    /**
     * This method will accept a String as expected value and verify actual URL CONTAINS the value.
     * @param expectedInURL
     */
    public static void verifyURLContains(String expectedInURL){
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedInURL));
    }

    /**
     * Switches to new window by the exact title. Returns to original window if target title not found
     * @param targetTitle
     */
    public static void switchToWindow(String targetTitle) {
        String origin = Driver.getDriver().getWindowHandle();
        for (String handle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(handle);
            if (Driver.getDriver().getTitle().equals(targetTitle)) {
                return;
            }
        }
        Driver.getDriver().switchTo().window(origin);
    }

    /**
     * Moves the mouse to given element
     *
     * @param element on which to hover
     */
    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }


    /**
     * waits for backgrounds processes on the browser to complete
     *
     * @param timeOutInSeconds
     */
    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOutInSeconds);
            wait.until(expectation);
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }

    /**
     * Verifies whether the element matching the provided locator is displayed on page
     *
     * @param by
     * @throws AssertionError if the element matching the provided locator is not found or not displayed
     */
    public static void verifyElementDisplayed(By by) {
        try {
            Assert.assertTrue("Element not visible: " + by, Driver.getDriver().findElement(by).isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            Assert.fail("Element not found: " + by);

        }
    }


    /**
     * Verifies whether the element matching the provided locator is NOT displayed on page
     *
     * @param by
     * @throws AssertionError the element matching the provided locator is displayed
     */
    public static void verifyElementNotDisplayed(By by) {
        try {
            Assert.assertFalse("Element should not be visible: " + by, Driver.getDriver().findElement(by).isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();

        }
    }


    /**
     * Verifies whether the element is displayed on page
     *
     * @param element
     * @throws AssertionError if the element is not found or not displayed
     */
    public static void verifyElementDisplayed(WebElement element) {
        try {
            Assert.assertTrue("Element not visible: " + element, element.isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            Assert.fail("Element not found: " + element);

        }
    }

    /**
     * Waits for element to be not stale
     *
     * @param element
     */
    public static void waitForStaleElement(WebElement element) {
        int y = 0;
        while (y <= 15) {
            if (y == 1)
                try {
                    element.isDisplayed();
                    break;
                } catch (StaleElementReferenceException st) {
                    y++;
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } catch (WebDriverException we) {
                    y++;
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        }
    }

    /**
     * Performs double click action on an element
     *
     * @param element
     */
    public static void doubleClick(WebElement element) {
        new Actions(Driver.getDriver()).doubleClick(element).build().perform();
    }

    /**
     * Changes the HTML attribute of a Web Element to the given value using JavaScript
     *
     * @param element
     * @param attributeName
     * @param attributeValue
     */
    public static void setAttribute(WebElement element, String attributeName, String attributeValue) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", element, attributeName, attributeValue);
    }

    /**
     * Highlighs an element by changing its background and border color
     * @param element
     */
    public static void highlight(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
        waitFor(1);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].removeAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }

    /**
     * Checks or unchecks given checkbox
     *
     * @param element
     * @param check
     */
    public static void selectCheckBox(WebElement element, boolean check) {
        if (check) {
            if (!element.isSelected()) {
                element.click();
            }
        } else {
            if (element.isSelected()) {
                element.click();
            }
        }
    }

    /**
     * attempts to click on provided element until given time runs out
     *
     * @param element
     * @param timeout
     */
    public static void clickWithTimeOut(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                waitFor(1);
            }
        }
    }





    /**
     * executes the given JavaScript command on given web element
     *
     * @param element
     */
    public static void executeJScommand(WebElement element, String command) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript(command, element);

    }

    /**
     * executes the given JavaScript command on given web element
     *
     * @param command
     */
    public static void executeJScommand(String command) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript(command);

    }


    /**
     * This method will recover in case of exception after unsuccessful the click,
     * and will try to click on element again.
     *
     * @param by
     * @param attempts
     */
    public static void clickWithWait(By by, int attempts) {
        int counter = 0;
        //click on element as many as you specified in attempts parameter
        while (counter < attempts) {
            try {
                //selenium must look for element again
                clickWithJS(Driver.getDriver().findElement(by));
                //if click is successful - then break
                break;
            } catch (WebDriverException e) {
                //if click failed
                //print exception
                //print attempt
                e.printStackTrace();
                ++counter;
                //wait for 1 second, and try to click again
                waitFor(1);
            }
        }
    }

    /**
     *  checks that an element is present on the DOM of a page. This does not
     *    * necessarily mean that the element is visible.
     * @param by
     * @param time
     */
    public static void waitForPresenceOfElement(By by, long time) {
        new WebDriverWait(Driver.getDriver(), time).until(ExpectedConditions.presenceOfElementLocated(by));
    }



    public static void waitUntilClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }



    //    public static void takeScreenshot(String FileName){
//        try{
//            File File = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.FILE);
//            FileUtils.copyFile(File, new File(""
//                    + FileName + ".jpeg"));
//
//        } catch(IOException ie){
//        }
//    }

}

