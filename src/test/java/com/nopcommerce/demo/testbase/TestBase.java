package com.nopcommerce.demo.testbase;

import com.nopcommerce.demo.propertyreader.PropertyReader;
import com.nopcommerce.demo.utility.Utility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class TestBase extends Utility {

    String browser = PropertyReader.getInstance().getProperty("browser");

    @BeforeMethod(groups = {"regression","sanity","smoke"})

    public void openBrowser(){

        selectBrowser(browser);

    }

    @AfterMethod(groups = {"regression","sanity","smoke"})

    public void tearDown(){

        closeBrowser();
    }

}
