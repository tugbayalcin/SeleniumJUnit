package day06_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_IlkTestMethodu
{
    WebDriver driver;

    @Test
    public void test01()
    {
        // amazon.com'a gidelim ve title'in "amazon" icerdigini test edelim
        driver.get("https://www.amazon.com");
        String actualTitle = driver.getTitle();
        String arananKelime = "amazon";
        System.out.println(actualTitle.contains(arananKelime) ? "Amazon Testi Passed" : "Amazon Testi Failed");

    }

    @Test
    public void test02()
    {
        // google' a gidelim ve basligin "google" icerdigini test edelim
        driver.get("https://www.google.com/");
        String actualTitle = driver.getTitle();
        String arananKelime = "google";
        System.out.println(actualTitle.contains(arananKelime) ? "Google Testi Passed" : "Google Testi Failed");


    }
    @Before
    public void ayarlariDuzenle()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void ortaligiTopla()
    {
        driver.close();
    }
}
