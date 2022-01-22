package day06_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_TekrarTesti
{
    public static void main(String[] args)
    {
        //1-C01_TekrarTesti isimli bir class olusturun
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

        //3- cookies uyarisini kabul ederek kapatin // cikarsa yapman gerek, duruma gore ilgili butonu click edeceksin
        // driver.findElement(By.xpath("")).click();

        //4-Sayfa basliginin “Google” ifadesi icerdigini test edin
        String actualSayfaTitle = driver.getTitle();
        String arananKelime = "Google";

        System.out.println(actualSayfaTitle.contains(arananKelime) ? "Title Testi Passed" : "Title Testi Failed");

        //5- Arama cubuguna “Nutella” yazip aratin
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@name='q']"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        //6-Bulunan sonuc sayisini yazdirin
        WebElement sonucSayisiElementi = driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println("Cikan Sonuc Sayisi: " +sonucSayisiElementi.getText());

        //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        String sonucSayisiString = sonucSayisiElementi.getText();
        String sonucKelimeleri[] = sonucSayisiString.split(" ");
        String sonucNutellaSayisiString = sonucKelimeleri[1];
        sonucNutellaSayisiString = sonucNutellaSayisiString.replace(".","");
        int sonucNutellasayisiInteger = Integer.valueOf(sonucNutellaSayisiString);
        System.out.println((sonucNutellasayisiInteger > 10000000)
                ? "Sonuc 10 milyondan buyuk testi Passed"
                : "Sonuc 10 milyondan buyuk testi Failed" );

        //8-Sayfayi kapatin
        driver.close();
    }
}
