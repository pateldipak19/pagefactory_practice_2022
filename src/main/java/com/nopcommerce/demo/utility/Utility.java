package com.nopcommerce.demo.utility;

import com.nopcommerce.demo.basepage.BasePage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Utility extends BasePage {

    public void dragAndDrop(By draggable, By droppable){

        Actions action = new Actions(driver);

        action.dragAndDrop(driver.findElement(draggable),driver.findElement(droppable)).build().perform();

    }



    public void clickOnElement(By by){

        driver.findElement(by).click();
    }

    public void clickOnElement(WebElement element){

       element.click();
    }



    public void mouseHoverToElement(By by){

        Actions actions = new Actions(driver);

        actions.moveToElement(driver.findElement(by)).build().perform();
    }

    public void mouseHoverToElement(WebElement element){

        Actions actions = new Actions(driver);

        actions.moveToElement(element).build().perform();
    }

    public void sendKeyOnElement(By by, String text){

        Actions actions = new Actions(driver);
        actions.sendKeys(driver.findElement(by),text).build().perform();
    }

    public void sendKeyOnElement(WebElement element){

        Actions actions = new Actions(driver);
        actions.sendKeys(element).build().perform();
    }


  /* public void keyBordKeyAction(By by,Keys keys){

      Actions actions = new Actions(driver);
      actions.keyDown(driver.findElement(by),keys).perform();

   }*/


    public String getTextFromElement(By by){

       return driver.findElement(by).getText();


    }

    public String getTextFromElement(WebElement element){

       return element.getText();


    }



    public void selectByVisibleTextFromDropDown(By by, String visibleText){

        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(visibleText);

    }

    public void selectByVisibleTextFromDropDown(WebElement element, String visibleText){

        Select select = new Select(element);
        select.selectByVisibleText(visibleText);

    }

    public void selectByValueFromDropDown(By by, String value){

        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);

    }

    public void selectByValueFromDropDown(WebElement element, String value){

        Select select = new Select(element);
        select.selectByValue(value);

    }

    public void selectByIndexFromDropDown(By by, String index){

        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(index);

    }

    public void selectByIndexFromDropDown(WebElement element, String index){

        Select select = new Select(element);
        select.selectByVisibleText(index);

    }


    public int generateRandomNumbers(){

        return (int) (Math.random() * 1000 + 1);
    }





    public static String currentTimeStamp() {
        Date d = new Date();
        return d.toString().replace(":", "_").replace(" ", "_");
    }

    /*
     *Screenshot methods
     */
    public static String takeScreenShot(String fileName) {
        String filePath = System.getProperty("user.dir") + "/test-output/html/";
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File scr1 = screenshot.getScreenshotAs(OutputType.FILE);
        String imageName = fileName + currentTimeStamp() + ".jpg";
        String destination = filePath + imageName;
        try {
            FileUtils.copyFile(scr1, new File(destination));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }


    public List<Double> sortByForPrices(List<WebElement> elements)  {


        List<Double> defaultPriceInDouble = new ArrayList<>();

        for (WebElement a : elements) {
            defaultPriceInDouble.add(Double.valueOf(a.getText().replace("$", "")
                    .replace(",","")));
        }

        return defaultPriceInDouble;
    }


    public List<String> sortByForProductsByName(List<WebElement> element){

        List<String> defaultProductName = new ArrayList<>();

        for (WebElement s: element) {

            defaultProductName.add(s.getText());
        }
        return defaultProductName;
    }
}
