package day06_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_TekrarTesti2
{
    public static void main(String[] args)
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1. “https://www.saucedemo.com” Adresine gidin"
        driver.get("https://www.saucedemo.com");

        //2. Username kutusuna “standard_user” yazdirin
        WebElement usernameTextBox = driver.findElement(By.xpath("(//input[@class='input_error form_input'])[1]"));
        usernameTextBox.sendKeys("standard_user");

        //3. Password kutusuna “secret_sauce” yazdirin
        WebElement passwordTextBox = driver.findElement(By.xpath("(//input[@class='input_error form_input'])[2]"));
        passwordTextBox.sendKeys("secret_sauce");

        //4. Login tusuna basin
        WebElement loginButton = driver.findElement(By.xpath("//input[@class='submit-button btn_action']"));
        loginButton.click();

        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement ilkUrunElementi = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]"));
        String ilkUrunIsmi =ilkUrunElementi.getText();
        ilkUrunElementi.click();

        //6. Add to Cart butonuna basin
        driver.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']")).click();

        //7. Alisveris sepetine tiklayin
        WebElement alisverisSepetiElementi = driver.findElement(By.id("shopping_cart_container"));
        alisverisSepetiElementi.click();

        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement alisverisSepetindekiUrunElementi = driver.findElement(By.className("inventory_item_name"));
        String sepettekiUrurnIsmi = alisverisSepetindekiUrunElementi.getText();
        System.out.println(sepettekiUrurnIsmi.equals(ilkUrunIsmi)
                ? "Urun Sepete Eklendi Testi Passed"
                : "Urun Sepete Eklendi Testi Failed");

        //9. Sayfayi kapatin
        driver.close();

    }
}
