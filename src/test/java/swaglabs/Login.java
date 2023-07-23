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

    public static final String USER_NAME_ID = "user-name";
    public static final String PASSWORD_ID = "password";
    public static final String SHOPPING_CART_CONTAINER_ID = "shopping_cart_container";
    public static final String LOGIN_BUTTON_ID = "login-button";

    @Test
    public void Login() {

        WebDriver driver = DriverFactory.newDriver();
        driver.get(SWAG_LABS_HOME);

        WebElement user_name = driver.findElement(By.id(USER_NAME_ID));
        user_name.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id(PASSWORD_ID));
        password.sendKeys("secret_sauce");

        WebElement  login_button = driver.findElement(By.id(LOGIN_BUTTON_ID));
        login_button.click();

        WebElement shoppingCartIcon = WaitingUtils.waitUntilClickable(driver, By.id(SHOPPING_CART_CONTAINER_ID));




        Assert.assertTrue(shoppingCartIcon.isDisplayed());

        DemoHelper.pause();
        driver.quit();
    }
}
