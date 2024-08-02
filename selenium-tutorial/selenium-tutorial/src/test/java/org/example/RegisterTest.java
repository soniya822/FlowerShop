package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Author: Sanoj Indrasinghe
 */
public class RegisterTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        driver = new EdgeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            //driver.quit();
        }
    }

    @Test
    public void testRegister() {
        // Open the registration page
        driver.get("http://localhost/Flowershop/register.php");

        // Find and fill the name field
        WebElement nameField = driver.findElement(By.name("name"));
        nameField.sendKeys("Amantha");

        // Find and fill the email field
        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys("ama@gmail.com");

        // Find and fill the password field
        WebElement passwordField = driver.findElement(By.name("pass"));
        passwordField.sendKeys("123");

        // Find and fill the confirm password field
        WebElement confirmPasswordField = driver.findElement(By.name("cpass"));
        confirmPasswordField.sendKeys("123");

        // Find and click the register button
        WebElement registerButton = driver.findElement(By.name("submit"));
        registerButton.click();

        // Wait until the login page is loaded
        wait.until(ExpectedConditions.urlToBe("http://localhost/Flowershop/login.php"));

        // Verify registration success by checking the URL
        assertTrue(driver.getCurrentUrl().equals("http://localhost/Flowershop/login.php"), "Registration failed or redirection to login page not happened.");
    }
}
