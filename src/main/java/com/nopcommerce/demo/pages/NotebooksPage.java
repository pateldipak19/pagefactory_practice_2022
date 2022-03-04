package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.List;

public class NotebooksPage extends Utility {

    private static final Logger log = LogManager.getLogger(NotebooksPage.class.getName());

    @FindBy(xpath = "//h1[contains(text(),'Notebooks')]")
    WebElement _NotebooksText;

    @FindBy(id = "products-orderby")
    WebElement _sortBy;

    @FindBy(xpath = "//select[@id='products-orderby']")
    WebElement _sortByOptions;

    @FindBys({@FindBy(xpath = "//span[@class='price actual-price']")})
    List<WebElement> _defaultSortedPrices;

    @FindBys({@FindBy(xpath = "//h2[@class='product-title']")})
    List<WebElement> _productTitles;

    @FindBys({@FindBy(xpath = "//div[@class='product-rating-box']/div/div[@style]")})
    List<WebElement> _ratingStarWidths;


    public String getPageNavigationText() {
        Reporter.log("Getting Page navigation text from element " + _NotebooksText.toString() + "<br>");
        log.info("Getting Page navigation text from element " + _NotebooksText.toString());
        return getTextFromElement(_NotebooksText);


    }

    public void clickOnSortByDropDown() {
        Reporter.log("Clicking on Sortby option " + _sortBy.toString() + "<br>");
        clickOnElement(_sortBy);
        log.info("Clicking on Sortby option " + _sortBy.toString());

    }


    public void selectSortingOptionFromSortByDropDown(String value) {
        Reporter.log("Selecting option of A to Z sorting " + _sortByOptions.toString() + "<br>");
        selectByValueFromDropDown(_sortByOptions, value);
        log.info("Selecting option of A to Z sorting " + _sortByOptions.toString());
    }


    public List<Double> expectedPriceListInLowToHigh() throws InterruptedException {

        List<Double> defaultPriceInDouble = new ArrayList<>();

        for (WebElement a : _defaultSortedPrices) {

            Thread.sleep(1000);
            defaultPriceInDouble.add(Double.valueOf(a.getText().replace("$", "")
                    .replace(",","")));
        }


        return defaultPriceInDouble;
    }


    public List<Double> actualPriceListInLowToHigh() throws InterruptedException {


        clickOnElement(_sortBy);
        selectByValueFromDropDown(_sortByOptions, "10");
        Thread.sleep(1000);

       // List<WebElement> lowToHighPriceListFilter = driver.findElements(By.className("price actual-price"));

        List<Double> lowToHighPriceInDouble = new ArrayList<>();

        for (WebElement a : _defaultSortedPrices) {

            lowToHighPriceInDouble.add(Double.valueOf(a.getText().replace("$", "")
                    .replace(",","")));

        }

        return lowToHighPriceInDouble;
    }



    public List<Double> expectedSortByHighToLowPrice()  {

        return sortByForPrices(_defaultSortedPrices);


    }

    public List<Double> actualSortByHighToLowPrice() throws InterruptedException {

        clickOnElement(_sortBy);
        selectByValueFromDropDown(_sortByOptions, "11");
        Thread.sleep(1000);
        return sortByForPrices(_defaultSortedPrices);

    }


    public List<String> expectedProductTitleAToZ(){

        return sortByForProductsByName(_productTitles);
    }

    public List<String> actualProductTitleAtoZ() throws InterruptedException {

        clickOnElement(_sortBy);
        selectByValueFromDropDown(_sortByOptions, "5");
        Thread.sleep(1000);

        return sortByForProductsByName(_productTitles);
    }


    public List<Double> expectedSortByRating(){

        List<Double> defaultStars = new ArrayList<>();

        for (WebElement r : _ratingStarWidths) {

            defaultStars.add(Double.valueOf(r.getText().replace("width:","")
                    .replace("%","")));

        }

        return defaultStars;
    }


    public List<Double> actualSortByRating(){

        List<Double> defaultStars = new ArrayList<>();

        for (WebElement r : _ratingStarWidths) {

            defaultStars.add(Double.valueOf(r.getText().replace("width:","")
                    .replace("%","")));

        }

        return defaultStars;
    }
}
