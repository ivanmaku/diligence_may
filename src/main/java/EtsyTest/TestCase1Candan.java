package EtsyTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestCase1Candan extends TestBase{

    @Test
    public void validateOnSaleBox() throws InterruptedException {

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
}
