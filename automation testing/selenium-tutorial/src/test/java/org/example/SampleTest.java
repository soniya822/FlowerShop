package org.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sanoj Indrasinghe
 */
public class SampleTest {

    @Test 
    public void test(){

        // Initializing the WebDriver - Here we are going to open a Chrome web page
        WebDriver driver = new EdgeDriver();

        /*This is the object we use to implicitly tell the script
        how long to wait until a certain element is visible or available to proceed*/
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(4));

        /*The Chrome opened initially does not have the maximum screen size.
        Here we are telling the driver to have the maximum size of the screen*/
        driver.manage().window().maximize();

        /*Giving the URL to navigate to*/
        driver.get("http://localhost/flower%20store%20website/shop.php");

        /*Looking for the web element having the text "LIFE AT SAEGIS" and then perform the click function
        this can be written in one line as
        driver.findElement(By.linkText("LIFE AT SAEGIS")).click() too.
        The example shows we can get any web element and saved to a variable of "WebElement" type
        and perform any action */
        WebElement e = driver.findElement(By.linkText("LIFE AT SAEGIS"));
        e.click();

        /*The wait object we created above is used here to halt the execution of the script
        until the "LIFE AT SAEGIS" menu item is
        visible.
        there are simpler ways to write the wait statement below, but in the example,
        a lambda function is used.
        to understand "->" syntax, find - What is a lambda function? */
        wait.until(d -> d.findElement(By.className("entry-title")).isDisplayed());


        // What is a "relative" xpath?
        // What is an "absolute" xpath?
        String studentLife = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/section[1]/div/div/div/div/div")).getText();
        System.out.println("This is the LIFE AT SAEGIS page content : ");
        System.out.println(studentLife);


        driver.findElement(By.linkText("CONTACT US")).click();

        wait.until(d -> d.findElement(By.className("elementor-heading-title")).isDisplayed());

        /*Here we have given an xpath common to all contact us sections
        for ex:
        the "Head Office" xpath is - /html/body/div[2]/section[2]/div[2]/div/div/section[2]/div/div[1]
        the "Mailing address" xpath is - /html/body/div[2]/section[2]/div[2]/div/div/section[2]/div/div[2]
        the "Hotline" xpath is - /html/body/div[2]/section[2]/div[2]/div/div/section[2]/div/div[3]
        Note that all above Xpaths are different at the end div[] tag.
        bu removing the number we can get all the div tags at once. (as below)
        */
        System.out.println("==========CONTACT US===========");
        List<WebElement> elements = new ArrayList<>(driver.findElements(By.xpath("/html/body/div[2]/section[2]/div[2]/div/div/section[2]/div/div")));
        for(WebElement element : elements){
            System.out.println(element.getText());
            System.out.println("--------");
        }

        // Go to https://www.selenium.dev/documentation/ to learn selenium


    }
}
