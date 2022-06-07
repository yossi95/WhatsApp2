import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class WhatsApp {
    private String msg;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String finder(String tel) {

        String baseUrl = "https://web.whatsapp.com/";
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\2\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://web.whatsapp.com/send?phone=" + tel);
        List<WebElement> infoElements = driver.findElements(By.className("_2UwZ_"));
        if (infoElements.size() > 0)
            infoElements.get(0).click();

        boolean succeed=false;
        while (!succeed)
            try {
                WebElement e = driver.findElement(By.cssSelector("div[title=\"הקלדת ההודעה\"]"));
                e.sendKeys(this.msg);
                e.sendKeys(Keys.ENTER);
                succeed=true;
                System.out.println("succeed");
            } catch (Exception e) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    System.out.println("failed");
                }
            }

        return null;
    }

}







