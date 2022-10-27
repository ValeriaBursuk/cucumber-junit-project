package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class BrowserUtils {

    public static void sleep(int seconds) {

        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

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


//    public static void takeScreenshot(String FileName){
//        try{
//            File File = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.FILE);
//            FileUtils.copyFile(File, new File(""
//                    + FileName + ".jpeg"));
//        } catch(IOException ie){
//        }
//    }



//    public static void verifyTitle(String expectedTitle){
//        String actualTitle = Driver.getDriver().getTitle();
//        Assert.assertEquals(expectedTitle, actualTitle);
//
//    }






}

