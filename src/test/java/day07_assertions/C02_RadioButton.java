package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class C02_RadioButton
{
    WebDriver driver;
    @Before
    public void setup()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Ignore //bu test calismaz - testNG'de @Test(enabled=false)
    @Test
    public void test01() throws InterruptedException {
        //https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");

        //Cookies’i kabul edin
        //“Create an Account” button’una basin
        WebElement createAnAccountElementi = driver.findElement(By.xpath("(//a[@role='button'])[2]"));
        createAnAccountElementi.click();

        //“radio buttons” elementlerini locate edin
        WebElement radioButtonElementi1 = driver.findElement(By.xpath("(//label[@class='_58mt'])[1]"));
        WebElement radioButtonElementi2 = driver.findElement(By.xpath("(//label[@class='_58mt'])[2]"));
        WebElement radioButtonElementi3 = driver.findElement(By.xpath("(//label[@class='_58mt'])[3]"));

        //Secili degilse cinsiyet butonundan size uygun olani secin

        Thread.sleep(1000);
        if(!radioButtonElementi1.isSelected())
        {
            radioButtonElementi1.click();
        }
        Thread.sleep(1000);
        radioButtonElementi1.click();
    }

    @After
    public void teardown()
    {
        driver.close();
    }
}
