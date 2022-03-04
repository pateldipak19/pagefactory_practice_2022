package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class HomePage extends Utility {

    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    @FindBy(xpath = "//ul[@class='top-menu notmobile']/li/a[text()='Computers ']")
    WebElement _computerTab;

    @FindBy(xpath = "//ul[@class='top-menu notmobile']/li/ul/li/a[@href='/notebooks']")
    WebElement _notebooksLink;



    public void mouseHoverOnComputerTab(){
        Reporter.log("Mouse Hover on Computer Tab "+ _computerTab.toString()+"<br>");
        mouseHoverToElement(_computerTab);
        log.info("Mouse Hover on Computer Tab "+ _computerTab.toString());
    }

    public void clickOnNotebookLink(){
        Reporter.log("Clicking on Notebooks link "+ _notebooksLink.toString()+"<br>" );
        clickOnElement(_notebooksLink);
        log.info("Clicking on Notebooks link "+ _notebooksLink.toString());
    }




}
