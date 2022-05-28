/*
Otići na https://www.stealmylogin.com/demo.html, uneti bilo koje kredencijale za login, prisisnuti dugme.
Izvršiti proveru da je, nakon logina, URL promenjen na https://example.com/ kroz grananje.
 Ako jeste, štampati “Nice”. Ako nije, štampati “Not nice.”
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Korisnik\\Desktop\\IT bootcamp\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.stealmylogin.com/demo.html");
        driver.manage().window().maximize();

        WebElement username=driver.findElement(By.xpath("/html/body/form/input[1]"));
        username.sendKeys("bla");
        WebElement password=driver.findElement(By.xpath("/html/body/form/input[2]"));
        password.sendKeys("bla");
        WebElement login=driver.findElement(By.xpath("/html/body/form/input[3]"));
        login.submit();
        String expectedAddress="https://example.com/";
        if(Objects.equals(driver.getCurrentUrl(), expectedAddress)){
            System.out.println("Nice!");
        }else{
            System.out.println("Not nice!");
        }

        driver.close();
    }
}
