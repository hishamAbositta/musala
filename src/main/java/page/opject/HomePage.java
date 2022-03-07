package page.opject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Utils;


public class HomePage {
    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getContactUseBtn() {
        return Utils.waitToBeClickable(driver, By.xpath("//span[contains(text(),'Contact us')]"), 30);
    }

    public WebElement Company() {
        return Utils.waitToBeClickable(driver, By.xpath("//header/nav[2]/div[1]/div[1]/ul[1]/li[1]/a[1]"), 30);
    }

    public WebElement Careers() {
        return Utils.waitToBeClickable(driver, By.xpath("//header/nav[2]/div[1]/div[1]/ul[1]/li[5]/a[1]"), 30);
    }

}
