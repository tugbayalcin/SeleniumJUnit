package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.est.LimitedSource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C_SlackHomework_Q7
{

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test01(){

        // 1) "https://www.facebook.com/" SAYFASINA GiDiN
        driver.get("https://www.facebook.com/");

        // 2) YENi HESAP OLUSTUR BUTONUNA TIKLAYIN
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        // 3) DOGUM TARiHi BOLUMUNDEKi GUNLERiN LiSTESiNi ALIN
        WebElement dogumGunuElementi = driver.findElement(By.name("birthday_day"));
        Select select = new Select(dogumGunuElementi);
        List<WebElement> optionGunList = select.getOptions();
        for (WebElement each:optionGunList)
        {
            System.out.println(each.getText());
        }
        System.out.println("******************");

        // 4) DOGUM TARiHi BOLUMUNDEKi AYLARIN LiSTESiNi ALIN
        WebElement dogumAyiElementi = driver.findElement(By.name("birthday_month"));
        select = new Select(dogumAyiElementi);
        List<WebElement> optionAyList = select.getOptions();
        for (WebElement each:optionAyList)
        {
            System.out.println(each.getText());
        }
        System.out.println("******************");

        // 5) DOGUM TARiHi BOLUMUNDEKi YILLARIN LiSTESiNi ALIN
        WebElement dogumYiliElementi = driver.findElement(By.name("birthday_year"));
        select = new Select(dogumYiliElementi);
        List<WebElement> optionYilList = select.getOptions();
        for (WebElement each:optionYilList)
        {
            System.out.println(each.getText());
        }
        System.out.println("******************");

    }
    @After
    public void teardown(){
        driver.close();
    }
}
