package swaglabs;

import helper.DemoHelper;
import helper.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import wait.WaitingUtils;

import static helper.Pages.SWAG_LABS_HOME;

public class Login {

    @Test
    public void Login() {

        WebDriver driver = DriverFactory.newDriver();
        driver.get(SWAG_LABS_HOME);

        WebElement user_name = driver.findElement(By.id("user-name"));
        user_name.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement  login_button = driver.findElement(By.id("login-button"));
        login_button.click();

        WebElement shoppingCartIcon = WaitingUtils.waitUntilClickable(driver, By.id("shopping_cart_container"));




        Assert.assertTrue(shoppingCartIcon.isDisplayed());

        DemoHelper.pause();
        driver.quit();
    }
}
