import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test2 {

    @Test
    public static void test2() {

            // Предусловие:
            //1. Открыть браузер
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


            //2. Перейти на страницу входа: https://www.saucedemo.com/
        try {
            driver.get("https://www.saucedemo.com/");
            Thread.sleep(2000);

            // Шаги воспроизведения:
            //1. Заполнить поле Username значением test
            WebElement inputUser = driver.findElement(By.xpath("//input[@placeholder='Username']"));    // Метод xpath
            inputUser.sendKeys("test");

            //2. Заполнить поле Password значением test
            WebElement inputPass = driver.findElement(By.id("password"));                                           // Метод id
            inputPass.sendKeys("test");
            Thread.sleep(2000);

            //3. Нажать на кнопку LOGIN
            WebElement button = driver.findElement(By.cssSelector(".submit-button.btn_action"));                     // Метод css
            button.click();
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            driver.quit();
        }

    }
}
