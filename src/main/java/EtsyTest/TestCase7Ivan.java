package EtsyTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestCase7Ivan extends TestBase{
    @Test
    public void clothingAndShoesHoverOver() throws InterruptedException {

        WebElement hoverButton = driver.findElement(By.id("catnav-primary-link-10923"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverButton).perform();
        Thread.sleep(1000);

        // WOMEN
        WebElement womenClothingText = driver.findElement(By.xpath("//*[@id=\"catnav-l3-10925\"]"));
        WebElement womenShoesText = driver.findElement(By.xpath("//*[@id=\"catnav-l3-10933\"]"));
        Assert.assertEquals(womenClothingText.getText().trim(), "Women's Clothing");
        Assert.assertEquals(womenShoesText.getText().trim(), "Women's Shoes");

        List<WebElement> womenClothing = driver.findElements(By.xpath("//*[@id=\"desktop-category-nav\"]/div[2]/div/div[2]/div/div/div/section[1]/div/ul[1]/li/ul/li/a"));
        for (WebElement cloth : womenClothing) {
            Assert.assertTrue(cloth.isDisplayed());
            Assert.assertTrue(cloth.getAttribute("href").contains("womens-clothing"));
        }
        List<WebElement> womenShoes = driver.findElements(By.xpath("//*[@id=\"desktop-category-nav\"]/div[2]/div/div[2]/div/div/div/section[1]/div/ul[2]/li[1]/ul/li/a"));
        for (WebElement shoe : womenShoes) {
            Assert.assertTrue(shoe.isDisplayed());
            Assert.assertTrue(shoe.getAttribute("href").contains("womens-shoes"));
        }

        // MEN
        WebElement menSection = driver.findElement(By.xpath("//*[@id=\"desktop-category-nav\"]/div[2]/div/div[2]/div/div/aside/ul/li[2]"));
        actions.moveToElement(menSection).perform();
        Thread.sleep(1000);

        WebElement menClothingText = driver.findElement(By.xpath("//*[@id=\"catnav-l3-10937\"]"));
        WebElement menShoesText = driver.findElement(By.xpath("//*[@id=\"catnav-l3-10940\"]"));
        Assert.assertEquals(menClothingText.getText().trim(), "Men's Clothing");
        Assert.assertEquals(menShoesText.getText().trim(), "Men's Shoes");

        List<WebElement> menClothing = driver.findElements(By.xpath("//*[@id=\"desktop-category-nav\"]/div[2]/div/div[2]/div/div/div/section[2]/div/ul[1]/li/ul/li/a"));
        for (WebElement cloth : menClothing) {
            Assert.assertTrue(cloth.isDisplayed());
            Assert.assertTrue(cloth.getAttribute("href").contains("mens-clothing"));
        }

        List<WebElement> menShoes = driver.findElements(By.xpath("//*[@id=\"desktop-category-nav\"]/div[2]/div/div[2]/div/div/div/section[2]/div/ul[2]/li[1]/ul/li/a"));
        for (WebElement shoe : menShoes) {
            Assert.assertTrue(shoe.isDisplayed());
            Assert.assertTrue(shoe.getAttribute("href").contains("mens-shoes"));
        }
    }

}
