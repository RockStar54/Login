import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginBadTest {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\OMEN\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");


        WebDriver driver = new ChromeDriver();


        driver.get("https://the-internet.herokuapp.com/login");


        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys("BadName");


        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("BadPassword");

        driver.findElement(By.cssSelector("button[type='submit']")).click();

        String errorMessage = "Your username is invalid!";

        assert driver.findElement(By.cssSelector("#flash")).getText().contains(errorMessage);
        assert driver.findElement(By.cssSelector("#flash")).getAttribute("class").contains("error");

        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        assert driver.findElement(By.cssSelector("#flash")).getText().contains(errorMessage);
        assert driver.findElement(By.cssSelector("#flash")).getAttribute("class").contains("error");

        driver.close();


    }
}
