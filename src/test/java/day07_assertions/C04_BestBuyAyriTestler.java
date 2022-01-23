package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BestBuyAyriTestler
{
    //1) Bir class oluşturun: BestBuyAssertions
    // Brfore class after class varsa STATIC olmak zorunda

    static WebDriver driver;

    @BeforeClass
    public static void setup()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.bestbuy.com/");
    }

    @Test
    public void urlTesti()
    {
        //2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin

        String actualURL = driver.getCurrentUrl();
        String expectedURL ="https://www.bestbuy.com/";
        Assert.assertEquals("Lutfen Test Degerlerini Gozden Geciziniz. ",expectedURL,actualURL);
    }
    @Test
    public void titleTesti()
    {
        // titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        String actualTitle = driver.getTitle();
        String istenmeyenKelime = "Rest";
        // ! ile contains i tersine cevirme buradayok, assertTrue var assertFalse var
        // o zaman biz false sececegiz

        Assert.assertFalse(actualTitle.contains(istenmeyenKelime));
    }

    @Test
    public void logoTesti()
    {
        // logoTest => BestBuy logosunun görüntülendigini test edin
        WebElement logoElementi = driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));
        Assert.assertTrue("Logo Gorunmuyor", logoElementi.isDisplayed());
    }

    @Test
    public void francaısTesti()
    {
        // FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        WebElement francaisElementi = driver.findElement(By.xpath("//button[text()='Français']"));
        Assert.assertTrue(francaisElementi.isDisplayed());
    }

    @AfterClass
    public static void teardown()
    {
        driver.close();
    }
}
