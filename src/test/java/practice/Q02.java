package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class Q02
{
      /*
...Exercise2...
   http://www.bestbuy.com 'a gidin,
   Sayfa basliginin "Best" icerdigini(contains) dogrulayin
   Ayrica Relative Locator kullanarak;
       logoTest => BestBuy logosunun gorunutulenip goruntulenmedigini dogrulayin
       mexicoLinkTest => Linkin gorunutulenip goruntulenmedigini dogrulayin


Relative locator kullan odev bu
*/
    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Before
    public void testtenOnce(){
        driver.get("http://www.bestbuy.com");
    }
    @Test
    public void titleTest(){
        String actualTitle = driver.getTitle();
        boolean iceriyorMu = actualTitle.contains("Best");
        Assert.assertTrue("Title Best Kelimesini Icermiyor",iceriyorMu);
    }

    @Test
    public void logoTest(){
        WebElement helloHeadingElementi = driver.findElement(By.xpath("(//div[@class='heading'])[1]"));
        WebElement logoElementi = driver.findElement(RelativeLocator.with(By.tagName("img")).above(helloHeadingElementi));
        boolean logoGorunuyorMu = logoElementi.isDisplayed();
        Assert.assertTrue("Logo Gorunmuyor",logoGorunuyorMu);

        // once hello yazisini locate ettik, ama relative xpath kullanirken en az iki yerrden dogrulama almmak
        // dogru elementi locate etmek acisindan onemlidir
    }

    @Test
    public void linkTest(){
        WebElement unitedStatesLink = driver.findElement(By.xpath("(//img[@alt='United States'])[1]"));
        WebElement mexicoLink = driver.findElement(RelativeLocator.with(By.tagName("a")).toRightOf(unitedStatesLink));
        //  tag name i a olan ve us'nin saginda olan diye locate ettik, yani aradigimiz elementin bir attribute'unu de kullandik
        Assert.assertTrue("Mexico Linki Gorunmuyor",mexicoLink.isDisplayed());

    }

    @AfterClass
    public static void testtenSonra(){
        driver.quit();
    }




}
