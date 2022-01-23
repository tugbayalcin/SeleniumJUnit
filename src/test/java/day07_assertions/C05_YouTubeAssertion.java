package day07_assertions;

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

public class C05_YouTubeAssertion
{

    //1) Bir class oluşturun: YoutubeAssertions
    //2) https://www.youtube.com adresine gidin
    //3) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin

    static WebDriver driver;

    @BeforeClass
    public static void setup()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.youtube.com");
    }

    @Test
    public void titleTesti()
    {
        // titleTest   => Sayfa başlığının “YouTube” oldugunu test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "YouTube";

        Assert.assertEquals("Lutfen Title'i Kontrol Ediniz",expectedTitle,actualTitle);
    }

    @Test
    public void imageTesti()
    {
        // imageTest   => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement iconElementi = driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[2]"));
        Assert.assertTrue(iconElementi.isDisplayed());
    }

    @Test
    public void searchBoxTesti()
    {
        // Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searchBoxElementi = driver.findElement(By.xpath("//input[@id='search']"));
        Assert.assertTrue(searchBoxElementi.isEnabled());
    }

    @Test
    public void wrongTitleTesti()
    {
        // wrongTitleTest  => Sayfa basliginin “youtube” olmadigini dogrulayin
        String titleElementi = driver.getTitle();
        String word = "youtube";
        Assert.assertFalse(titleElementi.equals(word));
    }

    @AfterClass
    public static void teardown()
    {
        driver.close();
    }
}
