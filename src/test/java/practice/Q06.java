package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Q06
{
    // Execise 6
    static WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void test01() throws InterruptedException {
        // 1. Amazon.com'a gidelim.
        driver.get("https://www.amazon.com/");

        // 2. DropDown üzerinde Books secelim.(All yazan yerde)
        WebElement dropdownMenuElementi = driver.findElement(By.xpath("//select[@class='nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown']"));
        Select select = new Select(dropdownMenuElementi);
        select.selectByVisibleText("Books");

        // (All yazan yerde) kategorilerin hepsini konsola yazdiralim
        List<WebElement> dropdownMenuListesi = select.getOptions();
        for(WebElement each : dropdownMenuListesi)
        {
            System.out.println(each.getText());
        }

        // 3. Arama kutusuna Les Miserables yazalım ve arama yapalim.
        WebElement aramaKutusuElementi = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusuElementi.sendKeys("Les Miserables" + Keys.ENTER);

        // 4. Sonuc sayisini ekrana yazdiralim.
        WebElement sonucYazisiElementi = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println(sonucYazisiElementi.getText());

        // 5. Sonucların Les Miserables i icerdigini assert edelim
        String arananKelime = "Les Miserables";
        boolean kosul = sonucYazisiElementi.getText().contains(arananKelime);
        Assert.assertTrue("Sonuc yazisi " + arananKelime + " ifadesini icermemektedir.",kosul);
        Thread.sleep(1000);

    }

    @After
    public void teardown(){
        driver.close();
    }



}
