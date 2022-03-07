package page.opject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Utils;

public class FaceBookPage {
    private final WebDriver driver;

    public FaceBookPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement FaceBookImage() {
        return Utils.waitToBeClickable(driver, By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/div[1]/svg[1]/g[1]/image[1]"), 30);
    }
}
