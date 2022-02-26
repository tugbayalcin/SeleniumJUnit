package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class Q01
{
    /*
...Exercise1...
BeforeClass ile driver ı olusturun ve class icinde static yapin
Maximize edin, 15 sn bekletin
http://www.google.com adresine gidin
arama kutusuna "Green Mile" yazip, cikan sonuc sayisini yazdirin
arama kutusuna  "Premonition" yazip, cikan sonuc sayisini yazdirin
arama kutusuna  "The Curious Case of Benjamin Button" yazip, cikan sonuc sayisini yazdirin
AfterClass ile kapatın

 */
    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Before
    public void testtenOnce(){
        driver.get("http://www.google.com");

    }
    @Test
    public void test01(){
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Green Mile" + Keys.ENTER);

    }

    @Test
    public void test02(){
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Premonition"+ Keys.ENTER);
    }


    @Test
    public void test03(){
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("The Curious Case of Benjamin Button"+ Keys.ENTER);
    }


    @After
    public void testtenSonre(){
        System.out.println("Sonuc Yazisi: " + (driver.findElement(By.xpath("//div[@id='result-stats']")).getText()));
//div[@id='result-stats']
    }

    @AfterClass
    public static void teardown(){
        driver.close();
    }

}
