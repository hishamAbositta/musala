package page.opject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Utils;

public class ContactUsPage {
    private final WebDriver driver;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement Name() {
        return Utils.waitToBeClickable(driver, By.xpath("//input[@id='cf-1']"), 30);
    }

    public WebElement Email() {
        return Utils.waitToBeClickable(driver, By.xpath("//input[@id='cf-2']"), 30);
    }

    public WebElement Subject() {
        return Utils.waitToBeClickable(driver, By.xpath("//input[@id='cf-4']"), 30);
    }

    public WebElement message() {
        return Utils.waitToBeClickable(driver, By.xpath("//textarea[@id='cf-5']"), 30);
    }

    public WebElement Send() {
        return Utils.waitToBeClickable(driver,
                By.xpath("//body/div[@id='fancybox-wrap']/div[@id='fancybox-outer']/div[@id='fancybox-content']/div[1]/div[1]/div[1]/form[1]/div[2]/p[1]/input[1]"), 30);
    }

    public WebElement ErrorMessage() {
        return Utils.waitToBeClickable(driver,
                By.xpath("//span[contains(text(),'The e-mail address entered is invalid.')]"), 30);
    }
}
