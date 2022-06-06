package EtsyTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestCase1Candan extends TestBase{

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

            WebElement saleButton = driver.findElement(By.xpath("//a[contains(text(), 'On sale')]"));

            Assert.assertTrue(saleButton.isDisplayed());
        }
    }
