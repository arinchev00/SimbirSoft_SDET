import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test1 {

    @Test
    public static void test1() {

            // Предусловие:
            //1. Открыть браузер
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


            //2. Перейти на страницу входа: https://www.saucedemo.com/
        try {
            driver.get("https://www.saucedemo.com/");
            Thread.sleep(2000);

            //3. Заполнить поле Username значением standard_user
            WebElement inputUser = driver.findElement(By.xpath("//input[@placeholder='Username']"));    // Метод xpath
            inputUser.sendKeys("standard_user");

            //4. Заполнить поле Password значением secret_sauce
            WebElement inputPass = driver.findElement(By.id("password"));                                           // Метод id
            inputPass.sendKeys("secret_sauce");
            Thread.sleep(2000);

            //5. Нажать на кнопку LOGIN
            WebElement button = driver.findElement(By.cssSelector(".submit-button.btn_action"));                     // Метод css
            button.click();
            Thread.sleep(2000);

            // Шаги воспроизведения:
            //1. Положить первый продукт в списке на странице PRODUCTS в корзину кнопкой ADD TO CART
            WebElement button1 = driver.findElement(By.xpath("//button[@name='add-to-cart-sauce-labs-backpack']"));
            button1.click();
            Thread.sleep(2000);

            //2. Нажать на иконку корзины
            WebElement basket = driver.findElement(By.cssSelector(".shopping_cart_link"));
            basket.click();
            Thread.sleep(2000);

            //3. На открывшейся странице корзины нажать на кнопку CHECKOUT
            WebElement checkout = driver.findElement(By.id("checkout"));
            checkout.click();
            Thread.sleep(2000);

            //4. На открывшейся странице CHECKOUT: YOUR INFORMATION заполнить поля First Name, Last Name,
            // Zip Code значением test
            WebElement inputNameFirst = driver.findElement(By.id("first-name"));                                           // Метод id
            inputNameFirst.sendKeys("test");

            WebElement inputNameLast = driver.findElement(By.id("last-name"));                                           // Метод id
            inputNameLast.sendKeys("test");

            WebElement inputZip = driver.findElement(By.id("postal-code"));                                           // Метод id
            inputZip.sendKeys("test");
            Thread.sleep(2000);

            //5. Нажать на кнопку CONTINUE
            WebElement contin = driver.findElement(By.id("continue"));
            contin.click();
            Thread.sleep(2000);

            //6. На открывшейся странице CHECKOUT: OVERVIEW нажать кнопку FINISH
            WebElement finish = driver.findElement(By.id("finish"));
            finish.click();
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            driver.quit();
        }

    }
}
