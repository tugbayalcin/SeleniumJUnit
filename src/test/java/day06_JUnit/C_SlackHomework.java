package day06_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C_SlackHomework
{
    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void Test01(){

        // https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String windowHandleDegeri1 = driver.getWindowHandle();

        // Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement textElementi = driver.findElement(By.xpath("//h3"));

        String actualText = textElementi.getText();
        String expectedText = "Opening a new window";

        Assert.assertEquals("Text Testi Failed",expectedText,actualText);

        // Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";

        Assert.assertEquals("Title Testi Failed",expectedTitle,actualTitle);

        // Click Here butonuna basın.
        driver.findElement(By.xpath("//a[@href='/windows/new']")).click();

        // Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        Set<String> handleDegerleriSet = driver.getWindowHandles();
        String windowHandleDegeri2 = "";
        for(String each : handleDegerleriSet){
            if(!each.equals(windowHandleDegeri1)){
                windowHandleDegeri2 = each;
            }
        }
        driver.switchTo().window(windowHandleDegeri2);

        String actualTitle2 = driver.getTitle();
        String expectedTitle2 = "New Window";

        Assert. assertEquals("Title2 Testi Failed",expectedTitle2,actualTitle2);

        // Sayfadaki textin “New Window” olduğunu doğrulayın.
        String actualText2 = driver.findElement(By.xpath("//h3")).getText();
        String expectedText2 = "New Window";

        Assert.assertEquals("Text2 Testi Failed.",expectedText2,actualText2);

        // Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(windowHandleDegeri1);
        String actualTitle3 = driver.getTitle();
        String expectedTitle3 = "The Internet";

        Assert.assertEquals("3.Title Testi Failed",expectedTitle3,actualTitle3);



    }

    @AfterClass
    public static void teardown(){
        driver.close();
    }



}
