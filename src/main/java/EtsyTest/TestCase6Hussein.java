package EtsyTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestCase6Hussein extends TestBase{

    @Test

    public void cart() throws InterruptedException {

        WebElement hoverButton = driver.findElement(By.id("catnav-primary-link-10923"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverButton).perform();
        Thread.sleep(1000);

        WebElement menSection = driver.findElement(By.xpath("//*[@id=\"desktop-category-nav\"]/div[2]/div/div[2]/div/div/aside/ul/li[2]"));
        actions.moveToElement(menSection).perform();
        Thread.sleep(1000);

        WebElement Shirts=driver.findElement(By.xpath("//a[@id='catnav-l4-10938']"));
        Shirts.click();

        WebElement randomItem = driver.findElement(By.xpath("//*[@id='content']//a[@class='listing-link wt-display-inline-block                 9081cfa06e214c2c  logged']"));
        randomItem.click();

        Thread.sleep(2000);

        WebElement addToCart = driver.findElement(By.xpath("//button[contains(text(),'Add to cart')]"));
        addToCart.click();

        WebElement cart = driver.findElement(By.xpath("//a[@aria-label='Cart']"));
        cart.click();




        //WebElement color=driver.findElement(By.xpath("//*[@id=\"variation-selector-0\"]/option[2]"));
        //color.click();



    }

}
