package EtsyTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase2Seden extends TestBase{
    @Test
    public void validateDropDown() {

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
}
