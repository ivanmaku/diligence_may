package EtsyTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestCase3Davie extends TestBase {
    @Test
    public void testSkirt() throws InterruptedException {

        WebElement hoverButton = driver.findElement(By.id("catnav-primary-link-10923"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverButton).perform();
        Thread.sleep(1000);

        WebElement skirtsButton = driver.findElement(By.partialLinkText("Skirts"));
        skirtsButton.click();
        Thread.sleep(1000);

        List<WebElement> allItems = driver.findElements(By.xpath("//*[@id='content']//div[@data-appears-component-name='category_listings_group']"));
        List<String> items = new ArrayList<>();

        for (WebElement item : allItems) {

            items.add(item.getText());
            //System.out.println("\n" + item.getText() + "\n");
            Assert.assertTrue(item.getText().toLowerCase().contains("skirt")); // fails, meaning not all items are skirts

        }
    }
}
