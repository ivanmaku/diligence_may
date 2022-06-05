package EtsyTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestCase4Ahmad extends TestBase{
    @Test
    public void nextPageButton() {

        WebElement clothingAndShoes = driver.findElement(By.partialLinkText("Clothing & Shoes"));
        clothingAndShoes.click();

        WebElement bagsAndPurses = driver.findElement(By.partialLinkText("Bags & Purses"));
        bagsAndPurses.click();

        WebElement minimalist = driver.findElement(By.linkText("Minimalist"));
        minimalist.click();

        WebElement nextButton = driver.findElement(By.linkText("Next"));

        for (int i = 0; ; i++) {
            nextButton.click();
            if (nextButton.getAttribute("class").contains("is-disabled"))
                break;
        }
//        driver.get("https://www.etsy.com/search/bags-and-purses?ref=pagination&q=Minimalist&page=247");
//        nextButton = driver.findElement(By.linkText("Next"));
//        for (int i = 0;; i++) {
//            nextButton.click();
//            if (nextButton.getAttribute("class").contains("is-disabled"))
//                break;
//        }

    }
}
