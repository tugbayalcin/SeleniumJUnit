package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_YanlisEmailTesti
{
    // Bir class olusturalim YanliEmailTesti
    // http://automationpractice.com/index.php sayfasina gidelim
    static WebDriver driver;

    @BeforeClass
    public static void setup()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void signInTesti()
    {

    }

    @Test
    public void invalidEmailTesti()
    {

    }

    @AfterClass
    public static void teardown()
    {
        //driver.close();
    }
}
