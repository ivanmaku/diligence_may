package EtsyTest;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestCases {

    @Test
    public void clothingAndShoesHoverOver() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.etsy.com/");
        driver.manage().window().maximize();


        WebElement hoverButton = driver.findElement(By.id("catnav-primary-link-10923"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverButton).perform();
        Thread.sleep(1000);


        List<WebElement> genderAndOtherType = driver.findElements(By.xpath("/html/body/div[3]/div[2]/div/div[2]/div/div/aside/ul/li/span"));

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


    @Test
    public void PriceHighToLowSorting() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.etsy.com/?ref=lgo");

        WebElement toyes = driver.findElement(By.xpath("//a[@href=\"/c/clothing-and-shoes?ref=catnav-10923\"]"));
        Thread.sleep(1500);
        toyes.click();

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
            List<Double> actualPrices = new ArrayList<>();
            List<Double> expectedPrices = new ArrayList<>();


//        for (WebElement eachPrice : toysPricesList) {
//            actualPrices.add(eachPrice.getText());
//            expectedPrices.add(eachPrice.getText());
//        }
            for (int i = 4; i < toysPricesList.size() - 1; i++) {
                actualPrices.add(Double.valueOf(toysPricesList.get(i).getText().replace("$","").trim()));
                expectedPrices.add(Double.valueOf(toysPricesList.get(i).getText().replace("$","").trim()));
        for (WebElement eachPrice : toysPricesList) {
            actualPrices.add(Double.valueOf(eachPrice.getText().replace("$","").trim()));
                expectedPrices.add(Double.valueOf(eachPrice.getText().replace("$","").trim()));

            }
//            for (int i = 4; i < toysPricesList.size() - 1; i++) {
//                actualPrices.add(Double.valueOf(toysPricesList.get(i).getText().replace("$","").trim()));
//                expectedPrices.add(Double.valueOf(toysPricesList.get(i).getText().replace("$","").trim()));
//            }

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


    @Test
    public void validateOnSaleBox() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.etsy.com/");
        driver.manage().window().maximize();

        WebElement clothesAndShoesButton = driver.findElement(By.xpath("//span[@id='catnav-primary-link-10923']"));
        clothesAndShoesButton.click();
        Thread.sleep(5000);
        WebElement allFiltersButton = driver.findElement(By.xpath("//span[@class='wt-hide-xs wt-show-md filter-expander']"));
        allFiltersButton.click();

        Thread.sleep(2000);
        WebElement onSaleBox = driver.findElement(By.xpath("//label[@for=\"special-offers-on-sale\"]"));
        onSaleBox.click();
        Thread.sleep(2000);

        WebElement applyButton = driver.findElement(By.xpath("//*[@id='search-filters-overlay']/div/div/div[2]/button[2]"));
        applyButton.click();

        //span[@class='wt-text-strikethrough']

        List<WebElement> allSaleItems = driver.findElements(By.xpath("//span[@class='wt-text-strikethrough']"));

            for (int i = 0; i < allSaleItems.size(); i++) {
                actualSaleItems.add(allSaleItems.get(i).getText().toLowerCase().trim());
                expectedSaleItems.add(allSaleItems.get(i).getText().toLowerCase().trim());
            }
            Assert.assertEquals(actualSaleItems, expectedSaleItems);
            System.out.println(actualSaleItems);
            System.out.println(expectedSaleItems);


        List<String> actualSaleItems = new ArrayList<>();
        List<String> expectedSaleItems = new ArrayList<>();

        for (int i = 0; i < allSaleItems.size(); i++) {
            actualSaleItems.add(allSaleItems.get(i).getText().toLowerCase().trim());
            expectedSaleItems.add(allSaleItems.get(i).getText().toLowerCase().trim());
            Assert.assertEquals(actualSaleItems, expectedSaleItems);
        }
        System.out.println(actualSaleItems);
        System.out.println(expectedSaleItems);

    }


    @Test
    public void nextPageButton() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.etsy.com/?ref=lgo");
        driver.manage().window().maximize();

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

    @Test
    public void validateDropDown() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.etsy.com/");
        driver.manage().window().maximize();

        WebElement clothesAndShoesButton = driver.findElement(By.xpath("//span[@id='catnav-primary-link-10923']"));
        clothesAndShoesButton.click();

        WebElement allFiltersButton = driver.findElement(By.xpath("//span[@class='wt-hide-xs wt-show-md filter-expander']"));
        allFiltersButton.click();

        WebElement shipToDropDown = driver.findElement(By.xpath("//select[@id='ship_to_select']"));
        Select select = new Select(shipToDropDown);
        select.selectByValue("TR");

        WebElement applyButton = driver.findElement(By.xpath("//*[@id='search-filters-overlay']/div/div/div[2]/button[2]"));
        applyButton.click();

        WebElement shipsToTurkey = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div[3]/div[2]/div[2]/div[7]/ul/li/ul/li/a"));
        Assert.assertTrue(shipsToTurkey.isDisplayed());


    }

    @Test
    public void testSkirt() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.etsy.com/");
        driver.manage().window().maximize();

        WebElement hoverButton = driver.findElement(By.id("catnav-primary-link-10923"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverButton).perform();
        Thread.sleep(1000);

        WebElement menSection = driver.findElement(By.xpath("//*[@id=\"desktop-category-nav\"]/div[2]/div/div[2]/div/div/aside/ul/li[2]"));
        actions.moveToElement(menSection).perform();
        Thread.sleep(1000);

    }

    @Test

    public void cart() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.etsy.com/");
        driver.manage().window().maximize();
        System.out.println("hussein");

        }

    @Test
    public void testCart() {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.etsy.com/");
            driver.manage().window().maximize();

            WebElement clothesAndShoesButton = driver.findElement(By.xpath("//span[@id='catnav-primary-link-10923']"));
            clothesAndShoesButton.click();

    }
}
