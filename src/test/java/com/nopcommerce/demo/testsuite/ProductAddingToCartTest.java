package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.NotebooksPage;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Collections;
import java.util.List;

public class ProductAddingToCartTest extends TestBase {

    HomePage homePage;
    NotebooksPage notebooksPage;
    SoftAssert softAssert;



    @BeforeMethod(groups = {"regression"})
    public void setUp(){

        homePage = new HomePage();
        notebooksPage = new NotebooksPage();
        softAssert = new SoftAssert();
    }

    @Test(groups = {"regression"})
    public void verifyUserAbleToAddProductToTheCartSuccessfully() throws InterruptedException {

        homePage.mouseHoverOnComputerTab();
        homePage.clickOnNotebookLink();

        String expectedText = "Notebooks";
        String actualText = notebooksPage.getPageNavigationText();
        softAssert.assertEquals(expectedText,actualText);


        //notebooksPage.actualPriceListInLowToHigh();
       List<Double> expectedPriceList = notebooksPage.expectedPriceListInLowToHigh();
       List<Double> actualPriceList = notebooksPage.actualPriceListInLowToHigh();
       Collections.sort(expectedPriceList);
        System.out.println(expectedPriceList);
        System.out.println(actualPriceList);

       softAssert.assertEquals(expectedPriceList,actualPriceList);

        List<Double> expectedPriceList2 = notebooksPage.expectedSortByHighToLowPrice();
        List<Double> actualPriceList2 = notebooksPage.actualSortByHighToLowPrice();

        Collections.sort(expectedPriceList2);
        Collections.reverse(expectedPriceList2);

        System.out.println(expectedPriceList2);
        System.out.println(actualPriceList2);

        softAssert.assertEquals(expectedPriceList2,actualPriceList2);


        List<String> expectedProductTitle = notebooksPage.expectedProductTitleAToZ();
        List<String> actualProductTitle = notebooksPage.actualProductTitleAtoZ();
        Collections.sort(expectedProductTitle);

        System.out.println(expectedProductTitle);
        System.out.println(actualProductTitle);

        softAssert.assertEquals(expectedProductTitle,actualProductTitle);






       softAssert.assertAll();



    }


}
