package EtsyTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestCase5Monica extends TestBase{
    @Test
    public void PriceHighToLowSorting() throws InterruptedException {

        driver.navigate().to("https://www.etsy.com/?ref=lgo");

        WebElement clothingAndShoes = driver.findElement(By.xpath("//a[@href=\"/c/clothing-and-shoes?ref=catnav-10923\"]"));
        Thread.sleep(1500);
        clothingAndShoes.click();

        WebElement allFilter = driver.findElement(By.xpath("//span[contains(text(),\"All Filters\")]"));
        allFilter.click();

        WebElement lowBox = driver.findElement(By.xpath("//input[@placeholder=\"Low\"]"));
        lowBox.sendKeys("30");
        Thread.sleep(1500);

        WebElement highBox = driver.findElement(By.xpath("//input[@placeholder=\"High\"]"));
        highBox.sendKeys("50");
        Thread.sleep(1500);

        WebElement apply = driver.findElement(By.xpath("//button[@aria-label=\"Apply\"]"));
        apply.click();
        Thread.sleep(1500);

        WebElement priceRange = driver.findElement(By.xpath("//a[contains(text(),\"$30 – $50\")]"));
        Assert.assertEquals(priceRange.isDisplayed(), true);

        WebElement Relevanvy = driver.findElement(By.xpath("//div[@class=\"wt-show-lg wt-hide-xs\"]"));
        Relevanvy.click();
        Thread.sleep(1500);
//    Select select =new Select(Relevanvy);
//    select.selectByIndex(1);

        WebElement highestPrice = driver.findElement(By.xpath("//a[contains(text(),\" Highest Price\")]"));
        highestPrice.click();

        List<WebElement> toysPricesList = driver.findElements(By.xpath("//p[@class=\"wt-text-title-01\"]/span[2]"));

        List<String> actualPrices = new ArrayList<>();
        List<String> expectedPrices = new ArrayList<>();

        for (WebElement eachPrice : toysPricesList) {
            actualPrices.add(eachPrice.getText());
            expectedPrices.add(eachPrice.getText());
        }

        Collections.sort(expectedPrices);

        Collections.reverse(expectedPrices);
        System.out.println(actualPrices);
        System.out.println(expectedPrices);

        Assert.assertEquals(actualPrices, expectedPrices);

    }
}
