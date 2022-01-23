package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BestBuyAssertions
{
    //1) Bir class oluşturun: BestBuyAssertions

    WebDriver driver;

    @Before
    public void setup()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01()
    {
        //2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
        driver.get("https://www.bestbuy.com/");

        //		○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
        String actualURL = driver.getCurrentUrl();
        String expectedURL ="https://www.bestbuy.com/";

        Assert.assertEquals("Lutfen Test Degerlerini Gozden Geciziniz. ",expectedURL,actualURL);
        // test passed oldugunda message yazdirilmaz
        // burada once expected sonra actual verilmesi onemli
        // yani siralama onemli
        // test gecemz ise sol alt kutudan ustune tiklayip detaylari goerebilirsin

        //		○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        String actualTitle = driver.getTitle();
        String istenmeyenKelime = "Rest";
        // ! ile contains i tersine cevirme buradayok, assertTrue var assertFalse var
        // o zaman biz false sececegiz

        Assert.assertFalse(actualTitle.contains(istenmeyenKelime));


        //		○ logoTest => BestBuy logosunun görüntülendigini test edin
        WebElement logoElementi = driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));
        Assert.assertTrue("Logo Gorunmuyor", logoElementi.isDisplayed());

        //		○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        WebElement francaisElementi = driver.findElement(By.xpath("//button[text()='Français']"));
        Assert.assertTrue(francaisElementi.isDisplayed());

    }

    @After
    public void teardown()
    {
        driver.close();
    }
}
